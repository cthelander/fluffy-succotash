package ast;
import compiler.Position;

/** Abstract syntax for greater than or equal expressions.
 */
public class Gte extends BinCompExpr {

    /** Default constructor.
     */
    public Gte(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Gte"; }
}
