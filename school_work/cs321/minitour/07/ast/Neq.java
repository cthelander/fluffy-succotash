package ast;
import compiler.Position;

/** Abstract syntax for inequality test expressions (==).
 */
public class Neq extends BinEqualityExpr {

    /** Default constructor.
     */
    public Neq(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
