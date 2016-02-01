class TestHeap3 {
  static final int S = 100;

  public static void main(String[] args) {
    Heap h = Heap.make(S);
    h.a = h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.b = h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);
    h.alloc(9);


    h.dump();
    System.out.println("Free space remaining = " + h.freeSpace());

    h.garbageCollect();

    h.dump();
    System.out.println("Free space remaining = " + h.freeSpace());
  }
}
