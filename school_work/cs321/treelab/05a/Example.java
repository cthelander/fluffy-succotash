import java.util.*;

abstract class T {
  static Set<Integer> s;
  abstract void addToContents();
  static Set<Integer> contents(T t) {
    s = new HashSet<Integer>();
    t.addToContents();
    return s;
  }
}

class T0 extends T {
  private int x;
  T0 (int x) { this.x = x; }
  
  void addToContents() {
    s.add(x);
  }
}

class T2 extends T {
  private int x;
  private T left;
  private T right;
  T2 (int x, T left, T right) { this.x = x; this.left = left; this.right = right; }

  void addToContents() {
    s.add(x);
    left.addToContents();
    right.addToContents();
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T2(1, new T0(2), 
                    new T2(3, new T0(4), 
                              new T0(3)));
    System.out.println ("distinct elements = " + T.contents(t).size());
  }

}
    