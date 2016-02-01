// 04 Reading a sequence of characters from a file
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
      FileReader reader = new FileReader(args[0] + ".mini");
      int n = 0;  // Number of characters read
      int c;      // Code for individual characters
      while ((c = reader.read()) != -1) {
        System.out.print("| " + charAsString(c) + "\t");                 // <<<
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

  /** Return a printable string corresponding to a character
   *  with the specified integer code.  A single character
   *  string is returned for the usual Alphabetic, numeric,
   *  and standard symbol characters.  Spaces are represented
   *  by the three character string ' ' to ensure that they
   *  are visible.  Finally, we make a modest attempt to
   *  provide more readable descriptions for the most commonly
   *  used unprintable characters, such as backspaces, tabs,
   *  and newlines, but quickly give
   */
  public static String charAsString(int c) {                             // <<<
    switch (c) {
      case  8 : return "\\b";
      case  9 : return "\\t";
      case 10 : return "\\n";
      case 12 : return "\\f";
      case 13 : return "\\r";
      case 32 : return "' '";
      default : if (c>=32 && c<=127) {
                  return Character.toString((char)c);
                } else {
                  return "?";  // unprintable
                }
    }
  }
}
