package ast;
import compiler.Position;

/** Represents an environment that stores information about the
 *  type of each variable in a program.
 */
public class Env {

    /** The identifier for this environment entry.
     */
    private Id id;

    /** The type for this environment entry.
     */
    private Type type;

    /** Enclosing items for this environment entry.
     */
    private Env rest;

    /** Default constructor.
     */
    public Env(Id id, Type type, Env rest) {
        this.id = id;
        this.type = type;
        this.rest = rest;
    }

    /** Return the Id for this environment entry.
     */
    public Id getId() {
        return id;
    }

    /** Return a pointer to the (first) entry for an item with the same
     *  name as identifier id in the given environment, or null if there
     *  are no entries for id.
     */
    public static Env lookup(Id id, Env env) {
        String name = id.getName();
        while (env!=null && !name.equals(env.id.getName())) {
            env = env.rest;
        }
        return env;
    }

    /** A counter that is used to assign a distinct numeric code
     *  to every environment node that we construct.
     */
    private static int count = 0;

    /** A numeric code that uniquely identifies this environment node.
     */
    private final int uid = count++;

    /** Generate a dot description for the environment structure of this
     *  program.
     */
    public void dotEnv(DotEnvOutput dot) {
        dot.node(uid, id.getName());
        if (rest!=null) {
            dot.edge(uid, rest.uid);
        }
    }
}
