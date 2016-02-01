import java.util.*;

// A mutable environment datatype that supports retraction of bindings.
// (For simplicity, this implementation is specialized to String keys
//  and Integer values.)
class Env {
  private Map<String,Stack<Integer>> m;
  
  // Empty Environment
  Env() {
    m = new HashMap<String,Stack<Integer>>();
  }

  // Extend
  void extend(String k, int v) {
    Stack<Integer> s = m.get(k);
    if (s == null) {
      s = new Stack<Integer>();
      m.put(k,s);
    }
    s.push(v);
  }
    
  // Retract
  void retract(String k) {
    Stack<Integer> s = m.get(k);  // should never be null
    s.pop();
    if (s.empty()) 
      m.remove(k);
  }
      
  // Lookup 
  Integer lookup(String k) {
    Stack<Integer> s = m.get(k);
    if (s == null)
      return null;
    return s.peek();
  }
}

abstract class Exp {
  static Env env = new Env();
  abstract int eval();
}

class LetExp extends Exp {
  private String x;
  private Exp d;
  private Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  int eval() {
    int v = d.eval();
    env.extend(x,v);
    v = e.eval();
    env.retract(x);
    return v;
  }
}

class VarExp extends Exp {
  private String x;
  VarExp(String x) {this.x = x;}
  
  int eval() {
    Integer v = env.lookup(x);
    if (v != null)
      return v;
    else
      return 0;  // default value for undefined variables
  }
}

class NumExp extends Exp {
  private int num;
  NumExp(int num) {this.num = num;}

  int eval() {
    return num;
  }
}

class AddExp extends Exp {
  private Exp left;
  private Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() + right.eval();
  }
}

class SubExp extends Exp {
  private Exp left;
  private Exp right;
  SubExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval() {
    return left.eval() - right.eval();
  }
}

class IfnzExp extends Exp {
  Exp test;
  Exp nz;
  Exp z;
  IfnzExp (Exp test, Exp nz, Exp z) {this.test = test; this.nz = nz; this.z = z;}
  int eval() {
    if (test.eval() == 0)
      return z.eval();
    else
      return nz.eval();
  }
}

class Example {
  public static void main(String argv[]) {
    Exp e = new LetExp("y",
                       new SubExp(new NumExp(5),
                                  new AddExp(new NumExp(2),
                                             new NumExp(3))),
                       new IfnzExp(new VarExp("y"),
                                   new NumExp(10),
                                   new AddExp (new LetExp ("y",
                                                           new NumExp(21),
                                                           new AddExp(new VarExp("y"),
                                                                      new VarExp("y"))),
                                               new VarExp ("y"))));

    System.out.println("value = " + e.eval());
  }
}



    
