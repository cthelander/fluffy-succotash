package ast;
import compiler.Position;

/** Abstract syntax for binary expressions.
 */
public abstract class BinExpr extends Expr {

    /** The left subexpression.
     */
    protected Expr left;

    /** The right subexpression.
     */
    protected Expr right;

    /** Default constructor.
     */
    public BinExpr(Position pos, Expr left, Expr right) {
        super(pos);
        this.left = left;
        this.right = right;
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    abstract String label();

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, label());
        left.indent(out, n+1);
        right.indent(out, n+1);
    }

    /** Print out this binary expression.
     */
    protected void binary(TextOutput out, String op) {
        left.parenPrint(out);
        out.print(op);
        right.parenPrint(out);
    }

    /** Print out this expression, wrapping it in parentheses if the
     *  expression includes a binary or unary operand.
     */
    public void parenPrint(TextOutput out) {
        out.print("(");
        this.print(out);
        out.print(")");
    }
}
