// 02 Using exception handling (try, catch, and throw)
import compiler.*;

public class Compiler {
  public static void main(String[] args) {
    Handler handler = new SimpleHandler();
    try {                                                                // <<<
      if (args.length!=1) {
        throw new Failure("This program requires exactly one argument"); // <<<
      }
      System.out.println("Ok, we should look for an input called " + args[0]);
    } catch (Failure f) {                                                // <<<
      handler.report(f);
    } catch (Exception e) {                                              // <<<
      handler.report(new Failure("Exception: " + e));
    }
  }
}
