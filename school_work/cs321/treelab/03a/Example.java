abstract class T {
}

class T0 extends T {
}

class T1 extends T {
  int x;
  T left;
  T right;
  T1 (int x, T left, T right) { 
    this.x = x; this.left = left; this.right = right; 
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T1 (1, new T1(2, new T0(),
                               new T0()),
                     new T1(4, new T0(),
                               new T1(3, new T0(),
                                         new T0())));
    System.out.println ("sum = " + sum(t));
  }

  static int sum (T t) {
    if (t instanceof T0) 
      return 0;
    else if (t instanceof T1) {
      T1 t1 = (T1) t;
      return t1.x + sum(t1.left) + sum(t1.right);
    } else
      throw new Error("impossible");
  }
}





