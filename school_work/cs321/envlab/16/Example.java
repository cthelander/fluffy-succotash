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

class PairType extends Type {
  Type left;
  Type right;
  PairType(Type left, Type right) {
    this.left = left; this.right = right;
  }
  boolean equals(Type t) {
    return (t instanceof PairType &&
            this.left.equals(((PairType) t).left) &&
            this.right.equals(((PairType) t).right));
  }
  public String toString() {
    return "PAIR(" + left + "," + right + ")";
  }
}

class Pair {
  Object left;
  Object right;
  Pair(Object left, Object right) {
    this.left = left; this.right = right;
  }
}

abstract class Exp {
  abstract Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError;
  abstract Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError;
}

class LetExp extends Exp {
  String x;
  Exp d;
  Exp e;
  LetExp(String x, Exp d, Exp e) {this.x = x; this.d = d; this.e = e;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    Object v = d.eval(fenv,venv);
    return e.eval(fenv,new ValueEnv(x,v,venv));
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    Type t = d.check(fenv,tenv);
    return e.check(fenv,new TypeEnv(x,t,tenv));
  }
}

class VarExp extends Exp {
  String x;
  VarExp(String x) {this.x = x;}
  
  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    ValueEnv ve = ValueEnv.find(x, venv);
    if (ve != null)
      return ve.getValue();
    else
      throw new RuntimeError("undefined variable '" + x + "'"); 
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    TypeEnv te = TypeEnv.find(x, tenv);
    if (te != null)
      return te.getType();
    else
      throw new StaticError("undefined variable '"+ x + "'");
  }
}

class NumExp extends Exp {
  int num;
  NumExp(int num) {this.num = num;}

  Object eval(FunctionEnv fenv, ValueEnv venv) {
    return num;
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) {
    return Type.INT;
  }
}

class AddExp extends Exp {
  Exp left;
  Exp right;
  AddExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    try {
      return (Integer) left.eval(fenv,venv) + (Integer) right.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Add requires INT operands");
    }
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (left.check(fenv,tenv).equals(Type.INT) && right.check(fenv,tenv).equals(Type.INT))
      return Type.INT;
    else
      throw new StaticError("Add requires INT operands");
  }
}

class SubExp extends Exp {
  Exp left;
  Exp right;
  SubExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    try {
      return (Integer) left.eval(fenv,venv) - (Integer) right.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Sub requires INT operands");
    }
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (left.check(fenv,tenv).equals(Type.INT) && right.check(fenv,tenv).equals(Type.INT))
      return Type.INT;
    else
      throw new StaticError("Sub requires INT operands");
  }
}

class AndExp extends Exp {
  Exp left;
  Exp right;
  AndExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    try {
      return (Boolean) left.eval(fenv,venv) && (Boolean) right.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("And requires BOOL operands");
    }
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (left.check(fenv,tenv).equals(Type.BOOL) && right.check(fenv,tenv).equals(Type.BOOL))
      return Type.BOOL;
    else
      throw new StaticError("And requires BOOL operands");
  }
}

class NotExp extends Exp {
  Exp e;
  NotExp (Exp e) {this.e = e;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    try {
      return ! (Boolean) e.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Not requires BOOL operand");
    }
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (e.check(fenv,tenv).equals(Type.BOOL))
      return Type.BOOL;
    else
      throw new StaticError("Not requires BOOL operand");
  }
}

class LeqExp extends Exp {
  Exp left;
  Exp right;
  LeqExp (Exp left, Exp right) {this.left = left; this.right = right;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    try {
      return (Integer) left.eval(fenv,venv) <= (Integer) right.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("Leq requires INT operands");
    }
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (left.check(fenv,tenv).equals(Type.INT) && right.check(fenv,tenv).equals(Type.INT))
      return Type.BOOL;
    else
      throw new StaticError("Leq requires INT operands");
  }
}

