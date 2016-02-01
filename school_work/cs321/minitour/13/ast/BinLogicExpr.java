package ast;
import compiler.Position;

/** Abstract syntax for binary logical expressions.
 */
public abstract class BinLogicExpr extends BinExpr {

    /** Default constructor.
     */
    public BinLogicExpr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
