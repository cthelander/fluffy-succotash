package ast;
import compiler.Position;

/** Abstract syntax for unary expressions that operate on
 *  numeric arguments.
 */
public abstract class UnArithExpr extends UnExpr {

    /** Default constructor.
     */
    public UnArithExpr(Position pos, Expr exp) {
        super(pos, exp);
    }
}
