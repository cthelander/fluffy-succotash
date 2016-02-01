package ast;
import compiler.Position;

/** Abstract syntax for add expressions.
 */
public class Add extends BinArithExpr {

    /** Default constructor.
     */
    public Add(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Add"; }
}
