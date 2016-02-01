package ast;
import compiler.Position;

/** Abstract syntax for binary bitwise operations.
 */
public abstract class BinBitwiseExpr extends BinExpr {

    /** Default constructor.
     */
    public BinBitwiseExpr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
