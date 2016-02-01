package ast;
import compiler.Position;

/** Abstract syntax for Boolean literals.
 */
public class BoolLit extends Expr {

    /** The value of this Boolean literal.
     */
    private boolean value;

    /** Default constructor.
     */
    public BoolLit(Position pos, boolean value) {
        super(pos);
        this.value = value;
    }
}
