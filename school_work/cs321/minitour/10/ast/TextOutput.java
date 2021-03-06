package ast;
import compiler.Position;

/** Represents an output phase for producing "pretty-printed" textual
 *  output of abstract syntax trees using indentation.  Whether or not
 *  the output actually matches anyone's notion of "pretty" is another
 *  matter of course!  (It might help if the output also included
 *  comments, but this phase operates on the output of the parser,
 *  by which point the comments have already been discarded during
 *  lexical analysis.
 */
public class TextOutput {

    protected java.io.PrintStream out;

    /** Default constructor.
     */
    public TextOutput(java.io.PrintStream out) {
        this.out = out;
    }

    /** Construct a version of this Text output that will leave its output
     *  in the named file.
     */
    public TextOutput(String filename)
      throws Exception {
        this(new java.io.PrintStream(filename));
    }

    /** Create an Text pretty printed output of the given program
     *  on the specified output file.
     */
    public void toText(Stmt stmt) {
        stmt.printProgram(this);
    }

    /** Indent the output stream according to the specified nesting level n.
     */
    public void indent(int n) {
        for (int i=0; i<n; i++) {
            out.print("    ");
        }
    }

    /** Indent to the specified level and then print a string.
     */
    public void indent(int n, String s) { indent(n); print(s); }

    /** Print a string on the output stream.
     */
    public void print(String s) { out.print(s); }

    /** Print a string followed by a newline on the output stream.
     */
    public void println(String s) { out.println(s); }

    /** Print a newline on the output stream.
     */
    public void println() { out.println(); }
}
