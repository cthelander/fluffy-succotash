package ast;
import compiler.Position;

/** Abstract syntax for equality test expressions (==).
 */
public class Eql extends BinEqualityExpr {

    /** Default constructor.
     */
    public Eql(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Eql"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { binary(out, "=="); }

    /** Constant folding for binary operators with two known integer
     *  arguments.
     */
    Expr fold(int n, int m) { return new BoolLit(pos, n==m); }
}
