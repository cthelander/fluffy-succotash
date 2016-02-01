package ast;
import compiler.Failure;
import compiler.Position;

/** Abstract syntax for greater than or equal expressions.
 */
public class Gte extends BinCompExpr {

    /** Default constructor.
     */
    public Gte(Position pos, Expr left, Expr right) {
        super(pos, left, right);
    }

    /** Return a string that provides a simple description of this
     *  particular type of operator node.
     */
    String label() { return "Gte"; }

    /** Print out this expression.
     */
    public void print(TextOutput out) { binary(out, ">="); }

    /** Constant folding for binary operators with two known integer
     *  arguments.
     */
    Expr fold(int n, int m) { return new BoolLit(pos, n>=m); }

    /** Evaluate this expression.
     */
    public int eval()
      throws Failure { return fromBool(left.eval() >= right.eval()); }

    /** Generate assembly language code for this expression that will
     *  evaluate the expression when it is executed and leave the result
     *  in the specified free register, preserving any lower numbered
     *  registers in the process.
     */
    public void compileExpr(IA32 a, int pushed, int free) {
        compileCondValue(a, "jge", pushed, free);
    }

    /** Generate code that will evaluate this (boolean-valued) expression
     *  and jump to the specified label if the result is true.
     */
    void branchTrue(IA32 a, int pushed, int free, String lab) {
        compileCond(a, pushed, free);
        a.emit("jge", lab);
    }

    /** Generate code that will evaluate this (boolean-valued) expression
     *  and jump to the specified label if the result is false.
     */
    void branchFalse(IA32 a, int pushed, int free, String lab) {
        compileCond(a, pushed, free);
        a.emit("jl", lab);
    }
}
