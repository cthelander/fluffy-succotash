// to complete this exercise, modify this code from Example 08

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

class Ifnz extends Exp {
    private Exp iff;
    private Exp then;
    private Exp elsee;
    Ifnz(Exp iff, Exp then, Exp elsee) {this.iff = iff; this.then = then; this.elsee = elsee; }

    int eval() {
        if(0 != iff.eval())
            return then.eval();
        else 
            return elsee.eval();
    }
}

class Example {
  public static void main(String argv[]) {
    Exp e = new Ifnz ((new SubExp(new NumExp(5),
                          new AddExp(new NumExp(2),
                                      new NumExp(3)))), 
                                      new NumExp(10) , 
                                      new AddExp (new NumExp(21), 
                                                 new NumExp(21)));

    System.out.println("value = " + e.eval());
  }
}



    
