package ast;
import compiler.Position;

/** Abstract syntax for empty statements.
 */
public class Empty extends PosStmt {

    /** Default constructor.
     */
    public Empty(Position pos) {
        super(pos);
    }
}
