package ast;
import compiler.Position;

/** Abstract syntax for unary expressions.
 */
public abstract class UnExpr extends Expr {

    /** The operand of a unary operator expression.
     */
    protected Expr exp;

    /** Default constructor.
     */
    public UnExpr(Position pos, Expr exp) {
        super(pos);
        this.exp = exp;
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
        exp.indent(out, n+1);
    }

    /** Print out this unary expression.
     */
    protected void unary(TextOutput out, String op) {
        out.print(op);
        exp.parenPrint(out);
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
