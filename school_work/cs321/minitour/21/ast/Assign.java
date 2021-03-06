package ast;
import compiler.Failure;
import compiler.Position;

/** Abstract syntax for assignment statements.
 */
public class Assign extends PosStmt {

    /** The variable where the result will be saved.
     */
    private Id lhs;

    /** The expression whose value will be saved.
     */
    private Expr rhs;

    /** Default constructor.
     */
    public Assign(Position pos, Id lhs, Expr rhs) {
        super(pos);
        this.lhs = lhs;
        this.rhs = rhs;
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "Assign");
        lhs.indent(out, n+1);
        rhs.indent(out, n+1);
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void print(TextOutput out, int n) {
        out.indent(n);
        lhs.print(out);
        out.print(" = ");
        rhs.print(out);
        out.println(";");
    }

    /** Output a description of this node (with id n) in dot format,
     *  adding an extra node for each subtree.
     */
    public int toDot(DotOutput dot, int n) {
        return rhs.toDot(dot, n, "rhs",
               lhs.toDot(dot, n, "lhs",
               node(dot, "Assign", n)));
    }

    /** Run scope analysis on this statement.  The scoping parameter
     *  provides access to the scope analysis phase (in particular,
     *  to the associated error handler), and the env parameter
     *  reflects the environment at the start of the statement.  The
     *  return result is the environment at the end of the statement.
     */
    public Env analyze(ScopeAnalysis scoping, Env env) {
        lhs.analyze(scoping, env);
        rhs.analyze(scoping, env);
        return env;
    }

    /** Generate a dot description for the environment structure of this
     *  program.
     */
    public void dotEnv(DotEnvOutput dot) {
        /* nothing to do here */
    }

    /** Run type checker on this statement.  The typing parameter
     *  provides access to the scope analysis phase (specifically,
     *  to the associated error handler).
     */
    public void analyze(TypeAnalysis typing) {
        Type lt = lhs.analyze(typing);
        Type rt = rhs.analyze(typing);
        if (lt!=rt) {
          typing.report(new Failure(pos, "Attempt to assign " + rt +
                                         " value to variable of type " + lt));
        }
    }

    /** Run initialization analysis on this statement.  The init
     *  parameter provides access to an initialization analysis phase
     *  object (specifically, to an associated error handler).  The
     *  initialized parameter is the set of variables (each represented
     *  by pointers to environment entries) that have definitely been
     *  initialized before this statement is executed.
     */
    public VarSet analyze(InitAnalysis init, VarSet initialized) {
        return lhs.addTo(rhs.analyze(init, initialized));
    }

    /** Attempt to simplify all of the expressions in this statement.
     */
    public void simplify() {
        rhs = rhs.simplify();
    }

    /** Execute this program.
     */
    public void exec()
      throws Failure {
        lhs.store(rhs.eval());
    }

    /** Generate code for executing this statement.
     */
    public void compile(IA32 a, int pushed) {
        rhs.compileExpr(a, pushed, 0);
        a.emit("movl", a.reg(0), lhs.fromStackFrame(a, pushed));
    }
}
