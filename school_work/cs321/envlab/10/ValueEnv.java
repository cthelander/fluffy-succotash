/** Represents a value environment, mapping identifier
 *  names to associated values.
 */
public class ValueEnv {
    private String   name;
    private int      value;
    private ValueEnv next;

    public ValueEnv(String name, int value, ValueEnv next) {
        this.name   = name;
        this.value  = value;
        this.next   = next;
    }

    /** Represents the empty environment that does not bind any
     *  variables.
     */
    public static final ValueEnv empty = null;

    /** Search an environment for a specified variable name,
     *  returning null if no such entry is found, or else
     *  returning a pointer to the first matching ValueEnv
     *  object in the list.
     */
    public static ValueEnv find(String name, ValueEnv env) {
        while (env!=null && !env.name.equals(name)) {
            env = env.next;
        }
        return env;
    }

    /** Return the value associated with this entry.
     */
    public int getValue() {
        return value;
    }
}
