package ast;
import compiler.Position;
import compiler.Failure;

/** Abstract syntax for identifiers/variables.
 */
public class Id extends Expr {

    /** The identifier name.
     */
    String name;

    /** Default constructor.
     */
    public Id(Position pos, String name) {
        super(pos);
        this.name = name;
    }

    /** Return a printable description of this expression.
     */
    public String toString() {
        return name;
    }

    /** Print an indented description of this abstract syntax node,
     *  including a name for the node itself at the specified level
     *  of indentation, plus more deeply indented descriptions of
     *  any child nodes.
     */
    public void indent(IndentOutput out, int n) {
        out.indent(n, "Id(\"" + name + "\")");
    }

    /** Print out this expression.
     */
    public void print(TextOutput out) { out.print(name); }

    /** Output a description of this node (with id n) in dot format,
     *  adding an extra node for each subtree.
     */
    public int toDot(DotOutput dot, int n) {
        return node(dot, "Id(\\\"" + name + "\\\")", n);
    }

    /** Holds a pointer to the environment entry for this identifier.
     *  This field will be initialized to a non-null value during the
     *  scope analysis phase.
     */
    private Env v = null;

    /** Extend the given environment with an entry for this variable,
     *  adding a link from this identifier to the new environment slot.
     */
    public Env extend(Type type, Env env) {
        return v = new Env(this, type, env);
    }

    /** Return the name associated with this identifier.
     */
    public String getName() {
        return name;
    }

    /** Run scope analysis on this expression.  The scoping parameter
     *  provides access to the scope analysis phase (in particular,
     *  to the associated error handler), and the env parameter
     *  reflects the environment in which the expression is evaluated.
     *  Unlike scope analysis for statements, there is no return
     *  result here: an expression cannot introduce new variables in
     *  to a program, so the final environment will always be the same
     *  as the initial environment.
     */
    public void analyze(ScopeAnalysis scoping, Env env) {
        v = Env.lookup(this, env);
        if (v==null) {
          scoping.report(new Failure(pos, "Identifier \"" + name
                                           + "\" has not been declared"));
        }
    }
}
