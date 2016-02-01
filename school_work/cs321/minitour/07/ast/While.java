package ast;
import compiler.Position;

/** Abstract syntax for while statements.
 */
public class While extends PosStmt {

    /** The test expression.
     */
    private Expr test;

    /** The body of this loop.
     */
    private Stmt body;

    /** Default constructor.
     */
    public While(Position pos, Expr test, Stmt body) {
        super(pos);
        this.test = test;
        this.body = body;
    }
}
