package ast;
import compiler.Failure;
import compiler.Position;

/** Abstract syntax for divide expressions.
 */
public class Div extends BinArithExpr {

    /** Default constructor.
     */
    public Div(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Div"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { binary(out, "/"); }

    /** Constant folding for binary operators with two known integer
     *  arguments.
     */
    Expr fold(int n, int m) { return (m==0) ? this : new IntLit(pos, n/m); }

    /** Evaluate this expression.
     */
    public int eval()
      throws Failure {
        int n = left.eval();
        int d = right.eval();
        if (d==0) {
            throw new Failure(pos, "Divide by zero");
        }
        return n / d;
    }

    /** Generate assembly language code for this expression that will
     *  evaluate the expression when it is executed and leave the result
     *  in the specified free register, preserving any lower numbered
     *  registers in the process.
     */
    public void compileExpr(IA32 a, int pushed, int free) {
        a.emit("Div is not yet implemented");
    }
}
