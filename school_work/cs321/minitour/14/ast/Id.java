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
    public void print(TextOutput out) { out.printUse(this); }

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

    /** Generate a dot description for the environment structure of this
     *  program.
     */
    public void dotEnv(DotEnvOutput dot) {
        v.dotEnv(dot);
    }

    /** Print out a description of this identifier as plain text.
     */
    void printText(TextOutput out) { out.print(name); }

    /** Print out an HTML description corresponding to the definition of
     *  this identifier.  This amounts to wrapping the name in an HTML
     *  span so that it can be referenced by JavaScript code at each
     *  point of use.
     */
    void printDefHTML(HTMLOutput html) {
        String       me    = pos.coordString();
        StringBuffer mover = new StringBuffer("defId"+me);
        StringBuffer mout  = new StringBuffer("normalId"+me);
        for (IdList uses = (v!=null) ? v.getUses() : null; uses!=null; uses=uses.rest) {
            String ps = uses.head.pos.coordString();
            mover.append(";highlightId");
            mover.append(ps);
            mout.append(";normalId");
            mout.append(ps);
        }
        printHTML(html, me, mover.toString(), mout.toString());
    }

    /** Print out an HTML description corresponding to a use of
     *  this identifier.  This amounts to wrapping the name in an HTML
     *  span with associated JavaScript code for mouse over and mouse
     *  out events that change the highlighting of the current node
     *  as well as the defining occurrence.
     */
    void printUseHTML(HTMLOutput html) {
        String me = pos.coordString();
        if (v==null) {
            printHTML(html, me, "useId"+me, "normalId"+me);
        } else {
            String mydef = v.getId().pos.coordString();
            printHTML(html, me, "useId"+me+";highlightId"+mydef,
                                "normalId"+me+";normalId"+mydef);
        }
    }

    /** Print a string that is wrapped in a span with the HTML identifier me,
     *  and mouse over and mouseout actions as specified by the given strings.
     */
    void printHTML(HTMLOutput html, String me, String mouseover, String mouseout) {
        html.print("<span class=\"normal\" id=\"");
        html.print(me);
        html.print("\" title=\"");
        html.print(me);
        html.print("\" onmouseover=\"");
        html.print(mouseover);
        html.print("\" onmouseout=\"");
        html.print(mouseout);
        html.print("\">");
        html.print(name);
        html.print("</span>");
    }
}
