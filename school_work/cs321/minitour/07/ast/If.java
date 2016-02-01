package ast;
import compiler.Position;

/** Abstract syntax for if-then-else statements.
 */
public class If extends PosStmt {

    /** The test expression.
     */
    private Expr test;

    /** The true branch.
     */
    private Stmt ifTrue;

    /** The false branch.
     */
    private Stmt ifFalse;

    /** Default constructor.
     */
    public If(Position pos, Expr test, Stmt ifTrue, Stmt ifFalse) {
        super(pos);
        this.test = test;
        this.ifTrue = ifTrue;
        this.ifFalse = ifFalse;
    }
}
