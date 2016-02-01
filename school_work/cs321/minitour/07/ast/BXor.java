package ast;
import compiler.Position;

/** Abstract syntax for bitwise exclusive or expressions (^).
 */
public class BXor extends BinBitwiseExpr {

    /** Default constructor.
     */
    public BXor(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }
}
