package ast;
import compiler.Position;

/** Abstract syntax for unary plus expressions.
 */
public class UPlus extends UnArithExpr {

    /** Default constructor.
     */
    public UPlus(Position pos, Expr exp) {
        super(pos, exp);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "UPlus"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { unary(out, "+"); }
}
