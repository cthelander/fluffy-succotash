package ast;
import compiler.Position;

/** Represents an output phase for producing descriptions of
 *  environments in dot format, suitable for the AT&T
 *  Graphviz tools.
 */
public class DotEnvOutput {

    protected java.io.PrintStream out;

    public DotEnvOutput(java.io.PrintStream out) {
        this.out = out;
    }

    public DotEnvOutput(String filename)
      throws Exception {
        this(new java.io.PrintStream(filename));
    }

    /** Create a dot graph on the specified output stream to
     *  describe the environment for the given statement.
     */
    public void dotEnv(Stmt stmt) {
        out.println("digraph AST {");
        out.println("node [style=filled fontname=Courier fontsize=16];");
        out.println("edge [dir=back];");
        stmt.dotEnv(this);
        out.println("}");
        out.close();
    }

    /** Output a description of a particular node in the
     *  dot description of an Env.
     */
    public void node(int uid, String label) {
        out.print(uid + "[label=\"" + label + "\"];");
    }

    /** Output an edge between the specified pair of Env nodes.
     */
    public void edge(int from, int to) {
        out.println(to + " -> " + from + ";");
    }
}
