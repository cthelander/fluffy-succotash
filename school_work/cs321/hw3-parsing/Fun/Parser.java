/* Generated By:JavaCC: Do not edit this line. Parser.java */
public class Parser implements ParserConstants {
  public static void main(String[] args) {
     new Parser(System.in);
     try {
       Top();
       System.out.println("Valid syntax");
     } catch (ParseException e) {
       System.out.println("Invalid syntax at ("
                          + token.beginColumn + ","
                          + token.beginLine + "), "
                          + token.image);
     } catch (TokenMgrError e) {
       System.out.println(e.getMessage());
     }
  }

//- Parser Functions --------------------------------------------------
  static final public void Top() throws ParseException {
    if (jj_2_1(2)) {
      TopDefs();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 1:
      case 9:
      case 10:
        Func();
        jj_consume_token(0);
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void TopDefs() throws ParseException {
    Def();
  }

  static final public void Func() throws ParseException {
    RetType();
    Name();
    Formals();
    Block();
  }

  static final public void RetType() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 1:
      jj_consume_token(1);
      break;
    case 9:
    case 10:
      Type();
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Name() throws ParseException {
    jj_consume_token(IDENT);
  }

  static final public void Formals() throws ParseException {
    jj_consume_token(2);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 9:
      case 10:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      Type();
      jj_consume_token(IDENT);
    }
    jj_consume_token(3);
  }

  static final public void Stmt() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 9:
    case 10:
      Def();
      break;
    case 14:
      Prnt();
      jj_consume_token(4);
      break;
    case 7:
      Block();
      break;
    case 11:
      If();
      break;
    case 13:
      Whl();
      break;
    case 15:
      Rtrn();
      jj_consume_token(4);
      break;
    case 2:
    case INTLIT:
    case IDENT:
      Expr();
      jj_consume_token(4);
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Def() throws ParseException {
    Type();
    jj_consume_token(IDENT);
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 5:
      jj_consume_token(5);
      Expr();
      label_2:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case 6:
          ;
          break;
        default:
          jj_la1[4] = jj_gen;
          break label_2;
        }
        jj_consume_token(6);
        Expr();
      }
      break;
    default:
      jj_la1[5] = jj_gen;
      ;
    }
    jj_consume_token(4);
  }

  static final public void Block() throws ParseException {
    jj_consume_token(7);
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 2:
      case 7:
      case 9:
      case 10:
      case 11:
      case 13:
      case 14:
      case 15:
      case INTLIT:
      case IDENT:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      Stmt();
    }
    jj_consume_token(8);
  }

  static final public void Type() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 9:
      jj_consume_token(9);
      break;
    case 10:
      jj_consume_token(10);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void If() throws ParseException {
    jj_consume_token(11);
    jj_consume_token(2);
    Com();
    jj_consume_token(3);
    Stmt();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 12:
      jj_consume_token(12);
      Stmt();
      break;
    default:
      jj_la1[8] = jj_gen;
      ;
    }
  }

  static final public void Whl() throws ParseException {
    jj_consume_token(13);
    jj_consume_token(2);
    Com();
    jj_consume_token(3);
    Stmt();
  }

  static final public void Prnt() throws ParseException {
    jj_consume_token(14);
    Expr();
  }

  static final public void Rtrn() throws ParseException {
    jj_consume_token(15);
    Stmt();
  }

  static final public void Expr() throws ParseException {
    if (jj_2_2(2)) {
      jj_consume_token(IDENT);
      jj_consume_token(5);
      Expr();
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 2:
      case INTLIT:
      case IDENT:
        Or();
        break;
      default:
        jj_la1[9] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  static final public void Or() throws ParseException {
    And();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 16:
      jj_consume_token(16);
      Or();
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  static final public void And() throws ParseException {
    Com();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 17:
      jj_consume_token(17);
      And();
      break;
    default:
      jj_la1[11] = jj_gen;
      ;
    }
  }

  static final public void Com() throws ParseException {
    SubAdd();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 18:
    case 19:
    case 20:
    case 21:
    case 22:
    case 23:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 18:
        jj_consume_token(18);
        SubAdd();
        break;
      case 19:
        jj_consume_token(19);
        SubAdd();
        break;
      case 20:
        jj_consume_token(20);
        SubAdd();
        break;
      case 21:
        jj_consume_token(21);
        SubAdd();
        break;
      case 22:
        jj_consume_token(22);
        SubAdd();
        break;
      case 23:
        jj_consume_token(23);
        SubAdd();
        break;
      default:
        jj_la1[12] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[13] = jj_gen;
      ;
    }
  }

  static final public void SubAdd() throws ParseException {
    MulDiv();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 24:
    case 25:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 24:
        jj_consume_token(24);
        SubAdd();
        break;
      case 25:
        jj_consume_token(25);
        SubAdd();
        break;
      default:
        jj_la1[14] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[15] = jj_gen;
      ;
    }
  }

  static final public void MulDiv() throws ParseException {
    Par();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 26:
    case 27:
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case 26:
        jj_consume_token(26);
        MulDiv();
        break;
      case 27:
        jj_consume_token(27);
        MulDiv();
        break;
      default:
        jj_la1[16] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
      break;
    default:
      jj_la1[17] = jj_gen;
      ;
    }
  }

  static final public void Par() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case 2:
      jj_consume_token(2);
      Expr();
      jj_consume_token(3);
      break;
    case INTLIT:
    case IDENT:
      Id();
      break;
    default:
      jj_la1[18] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Id() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INTLIT:
      jj_consume_token(INTLIT);
      break;
    case IDENT:
      jj_consume_token(IDENT);
      break;
    default:
      jj_la1[19] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  static private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  static private boolean jj_3R_6() {
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(9)) {
    jj_scanpos = xsp;
    if (jj_scan_token(10)) return true;
    }
    return false;
  }

  static private boolean jj_3R_4() {
    if (jj_3R_5()) return true;
    return false;
  }

  static private boolean jj_3_2() {
    if (jj_scan_token(IDENT)) return true;
    if (jj_scan_token(5)) return true;
    return false;
  }

  static private boolean jj_3_1() {
    if (jj_3R_4()) return true;
    return false;
  }

  static private boolean jj_3R_5() {
    if (jj_3R_6()) return true;
    if (jj_scan_token(IDENT)) return true;
    return false;
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public ParserTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private Token jj_scanpos, jj_lastpos;
  static private int jj_la;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[20];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x602,0x602,0x600,0xee84,0x40,0x20,0xee84,0x600,0x1000,0x4,0x10000,0x20000,0xfc0000,0xfc0000,0x3000000,0x3000000,0xc000000,0xc000000,0x4,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x0,0x0,0x0,0xc,0x0,0x0,0xc,0x0,0x0,0xc,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0x0,0xc,0xc,};
   }
  static final private JJCalls[] jj_2_rtns = new JJCalls[2];
  static private boolean jj_rescan = false;
  static private int jj_gc = 0;

  /** Constructor with InputStream. */
  public Parser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Parser(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public Parser(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new ParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public Parser(ParserTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(ParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 20; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  static final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  static private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;
  static private int[] jj_lasttokens = new int[100];
  static private int jj_endpos;

  static private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      boolean exists = false;
      for (java.util.Iterator<?> it = jj_expentries.iterator(); it.hasNext();) {
        exists = true;
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              exists = false;
              break;
            }
          }
          if (exists) break;
        }
      }
      if (!exists) jj_expentries.add(jj_expentry);
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[36];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 20; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 36; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  static private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 2; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  static private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

}