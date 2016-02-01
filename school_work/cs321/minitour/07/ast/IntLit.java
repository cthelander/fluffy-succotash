package ast;
import compiler.Position;

/** Abstract syntax for integer literals.
 */
public class IntLit extends Expr {

    /** The value of this integer literal.
     */
    private int num;

    /** Default constructor.
     */
    public IntLit(Position pos, int num) {
        super(pos);
        this.num = num;
    }

    /** Return a printable description of this expression.
     */
    public String toString() {
        return "" + num;
    }
}
