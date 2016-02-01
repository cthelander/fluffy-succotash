package ast;
import compiler.Failure;

/** Abstract syntax for global variable definitions.
 */
public class Globals extends Defn {

    /** The type of the variable(s) being defined.
     */
    private Type type;

    /** The names and initial values of the variables.
     */
    private VarIntro[] vars;

    /** Default constructor.
     */
    public Globals(Type type, VarIntro[] vars) {
        this.type = type;
        this.vars = vars;
    }

    /** Print an indented description of this definition.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "Globals");
        out.indent(n+1, type.toString());
        for (int i = 0; i < vars.length; i++) {
           vars[i].indent(out, n+1);
        }
    }

    /** Extend the environments in the given context with entries from
     *  this definition.
     */
    void extendGlobalEnv(Context ctxt)
      throws Failure {
        for (int i=0; i<vars.length; i++) {
           vars[i].extendGlobalEnv(ctxt, type);
        }
    }

    /** Declare storage for global variables.
     */
    LocEnv declareGlobals(Assembly a, LocEnv env) {
        // Initialize global variables:
        for (int i=0; i<vars.length; i++) {
           env = vars[i].declareGlobals(a, env);
        }
        return env;
    }

    /** Generate compiled code for a function.
     */
    void compileFunction(Assembly a, LocEnv globals) {
        // Nothing to do here, but this method is required
        // because Globals extends Defn.
    }


    /** Generate compiled code for globals Including a 
        new function where they are initialized.
     */
    void compileGlob (Assembly a, LocEnv env, Frame f) {
        int x = vars.length;        
        Expr [] e;
        
        // Get all of the expressions that are on the right side of the 
        // global variable definitions.
        e = new Expr[x];
        for(int i = 0; i < x; ++i){
            e[i] = vars[i].GetExpr();
        }
        // Compiles all of the expressions that were retrived above. This
        // will display assembly code and since this function was called 
        // inside of the function in defn they will be put in to the 
        // initGlobals function.
        for(int i = 0; i < x; ++i){
            e[i].compileExpr(a, f) ;
            f.store32(a, vars[i].name);
        }
    }
}
