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

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "Print");
        exp.indent(out, n+1);
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void print(TextOutput out, int n) {
        out.indent(n);
        out.print("print ");
        exp.print(out);
        out.println(";");
    }

    /** Output a description of this node (with id n) in dot format,
     *  adding an extra node for each subtree.
     */
    public int toDot(DotOutput dot, int n) {
        return exp.toDot(dot, n, "exp",
               node(dot, "Print", n));
    }
}