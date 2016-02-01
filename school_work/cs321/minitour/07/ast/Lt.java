package ast;
import compiler.Position;

/** Abstract syntax for less than expressions.
 */
public class Lt extends BinCompExpr {

    /** Default constructor.
     */
    public Lt(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
