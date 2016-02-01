// 00 Simple command line program with arguments
public class Compiler {
  public static void main(String[] args) {
    if (args.length!=1) {
      System.out.println("This program requires exactly one argument");
    } else {
      System.out.println("Ok, we should look for an input called " + args[0]);
    }
  }
}
