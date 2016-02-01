// 06 Reading a sequence of tokens from a lexer
import compiler.*;
import lexer.*;
import java.io.FileReader;

public class Compiler {
  public static void main(String[] args) {
    Handler handler = new SimpleHandler();
    try {
      if (args.length!=1) {
        throw new Failure("This program requires exactly one argument");
      }

      // Read program:
      String     input  = args[0] + ".mini";
      FileReader reader = new FileReader(input);
      Source     source = new JavaSource(handler, input, reader);
      MiniLexer  lexer  = new MiniLexer(handler, source);                // <<<
      while ((lexer.nextToken())!=MiniTokens.ENDINPUT) {
        Position pos = lexer.getPos();
        System.out.println(pos.coordString()
                            + "\t  " + lexer.getToken()
                            + "\t"   + lexer.tokenName());
      }
      System.out.println("ENDINPUT");
        
    } catch (Failure f) {
      handler.report(f);
    } catch (Exception e) { 
      handler.report(new Failure("Exception: " + e));
    }     
  }     
}
