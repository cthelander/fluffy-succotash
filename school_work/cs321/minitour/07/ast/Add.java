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
}
