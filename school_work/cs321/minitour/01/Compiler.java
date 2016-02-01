// 01 Using an error handler
import compiler.*;                                                       // <<<

public class Compiler {
  public static void main(String[] args) {
    Handler handler = new SimpleHandler();                               // <<<
    if (args.length!=1) {
      handler.report(new Failure("This program requires exactly one argument"));
    } else {
      System.out.println("Ok, we should look for an input called " + args[0]);
    }
  }
}
