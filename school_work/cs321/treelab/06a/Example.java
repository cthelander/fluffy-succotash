// A more efficient traversal strategy that only requires
// one pass over the tree, returning _two_ pieces of information
// from each node. 

// Define a class to carry a pair of values.
class DC {
  boolean hasDups;
  ImmSet<Integer> contents;
  DC (boolean hasDups, ImmSet<Integer> contents) {
    this.hasDups = hasDups; this.contents = contents;
  }
}

abstract class T {
  abstract DC reduce(); 
}

class T0 extends T {
  DC reduce() {
    return new DC(false, ImmSet.<Integer>empty());
  }
}

class T1 extends T {
  private int x;
  private T left;
  private T right;
  T1 (int x, T left, T right) { this.x = x; this.left = left; this.right = right; }

  DC reduce() {
    DC l = left.reduce();
    DC r = right.reduce();
    boolean hasDups = l.hasDups || r.hasDups || 
	              l.contents.contains(x) || r.contents.contains(x);
    ImmSet<Integer> contents = ImmSet.plus(ImmSet.union(l.contents,
							r.contents),
					   x);
    return new DC(hasDups,contents);
  }
}

class Example {
  public static void main (String argv[]) {
    T t = new T1(1, new T1(2, new T0(),
                              new T0()), 
                    new T1(3, new T1(4, new T0(),
                                        new T0()), 
                              new T1(2, new T0(),
				     new T0())));
    System.out.println ("duplicates = "+ t.reduce().hasDups);
  }

}
    
