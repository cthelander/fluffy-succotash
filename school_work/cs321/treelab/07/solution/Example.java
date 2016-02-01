abstract class T {
  boolean isDup = false;
  abstract void setDups (ImmSet<Integer> s);
  abstract void print(int n);
  static void indent(int n, String m) {
    for (int i=0; i<n; i++) 
      System.out.print(" ");
    System.out.println(m);
  }
}

class T0 extends T {
  void print(int n) {
  }
  void setDups(ImmSet<Integer> s) {
    isDup = false;
  }
}

class T1 extends T {
  int x;
  T left;
  T right;
  T1 (int x, T left, T right) { this.x = x; this.left = left; this.right = right; }

  void print(int n) {
    indent(n, "" + x + " " + isDup);
    left.print(n+1);
    right.print(n+1);
  }

  void setDups(ImmSet<Integer> s) {
    isDup = s.contains(x);
    ImmSet<Integer> sx = ImmSet.plus(s,x);
    left.setDups(sx);
    right.setDups(sx);
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T1(1, new T1(3, new T1(4, new T0(),
                                        new T0()),
			      new T1(3, new T0(),
                                        new T0())),
                    new T1(1, new T0(),
                              new T0()));
    t.setDups(ImmSet.<Integer>empty());
    t.print(0);
  }

}
    