class IfExp extends Exp {
  Exp test;
  Exp t;
  Exp f;
  IfExp (Exp test, Exp t, Exp f) {this.test = test; this.t = t; this.f = f;}

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    boolean b;
    try {
      b = (Boolean) test.eval(fenv,venv);
    } catch (ClassCastException exn) {
      throw new RuntimeError("If requires BOOL first operand");
    }
    if (b)
      return t.eval(fenv,venv);
    else
      return f.eval(fenv,venv);
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    if (test.check(fenv,tenv).equals(Type.BOOL)) {
      Type tt = t.check(fenv,tenv);
      Type ft = f.check(fenv,tenv);
      if (tt.equals(ft))
        return tt;
      else
        throw new StaticError("If requires equal types for second and third operands");
    }     
    throw new StaticError("If requires BOOL first operand");
  }
}

class CallExp extends Exp {
  String fn;  // function name
  Exp a;      // argument
  CallExp(String fn,Exp a) { this.fn = fn; this.a = a; }

  Object eval(FunctionEnv fenv, ValueEnv venv) throws RuntimeError {
    FunctionEnv fe = FunctionEnv.find(fn, fenv);
    if (fe == null)
      throw new RuntimeError("undefined function '" + fn + "'"); 
    Function f = fe.getFunction();
    Object av = a.eval(fenv,venv);
    return f.eval(fenv,av);
  }

  Type check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    FunctionEnv fe = FunctionEnv.find(fn, fenv);
    if (fe == null)
      throw new StaticError("undefined function '" + fn + "'"); 
    Function f = fe.getFunction();
    Type at = a.check(fenv,tenv);
    if (!at.equals(f.at))
      throw new StaticError("Argument expression type " + at + 
                            " does not match declared argument type " + f.at + 
                            " in call to '" + fn + "'");
    return f.rt;
  }
}

class Function {
  String fn;    // function name
  String an;    // argument name
  Type at;      // argument type
  Type rt;      // result type
  Exp b;        // body
  Function(String fn, String an, Type at, Type rt, Exp b) {
    this.fn = fn; this.an = an; this.at = at; this.rt = rt; this.b = b;
  }

  Object eval(FunctionEnv fenv, Object av) throws RuntimeError {
    return b.eval(fenv, new ValueEnv(an,av,ValueEnv.empty));
  }

  void check(FunctionEnv fenv, TypeEnv tenv) throws StaticError {
    Type bt = b.check(fenv, new TypeEnv(an, at, TypeEnv.empty));
    if (!bt.equals(rt))
      throw new StaticError("Function '" + fn + "' body type " + bt + 
                            " does not match declared type " + rt);
  }
}

class Program {
  Function[]  fs;
  Exp e;        
  FunctionEnv fenv;  // store function environment for easy lookup

  Program(Function fs[], Exp e) {
    this.fs = fs;
    this.e  = e;
 
    this.fenv = FunctionEnv.empty;
    for (Function f : fs) 
      // if a function name is duplicated, the later one shadows the earlier one
      this.fenv = new FunctionEnv(f.fn,f,this.fenv);  
  }

  Object eval() throws RuntimeError {
    ValueEnv venv = 
      new ValueEnv("true",true,
                    new ValueEnv("false",false,
                                  ValueEnv.empty));
    return e.eval(fenv,venv);
  }

  Type check() throws StaticError {
    TypeEnv tenv = 
      new TypeEnv("true",Type.BOOL,
                    new TypeEnv("false",Type.BOOL,
                                  TypeEnv.empty));
    for (Function f : fs)
      f.check(fenv,tenv);
    return e.check(fenv,tenv);
  }

}

class Example {
  public static void main(String argv[]) throws StaticError, RuntimeError {
    Program p = 
      new Program(
          new Function[] {
            new Function("fib","z",Type.INT,Type.INT,
                         new IfExp(new LeqExp(new VarExp("z"), new NumExp(1)),
                                   new VarExp("z"),
                                   new LetExp("z1",
                                              new SubExp(new VarExp("z"), new NumExp(1)),
                                              new LetExp("z2",
                                                         new SubExp(new VarExp("z"), new NumExp(2)),
                                                         new AddExp(new CallExp("fib", new VarExp("z1")),
                                                                    new CallExp("fib", new VarExp("z2"))))))) },
          new CallExp("fib", new NumExp(10)));
    try {
      System.out.println("type  = " + p.check());
      System.out.println("value = " + p.eval());
    } catch (StaticError exn) {
      System.err.println(exn.toString());
    } catch (RuntimeError exn) {
      System.err.println(exn.toString());
    }
  }
}
