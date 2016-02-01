package ast;
import compiler.Position;

/** Abstract syntax for logical or expressions (||).
 */
public class LOr extends BinLogicExpr {

    /** Default constructor.
     */
    public LOr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
