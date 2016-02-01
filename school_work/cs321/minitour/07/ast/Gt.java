package ast;
import compiler.Position;

/** Abstract syntax for greater than expressions.
 */
public class Gt extends BinCompExpr {

    /** Default constructor.
     */
    public Gt(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
