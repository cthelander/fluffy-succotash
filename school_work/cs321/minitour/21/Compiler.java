// 21 Compilation
import compiler.*;
import lexer.*;
import parser.*;
import ast.*;
import java.io.FileReader;

public class Compiler {
  public static void main(String[] args) {
    Handler handler = new SimpleHandler();
    try {
      if (args.length!=1) {
        throw new Failure("This program requires exactly one argument");
      }

      // Read program:
      //Position pos = null;    // a dummy position
      //
      //Id i         = new Id(pos,"i");    // Some identifiers
      //Id n         = new Id(pos,"n");
      //Id sum       = new Id(pos,"sum");
      //
      //IntLit i0    = new IntLit(pos,0);  // Some integer literals
      //IntLit i1    = new IntLit(pos,1);
      //IntLit i100  = new IntLit(pos,100);
      //
      //Stmt   s1    = new VarDecl(pos, Type.INT, new Id[]{sum,n,i});
      //Stmt   s2    = new Assign(pos, sum, i0);
      //Stmt   s3    = new Assign(pos, n, i100);
      //Stmt   s4    = new Assign(pos, i, i0);
      //Stmt   body1 = new Assign(pos, sum, new Add(pos, sum, i));
      //Stmt   body2 = new Assign(pos, i,   new Add(pos, i,   i1));
      //Stmt   body  = new Block(new Stmt[] {body1, body2});
      //Stmt   s5    = new While(pos, new Lt(null, i, n), body);
      //Stmt   s6    = new Print(pos, sum);
      //Stmt   prog  = new Block(new Stmt[]{s1, s2, s3, s4, s5, s6});

//      Position pos = null;    // a dummy position
      
//      Id i         = new Id(pos,"i");    // Some identifiers
//      Id n         = new Id(pos,"n");
//      Id sum       = new Id(pos,"sum");
//      
//      IntLit i0    = new IntLit(pos,0);  // Some integer literals
//      IntLit i1    = new IntLit(pos,1);
//      IntLit i3    = new IntLit(pos,3);
//      IntLit i5    = new IntLit(pos,5);
//      IntLit i15   = new IntLit(pos,15);
//      IntLit i100  = new IntLit(pos,100);
//      
//
//   Expr exp3  = new Mul(null, new Div(null, i, i3), i3);
//   Expr exp5  = new Mul(null, new Div(null, i, i5), i5);
//   Expr exp15 = new Mul(null, new Div(null, i, i15), i15);
//
//   Stmt prog = new Block(new Stmt[]{
//     new VarDecl(null, Type.INT, new Id[]{n,i}),
//     new Assign(null, n, i100),
//     new Assign(null, i, i1),
//     new While(null, new Lt(null, i, n),
//       new Block(new Stmt[]{
//         new If(null, new Eql(null, exp15, i),
//           new Print(null, i15),
//           new If(null, new Eql(null, exp5, i),
//             new Print(null, i5),
//             new If(null, new Eql(null, exp3, i),
//               new Print(null, i3),
//               new Assign(null, i, i)
//             )
//           )
//         ),
//         new Assign(null, i, new Add(null, i, i1))
//       })
//     )
//   });


//int i, n;
//i = 1; 
//n = 100;
//
//while ( i < n)
//{
//    if(15 == (15*(i/15)))
//    {
//        print 15;
//    }
//    else if(5 == (5*(i/5)))
//    {
//        print 5;
//    }
//    else if(3 == (3*(i/3)))
//    {
//        print 3;
//    }
//    else
//    {
//        i = i;
//    }
//    i = i + 1;
//}
//



   Position pos = null;    // a dummy position

   Id i         = new Id(pos,"i");    // Some identifiers
   Id n         = new Id(pos,"n");
   Id fact      = new Id(pos,"fact");

   IntLit i1    = new IntLit(pos,1);  // Some integer literals
   IntLit i10   = new IntLit(pos,15);

   Stmt   s1    = new VarDecl(pos, Type.INT, new Id[]{fact,n,i});
   Stmt   s2    = new Assign(pos, i, i1);
   Stmt   s3    = new Assign(pos, n, i10);
   Stmt   s4    = new Assign(pos, fact, i1);
   Stmt   body1 = new Assign(pos, fact, new Mul(pos, fact, new Add(pos, i, i1)));
   Stmt   body2 = new Assign(pos, i, new Add(pos, i, i1));
   Stmt   body  = new Block(new Stmt[] {body1, body2});
   Stmt   s5    = new While(pos, new Lt(null, i, n), body);
   Stmt   s6    = new Print(pos, fact);
   Stmt   prog  = new Block(new Stmt[]{s1, s2, s3, s4, s5, s6});




      if (handler.hasFailures()) {
        throw new Failure("Aborting: errors detected during syntax analysis");
      }

      // Analyze program:
      new ScopeAnalysis(handler).analyze(prog);
      new TypeAnalysis(handler).analyze(prog);
      new InitAnalysis(handler).analyze(prog);

      // Optimization:
      prog.simplify();

      // Output compiled program:
      String output = args[0] + ".s";
      new IA32(output).generateAssembly(output, prog);                   // <<<
      System.out.println("Assembly code output: " + output);

      // Invoke assembler to produce executable:
      Runtime.getRuntime()                                               // <<<
             .exec("gcc -m32 -o " + args[0] + " " +                      // <<<
                     args[0] + ".s runtime.c")                           // <<<
             .waitFor();                                                 // <<<
      System.out.println("Executable program: " + args[0]);

    } catch (Failure f) {
      handler.report(f);
    } catch (Exception e) { 
      handler.report(new Failure("Exception: " + e));
    }     
  }     
}
