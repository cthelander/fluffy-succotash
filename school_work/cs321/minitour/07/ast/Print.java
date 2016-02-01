package ast;
import compiler.Position;

/** Abstract syntax for print statements.
 */
public class Print extends PosStmt {

    /** The value that should be printed out.
     */
    private Expr exp;

    /** Default constructor.
     */
    public Print(Position pos, Expr exp) {
        super(pos);
        this.exp = exp;
    }
}
