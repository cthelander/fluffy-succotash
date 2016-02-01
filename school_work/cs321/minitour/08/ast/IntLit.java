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

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "IntLit(" + num + ")");
    }
}
