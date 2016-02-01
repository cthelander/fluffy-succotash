package ast;
import compiler.Position;

/** Abstract syntax for unary expressions.
 */
public abstract class UnExpr extends Expr {

    /** The operand of a unary operator expression.
     */
    protected Expr exp;

    /** Default constructor.
     */
    public UnExpr(Position pos, Expr exp) {
        super(pos);
        this.exp = exp;
    }
}
