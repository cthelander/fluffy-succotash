package ast;
import compiler.Position;

/** Abstract syntax for bitwise not expressions (~).
 */
public class BNot extends UnExpr {

    /** Default constructor.
     */
    public BNot(Position pos, Expr exp) {
        super(pos, exp);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "BNot"; }
}
