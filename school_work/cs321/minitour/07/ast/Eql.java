package ast;
import compiler.Position;

/** Abstract syntax for equality test expressions (==).
 */
public class Eql extends BinEqualityExpr {

    /** Default constructor.
     */
    public Eql(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
