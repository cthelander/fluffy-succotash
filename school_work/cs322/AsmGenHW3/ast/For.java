package ast;
import compiler.Failure;

/** Abstract syntax for for loops.
 */
public class For extends Stmt {

    /** The initialization expression.
     */
    private StmtExpr init;

    /** The test portion of this loop.
     */
    private Expr test;

    /** The step portion of this for loop.
     */
    private StmtExpr step;

    /** The body of this loop.
     */
    private Stmt body;

    /** Default constructor.
     */
    public For(StmtExpr init, Expr test, StmtExpr step, Stmt body) {
        this.init = init;
        this.test = test;
        this.step = step;
        this.body = body;
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "For");
  
        if (init!=null) {
           init.indent(out, n+1);
        } else {
            out.indent(n+1, "No init");
        }
  
        if (test!=null) {
           test.indent(out, n+1);
        } else {
            out.indent(n+1, "No test");
        }
  
        if (step!=null) {
           step.indent(out, n+1);
        } else {
            out.indent(n+1, "No step");
        }
  
        body.indent(out, n+1);
    }

    /** Type check this statement, using the specified context, with
     *  the given initial typing environment, and returning the typing
     *  environment for a following statement.
     */
    public TypeEnv check(Context ctxt, TypeEnv locals)
      throws Failure {
        if (init!=null) {
            init.check(ctxt, locals);
        }
        if (test!=null) {
            try {
                if (!test.typeOf(ctxt, locals).equals(Type.BOOLEAN)) {
                    ctxt.report(new Failure("WhileBoolean"));
                }
            } catch (Failure f) {
                ctxt.report(f);
            }
        }
        if (step!=null) {
            step.check(ctxt, locals);
        }
        body.check(ctxt, locals); // discard final environment
        return locals;
    }

    /** Generate code for executing this statement.
     *  Returns true if there is a chance that execution may
     *  continue with the next statement.
     */
    public boolean compile(Assembly a, Frame f) {
        String lab1 = a.newLabel();       // Lable for loop
        String lab2 = a.newLabel();       // Lable for jumping to comparison
 
        if(init != null)                  // if the assignment statment
            init.compileExpr(a, f);       // exists compile it 
                                          // (e.g. int i = 0)
        a.emit("jmp", lab2);              // jump to comparison
        a.emitLabel(lab1);                // display loop label
        body.compile(a, f);               // add the 

        if(step != null)                  // If the step exist
            step.compileExpr(a, f);       // compile it
                                          // (e.g. ++i)
        a.emitLabel(lab2);                
        if(test != null)  {               // If the test condition 
                                          // exist compile it
            test.branchTrue(a, f, lab1);  // (e.g. i > 0)
        }
        else {                            // no test condition means
            a.emit("jmp", lab1);          // the loop should cont. forever
        }
        return true;
    }
}
