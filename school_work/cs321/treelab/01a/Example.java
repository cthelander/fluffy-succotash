class T {
  private int x;
  private T left;
  private T right;
  T (int x, T left, T right) {
    this.x = x; this.left = left; this.right = right;
  }

  private static int s;

  private void addToSum() {
    s += x;
    if (left != null) 
      left.addToSum();
    if (right != null)
      right.addToSum();
  }

  static int sum(T t) {
    s = 0;
    t.addToSum();
    return s;
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T (1, new T(2, null, 
                             null), 
                    new T(4, null, 
                             new T(3, null, 
                                      null)));
    System.out.println ("sum = " + T.sum(t));
  }
}
    