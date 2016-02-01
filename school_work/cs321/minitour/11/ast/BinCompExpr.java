package ast;
import compiler.Position;

/** Abstract syntax for binary comparison expressions.
 */
public abstract class BinCompExpr extends BinExpr {

    /** Default constructor.
     */
    public BinCompExpr(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
