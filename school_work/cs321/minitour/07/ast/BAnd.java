package ast;
import compiler.Position;

/** Abstract syntax for bitwise and expressions (&).
 */
public class BAnd extends BinBitwiseExpr {

    /** Default constructor.
     */
    public BAnd(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
