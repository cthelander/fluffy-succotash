class Main {
  public static void main(String[] args) {
    Stmt s
     = new Seq(new Assign("t", new Int(0)),
       new Seq(new Assign("i", new Int(0)),
               new If(new Even(new Int(2)), 
               new Print(new Half(new Int(7))),
               new Print(new Half(new Int(2))))));

    System.out.println("Complete program is:");
    s.print(4);

    System.out.println("Running on an empty memory:");
    Memory mem = new Memory();
    s.exec(mem);

    System.out.println("Compiling:");
    Program p     = new Program();
    Block   entry = p.block(s.compile(p, new Stop()));
    System.out.println("Entry point is at " + entry);
    p.show();

    System.out.println("Running on an empty memory:");
    mem      = new Memory();
    Block pc = entry;
    while (pc!=null)  {
      pc = pc.code().run(mem);
    } 

    System.out.println("Done!");
  }
}
