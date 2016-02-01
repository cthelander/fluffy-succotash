package ast;
import compiler.Failure;

/** Abstract syntax for definitions (either global variables or functions.
 */
public abstract class Defn {

    /** Print an indented description of this definition.
     */
    public abstract void indent(IndentOutput out, int n);

    /** Extend the environments in the given context with entries from
     *  this definition.
     */
    abstract void extendGlobalEnv(Context ctxt)
      throws Failure;

    /** Generate assembly code for given set of top-level definitions.
     */
    public static void compile(String name, Defn[] defns) {
        LocEnv   globals = null;
        Assembly a       = Assembly.assembleToFile(name);
        Call funCall; 
        Formal [] p = new Formal[0];  // Empty place holder for the
                                      // initGlobals functions formals
        a.emit();
        a.emit(".data");
   
        for (int i = 0; i < defns.length; i++) {
            globals = defns[i].declareGlobals(a, globals);
        }

        a.emit();
        a.emit(".text");
    
 // Create function in which the global variables are initiated not just set to zero
 // The function is called initGlobals, and it's body is full of the calls to the 
 // compileGlob function.     
        a.emit(".globl", a.name( "initGlobals"));
        a.emitLabel(a.name("initGlobals"));
        a.emitPrologue();
        Frame f = new FunctionFrame(p, globals);
    
         for (int i = 0; i < defns.length; i++) {
            defns[i].compileGlob(a, globals, f);
        }
        //f.dump(a);
        a.emitEpilogue();
        a.emit(); 

        for (int i = 0; i < defns.length; i++) {
            defns[i].compileFunction(a, globals);
        }

        a.close();
    }

    /** Declare storage for global variables.
     */
    abstract LocEnv declareGlobals(Assembly a, LocEnv env);
        
    /** Generate compiled code for a function.
     */
    abstract void compileGlob(Assembly a, LocEnv env, Frame f);

    /** Generate compiled code for a function.
     */
    abstract void compileFunction(Assembly a, LocEnv globals);
}
