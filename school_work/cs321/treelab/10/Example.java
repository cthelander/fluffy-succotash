abstract class Exp {
  abstract int eval(ImmMap<String,Integer> env);
}

class LetExp extends Exp {
  String x;
  Exp d;
  Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  int eval(ImmMap<String,Integer> env) {
    int v = d.eval(env);
    return e.eval(ImmMap.extend(x,v,env));
  }
}

class VarExp extends Exp {
  String x;
  VarExp(String x) {this.x = x;}
  
  int eval(ImmMap<String,Integer> env) {
    Integer v = env.get(x);
    if (v != null)
      return v;
    else
      return 0;  // default value for undefined variables
  }
}

class NumExp extends Exp {
  int num;
  NumExp(int num) {this.num = num;}

  int eval(ImmMap<String,Integer> env) {
    return num;
  }
}

class AddExp extends Exp {
  Exp left;
  Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval(ImmMap<String,Integer> env) {
    return left.eval(env) + right.eval(env);
  }
}

class SubExp extends Exp {
  Exp left;
  Exp right;
  SubExp (Exp left, Exp right) {this.left = left; this.right = right;}

  int eval(ImmMap<String,Integer> env) {
    return left.eval(env) - right.eval(env);
  }
}

class IfnzExp extends Exp {
  Exp test;
  Exp nz;
  Exp z;
  IfnzExp (Exp test, Exp nz, Exp z) {this.test = test; this.nz = nz; this.z = z;}
  int eval(ImmMap<String,Integer> env) {
    if (test.eval(env) == 0)
      return z.eval(env);
    else
      return nz.eval(env);
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
                                   new LetExp ("y",
                                               new NumExp(21),
                                               new AddExp(new VarExp("y"),
                                                          new VarExp("y")))));
    System.out.println("value = " + e.eval(ImmMap.<String,Integer>empty()));
  }
}



    