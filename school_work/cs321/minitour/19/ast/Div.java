package ast;
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
}
