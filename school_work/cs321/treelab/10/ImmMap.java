import java.util.*;

/**  Immutable maps from keys K to values V. Again,not very efficient! */
public class ImmMap<K,V> {
  private Map<K,V> m; // the underlying map

  private ImmMap(Map<K,V> m) {
    this.m = m;
  }

  // Map construction 

  // Call this with something like ImmMap.<String,Integer>empty() 
  static <K,V> ImmMap<K,V> empty() {    
      return new ImmMap<K,V>(new HashMap<K,V>());
  }

  static <K,V> ImmMap<K,V> extend(K k, V v, ImmMap<K,V> a) {
    Map<K,V> m = new HashMap<K,V>(a.m);
    m.put(k,v);
    return new ImmMap<K,V>(m);
  }

  // Map inspection

  V get(K k) {
    return m.get(k);
  }

  Set<K> keySet() {
    return m.keySet();
  }

  Collection<V> values() {
    return m.values();
  }
}
