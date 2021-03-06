package ast;
import compiler.Position;

/** Abstract syntax for subtract expressions.
 */
public class Sub extends BinArithExpr {

    /** Default constructor.
     */
    public Sub(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Sub"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { binary(out, "-"); }
}
