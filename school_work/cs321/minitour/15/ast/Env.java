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
        for (String name=id.getName(); env!=null; env=env.rest) {
            if (name.equals(env.id.getName())) {
                env.uses = new IdList(id, env.uses);
                return env;
            }
        }
        return null;
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

    /** Holds a list of all the uses of the identifier that is named in
     *  this environment entry.
     */
    IdList uses = null;

    /** Return the list of uses for this environment entry identifier.
     */
    public IdList getUses() {
        return uses;
    }

    /** Return the type for the variable defined in this environment node.
     */
    public Type getType() {
        return type;
    }
}
