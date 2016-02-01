abstract class T {
  abstract ImmSet<Integer> contents();
  abstract boolean hasDups();    
}

class T0 extends T {
  ImmSet<Integer> contents() {
    return ImmSet.<Integer>empty();
  }
  boolean hasDups() {
    return false;
  }
}

class T1 extends T {
  private int x;
  private T left;
  private T right;
  T1 (int x, T left, T right) { this.x = x; this.left = left; this.right = right; }

  ImmSet<Integer> contents() {
    return ImmSet.plus(ImmSet.union(left.contents(),
				    right.contents()),
		       x);
  }
  boolean hasDups() {
    return left.hasDups() || right.hasDups() || 
           left.contents().contains(x) || right.contents().contains(x);
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T1(2, new T1(3, new T0(),
                              new T0()), 
                    new T1(3, new T1(2, new T0(),
                                        new T0()), 
                              new T1(2, new T0(),
				     new T0())));
    System.out.println ("duplicates = "+ t.hasDups());
  }
}
    
