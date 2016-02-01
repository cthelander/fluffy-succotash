class RuntimeError extends Exception {
  RuntimeError(String message) {
    super(message);
  }
}

abstract class Exp {
  abstract Object eval(ValueEnv env) throws RuntimeError;
}

class LetExp extends Exp {
  String x;
  Exp d;
  Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  Object eval(ValueEnv env) throws RuntimeError {
    Object v = d.eval(env);
    return e.eval(new ValueEnv(x, v, env));
  }
}

class VarExp extends Exp {
  String x;
  VarExp(String x) {this.x = x;}
  
  Object eval(ValueEnv env) throws RuntimeError {
    ValueEnv ve = ValueEnv.find(x, env);
    if (ve != null)
      return ve.getValue();
    else
      throw new RuntimeError("undefined variable '" + x + "'"); 
  }
}

class NumExp extends Exp {
  int num;
  NumExp(int num) {this.num = num;}

  Object eval(ValueEnv env) {
    return num;
  }
}

class AddExp extends Exp {
  Exp left;
  Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(ValueEnv env) throws RuntimeError {
    try {
      return (Integer) left.eval(env) + (Integer) right.eval(env);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Add requires INT operands");
    }
  }
}

class SubExp extends Exp {
  Exp left;
  Exp right;
  SubExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(ValueEnv env) throws RuntimeError {
    try {
      return (Integer) left.eval(env) - (Integer) right.eval(env);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Sub requires INT operands");
    }
  }
}

class AndExp extends Exp {
  Exp left;
  Exp right;
  AndExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(ValueEnv env) throws RuntimeError {
    try {
      return (Boolean) left.eval(env) && (Boolean) right.eval(env);
    } catch (ClassCastException exn) {
      throw new RuntimeError("And requires BOOL operands");
    }
  }
}

class NotExp extends Exp {
  Exp e;
  NotExp (Exp e) {this.e = e;}

  Object eval(ValueEnv env) throws RuntimeError {
    try {
      return ! (Boolean) e.eval(env);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Not requires BOOL operand");
    }
  }
}

class IfExp extends Exp {
  Exp test;
  Exp t;
  Exp f;
  IfExp (Exp test, Exp t, Exp f) {this.test = test; this.t = t; this.f = f;}
  Object eval(ValueEnv env) throws RuntimeError {
    boolean b;
    try {
      b = (Boolean) test.eval(env);
    } catch (ClassCastException exn) {
      throw new RuntimeError("If requires BOOL first operand");
    }
    if (b)
      return t.eval(env);
    else
      return f.eval(env);
  }
}

class Example {
  public static void main(String argv[]) {
    Exp e = new LetExp("y",
                       new NotExp(new AndExp (new VarExp("true"),
                                              new VarExp("false"))),
                       new IfExp(new VarExp("y"),
                                 new LetExp ("y",
                                             new NumExp(21),
                                             new AddExp(new VarExp("y"),
                                                        new VarExp("y"))),
                                 new VarExp("y")));
    ValueEnv venv = 
      new ValueEnv("true",true,
       new ValueEnv("false",false,
        ValueEnv.empty));
    try {
      System.out.println("value = " + e.eval(venv));
    } catch (RuntimeError exn) {
      System.err.println(exn.toString());
    }
  }
}



    
