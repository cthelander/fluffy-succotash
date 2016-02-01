package ast;
import compiler.Position;

/** Abstract syntax for binary equality test expressions.
 */
public abstract class BinEqualityExpr extends BinExpr {

    /** Default constructor.
     */
    public BinEqualityExpr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
