/** Represents a function environment, mapping identifier
 *  names to associated function definitions.
 */
public class FunctionEnv {
    private String      name;
    private Function    function;
    private FunctionEnv next;

    public FunctionEnv(String name, Function function, FunctionEnv next) {
        this.name     = name;
        this.function = function;
        this.next     = next;
    }

    /** Represents the empty environment that does not bind any
     *  variables.
     */
    public static final FunctionEnv empty = null;

    /** Search an environment for a specified variable name,
     *  returning null if no such entry is found, or else
     *  returning a pointer to the first matching FunctionEnv
     *  object in the list.
     */
    public static FunctionEnv find(String name, FunctionEnv env) {
        while (env!=null && !env.name.equals(name)) {
            env = env.next;
        }
        return env;
    }

    /** Return the value associated with this entry.
     */
    public Function getFunction() {
        return function;
    }
}
