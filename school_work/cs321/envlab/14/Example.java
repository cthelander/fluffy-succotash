class RuntimeError extends Exception {
  RuntimeError(String message) {
    super(message);
  }
} 

class StaticError extends Exception {
  StaticError(String message) {
    super(message);
  }
}

abstract class Type {
  abstract boolean equals(Type t0);
  abstract public String toString();
  static Type INT = new IntType();
  static Type BOOL = new BoolType();
}

class IntType extends Type {
  boolean equals(Type t) {
    return (t instanceof IntType);
  }
  public String toString() {
    return "INT";
  }
}

class BoolType extends Type {
  boolean equals(Type t) {
    return (t instanceof BoolType);
  }
  public String toString() {
    return "BOOL";
  }
}

abstract class Exp {
  abstract Object eval(ValueEnv env) throws RuntimeError;
  abstract Type check(TypeEnv env) throws StaticError;
}

class LetExp extends Exp {
  String x;
  Exp d;
  Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  Object eval(ValueEnv env) throws RuntimeError {
    Object v = d.eval(env);
    return e.eval(new ValueEnv(x,v,env));
  }

  Type check(TypeEnv env) throws StaticError {
    Type t = d.check(env);
    return e.check(new TypeEnv(x,t,env));
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

  Type check(TypeEnv env) throws StaticError {
    TypeEnv te = TypeEnv.find(x, env);
    if (te != null)
      return te.getType();
    else
      throw new StaticError("undefined variable '"+ x + "'");
  }
}

class NumExp extends Exp {
  int num;
  NumExp(int num) {this.num = num;}

  Object eval(ValueEnv env) {
    return num;
  }

  Type check(TypeEnv env) {
    return Type.INT;
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

  Type check(TypeEnv env) throws StaticError {
    if (left.check(env).equals(Type.INT) && right.check(env).equals(Type.INT))
      return Type.INT;
    else
      throw new StaticError("Add requires INT operands");
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

  Type check(TypeEnv env) throws StaticError {
    if (left.check(env).equals(Type.INT) && right.check(env).equals(Type.INT))
      return Type.INT;
    else
      throw new StaticError("Sub requires INT operands");
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

  Type check(TypeEnv env) throws StaticError {
    if (left.check(env).equals(Type.BOOL) && right.check(env).equals(Type.BOOL))
      return Type.BOOL;
    else
      throw new StaticError("And requires BOOL operands");
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

  Type check(TypeEnv env) throws StaticError {
    if (e.check(env).equals(Type.BOOL))
      return Type.BOOL;
    else
      throw new StaticError("Not requires BOOL operand");
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

  Type check(TypeEnv env) throws StaticError {
    if (test.check(env).equals(Type.BOOL)) {
      Type tt = t.check(env);
      Type ft = f.check(env);
      if (tt.equals(ft))
        return tt;
      else
        throw new StaticError("If requires equal types for second and third operands");
    }
    throw new StaticError("If requires BOOL first operand");
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
                                 new NumExp(10)));
    TypeEnv tenv = 
      new TypeEnv("true",Type.BOOL,
       new TypeEnv("false",Type.BOOL,
        TypeEnv.empty));
    
    ValueEnv venv = 
      new ValueEnv("true",true,
       new ValueEnv("false",false,
        ValueEnv.empty));

    try {
      System.out.println("type  = " + e.check(tenv));
      System.out.println("value = " + e.eval(venv));
    } catch (StaticError exn) {
      System.err.println(exn.toString());
    } catch (RuntimeError exn) {
      System.err.println(exn.toString());
    }
  }
}



    
