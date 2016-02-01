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
}
