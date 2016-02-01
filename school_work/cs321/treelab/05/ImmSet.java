import java.util.*;

/** The constructors and methods in this class produce
 * new sets from old sets, without changing the old sets.
 * By using these methods to build sets, we can guarantee that
 * the sets are _immutable_ (their contents never change)
 * and _persistent_ (old versions are always available).
 * This kind of data structure is often called _functional_
 * (as opposed to _imperative_). 

 * Warning: this is a very inefficient implementation of 
 * immutable sets!  (It simply delegates the representation of the
 * sets to a standard Java library HashSet, and each construction
 * operation causes a copy of the entire set.) There are much 
 * better approaches!
 */
public class ImmSet<T> {
  private Set<T> s;   // the underlying set
  
  private ImmSet(Set<T> s) {    
    this.s = s;
  }

  // Set Construction

  // To call this, write something like ImmSet.<Integer>empty().
  public static <T> ImmSet<T> empty() {
    return new ImmSet<T>(new HashSet<T>());
  }

  public static <T> ImmSet<T> singleton(T x) {
    Set<T> s = new HashSet<T>();
    s.add(x);
    return new ImmSet<T>(s);
  }

  public static <T> ImmSet<T> plus(ImmSet<T> a, T x) { 
    Set<T> s = new HashSet<T>(a.s);
    s.add(x);
    return new ImmSet<T>(s);
  }

  public static <T> ImmSet<T> union(ImmSet<T> a1,ImmSet<T> a2) {
    Set<T> s = new HashSet<T>(a1.s);
    s.addAll(a2.s);
    return new ImmSet<T>(s);
  }

  public static <T> ImmSet<T> intersect(ImmSet<T> a1,ImmSet<T> a2) {
    Set<T> s = new HashSet<T>();
    for (T x : a1.s)
      if (a2.s.contains(x))
	s.add(x);
    return new ImmSet<T>(s);
  }

  // Set Inspection

  public boolean contains(T x) {
    return s.contains(x);
  }

  public int size() {
    return s.size();
  }
}
