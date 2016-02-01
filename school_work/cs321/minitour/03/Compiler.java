// 03 Reading a sequence of integer codes from a file
import compiler.*;
import java.io.FileReader;

public class Compiler {
  public static void main(String[] args) {
    Handler handler = new SimpleHandler();
    try {
      if (args.length!=1) {
        throw new Failure("This program requires exactly one argument");
      }

      // Read program:
      FileReader reader = new FileReader(args[0] + ".mini");             // <<<
      int n = 0;  // Number of characters read
      int c;      // Code for individual characters
      while ((c = reader.read()) != -1) {                                // <<<
        System.out.print("| " + c + "\t");
        if ((++n % 8)==0) {
          System.out.println("|");
        }
      }
      System.out.println("|");
        
    } catch (Failure f) {
      handler.report(f);
    } catch (Exception e) { 
      handler.report(new Failure("Exception: " + e));
    }     
  }     
}
