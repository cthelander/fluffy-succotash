package ast;
import compiler.Failure;
import compiler.Position;

/** Abstract syntax for logical not expressions (!).
 */
public class LNot extends UnExpr {

    /** Default constructor.
     */
    public LNot(Position pos, Expr exp) {
        super(pos, exp);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "LNot"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { unary(out, "!"); }

    /** Run type checking analysis on this expression.  The typing parameter
     *  provides access to the scope analysis phase (in particular,
     *  to the associated error handler), and the env parameter
     *  reflects the environment in which the expression is evaluated.
     *  Unlike scope analysis for statements, there is no return
     *  result here: an expression cannot introduce new variables in
     *  to a program, so the final environment will always be the same
     *  as the initial environment.
     */
    public Type analyze(TypeAnalysis typing) {
        return type = exp.require(typing, Type.BOOLEAN);
    }

    /** Evaluate this expression.
     */
    public int eval()
      throws Failure { return exp.eval() ^ 1; }

    /** Generate assembly language code for this expression that will
     *  evaluate the expression when it is executed and leave the result
     *  in the specified free register, preserving any lower numbered
     *  registers in the process.
     */
    public void compileExpr(IA32 a, int pushed, int free) {
        exp.compileExpr(a, pushed, free);
        a.emit("xorl", a.immed(1), a.reg(free));
    }
}
