package ast;
import compiler.Position;

/** Abstract syntax for binary arithmetic expressions.
 */
public abstract class BinArithExpr extends BinExpr {

    /** Default constructor.
     */
    public BinArithExpr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
