package ast;
import compiler.Position;

/** Abstract syntax for bitwise or expressions (|).
 */
public class BOr extends BinBitwiseExpr {

    /** Default constructor.
     */
    public BOr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "BOr"; }
}
