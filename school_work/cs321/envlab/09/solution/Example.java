abstract class Exp {
  abstract int eval();
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
  private Exp test;
  private Exp nz;
  private Exp z;
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
    Exp e = new IfnzExp(new SubExp(new NumExp(5),
                                   new AddExp(new NumExp(2),
                                              new NumExp(3))),
                        new NumExp(10),
                        new AddExp(new NumExp(21),
                                   new NumExp(21)));
    System.out.println("value = " + e.eval());
  }
}



    