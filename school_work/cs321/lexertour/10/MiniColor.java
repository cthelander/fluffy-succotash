/* The following code was generated by JFlex 1.4.3 on 1/24/15 8:15 PM */

// Carly Thelander


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 1/24/15 8:15 PM from the specification file
 * <tt>AutoLight.jflex</tt>
 */
class MiniColor {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\2\1\5\1\4\1\0\1\5\1\3\16\2\4\0\1\5\1\11"+
    "\2\0\1\1\1\0\1\12\1\0\1\5\1\5\1\7\1\5\1\5"+
    "\1\5\1\0\1\6\12\32\1\0\1\5\1\11\1\10\1\11\2\0"+
    "\32\1\1\5\1\0\1\5\1\5\1\1\1\0\1\23\1\17\2\1"+
    "\1\22\1\26\1\1\1\25\1\14\2\1\1\21\1\1\1\15\1\20"+
    "\1\30\1\1\1\31\1\27\1\16\2\1\1\24\3\1\1\5\1\13"+
    "\1\5\1\5\41\2\2\0\4\1\4\0\1\1\2\0\1\2\7\0"+
    "\1\1\4\0\1\1\5\0\27\1\1\0\37\1\1\0\u01ca\1\4\0"+
    "\14\1\16\0\5\1\7\0\1\1\1\0\1\1\21\0\160\2\5\1"+
    "\1\0\2\1\2\0\4\1\10\0\1\1\1\0\3\1\1\0\1\1"+
    "\1\0\24\1\1\0\123\1\1\0\213\1\1\0\5\2\2\0\236\1"+
    "\11\0\46\1\2\0\1\1\7\0\47\1\11\0\55\2\1\0\1\2"+
    "\1\0\2\2\1\0\2\2\1\0\1\2\10\0\33\1\5\0\3\1"+
    "\15\0\4\2\7\0\1\1\4\0\13\2\5\0\53\1\37\2\4\0"+
    "\2\1\1\2\143\1\1\0\1\1\10\2\1\0\6\2\2\1\2\2"+
    "\1\0\4\2\2\1\12\2\3\1\2\0\1\1\17\0\1\2\1\1"+
    "\1\2\36\1\33\2\2\0\131\1\13\2\1\1\16\0\12\2\41\1"+
    "\11\2\2\1\4\0\1\1\5\0\26\1\4\2\1\1\11\2\1\1"+
    "\3\2\1\1\5\2\22\0\31\1\3\2\244\0\4\2\66\1\3\2"+
    "\1\1\22\2\1\1\7\2\12\1\2\2\2\0\12\2\1\0\7\1"+
    "\1\0\7\1\1\0\3\2\1\0\10\1\2\0\2\1\2\0\26\1"+
    "\1\0\7\1\1\0\1\1\3\0\4\1\2\0\1\2\1\1\7\2"+
    "\2\0\2\2\2\0\3\2\1\1\10\0\1\2\4\0\2\1\1\0"+
    "\3\1\2\2\2\0\12\2\4\1\7\0\1\1\5\0\3\2\1\0"+
    "\6\1\4\0\2\1\2\0\26\1\1\0\7\1\1\0\2\1\1\0"+
    "\2\1\1\0\2\1\2\0\1\2\1\0\5\2\4\0\2\2\2\0"+
    "\3\2\3\0\1\2\7\0\4\1\1\0\1\1\7\0\14\2\3\1"+
    "\1\2\13\0\3\2\1\0\11\1\1\0\3\1\1\0\26\1\1\0"+
    "\7\1\1\0\2\1\1\0\5\1\2\0\1\2\1\1\10\2\1\0"+
    "\3\2\1\0\3\2\2\0\1\1\17\0\2\1\2\2\2\0\12\2"+
    "\1\0\1\1\17\0\3\2\1\0\10\1\2\0\2\1\2\0\26\1"+
    "\1\0\7\1\1\0\2\1\1\0\5\1\2\0\1\2\1\1\7\2"+
    "\2\0\2\2\2\0\3\2\10\0\2\2\4\0\2\1\1\0\3\1"+
    "\2\2\2\0\12\2\1\0\1\1\20\0\1\2\1\1\1\0\6\1"+
    "\3\0\3\1\1\0\4\1\3\0\2\1\1\0\1\1\1\0\2\1"+
    "\3\0\2\1\3\0\3\1\3\0\14\1\4\0\5\2\3\0\3\2"+
    "\1\0\4\2\2\0\1\1\6\0\1\2\16\0\12\2\11\0\1\1"+
    "\7\0\3\2\1\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1"+
    "\1\0\5\1\3\0\1\1\7\2\1\0\3\2\1\0\4\2\7\0"+
    "\2\2\1\0\2\1\6\0\2\1\2\2\2\0\12\2\22\0\2\2"+
    "\1\0\10\1\1\0\3\1\1\0\27\1\1\0\12\1\1\0\5\1"+
    "\2\0\1\2\1\1\7\2\1\0\3\2\1\0\4\2\7\0\2\2"+
    "\7\0\1\1\1\0\2\1\2\2\2\0\12\2\1\0\2\1\17\0"+
    "\2\2\1\0\10\1\1\0\3\1\1\0\51\1\2\0\1\1\7\2"+
    "\1\0\3\2\1\0\4\2\1\1\10\0\1\2\10\0\2\1\2\2"+
    "\2\0\12\2\12\0\6\1\2\0\2\2\1\0\22\1\3\0\30\1"+
    "\1\0\11\1\1\0\1\1\2\0\7\1\3\0\1\2\4\0\6\2"+
    "\1\0\1\2\1\0\10\2\22\0\2\2\15\0\60\1\1\2\2\1"+
    "\7\2\4\0\10\1\10\2\1\0\12\2\47\0\2\1\1\0\1\1"+
    "\2\0\2\1\1\0\1\1\2\0\1\1\6\0\4\1\1\0\7\1"+
    "\1\0\3\1\1\0\1\1\1\0\1\1\2\0\2\1\1\0\4\1"+
    "\1\2\2\1\6\2\1\0\2\2\1\1\2\0\5\1\1\0\1\1"+
    "\1\0\6\2\2\0\12\2\2\0\2\1\42\0\1\1\27\0\2\2"+
    "\6\0\12\2\13\0\1\2\1\0\1\2\1\0\1\2\4\0\2\2"+
    "\10\1\1\0\44\1\4\0\24\2\1\0\2\2\5\1\13\2\1\0"+
    "\44\2\11\0\1\2\71\0\53\1\24\2\1\1\12\2\6\0\6\1"+
    "\4\2\4\1\3\2\1\1\3\2\2\1\7\2\3\1\4\2\15\1"+
    "\14\2\1\1\17\2\2\0\46\1\12\0\53\1\1\0\1\1\3\0"+
    "\u0149\1\1\0\4\1\2\0\7\1\1\0\1\1\1\0\4\1\2\0"+
    "\51\1\1\0\4\1\2\0\41\1\1\0\4\1\2\0\7\1\1\0"+
    "\1\1\1\0\4\1\2\0\17\1\1\0\71\1\1\0\4\1\2\0"+
    "\103\1\2\0\3\2\40\0\20\1\20\0\125\1\14\0\u026c\1\2\0"+
    "\21\1\1\0\32\1\5\0\113\1\3\0\3\1\17\0\15\1\1\0"+
    "\4\1\3\2\13\0\22\1\3\2\13\0\22\1\2\2\14\0\15\1"+
    "\1\0\3\1\1\0\2\2\14\0\64\1\40\2\3\0\1\1\3\0"+
    "\2\1\1\2\2\0\12\2\41\0\3\2\2\0\12\2\6\0\130\1"+
    "\10\0\51\1\1\2\1\1\5\0\106\1\12\0\35\1\3\0\14\2"+
    "\4\0\14\2\12\0\12\2\36\1\2\0\5\1\13\0\54\1\4\0"+
    "\21\2\7\1\2\2\6\0\12\2\46\0\27\1\5\2\4\0\65\1"+
    "\12\2\1\0\35\2\2\0\13\2\6\0\12\2\15\0\1\1\130\0"+
    "\5\2\57\1\21\2\7\1\4\0\12\2\21\0\11\2\14\0\3\2"+
    "\36\1\12\2\3\0\2\1\12\2\6\0\46\1\16\2\14\0\44\1"+
    "\24\2\10\0\12\2\3\0\3\1\12\2\44\1\122\0\3\2\1\0"+
    "\25\2\4\1\1\2\4\1\1\2\15\0\300\1\47\2\25\0\4\2"+
    "\u0116\1\2\0\6\1\2\0\46\1\2\0\6\1\2\0\10\1\1\0"+
    "\1\1\1\0\1\1\1\0\1\1\1\0\37\1\2\0\65\1\1\0"+
    "\7\1\1\0\1\1\3\0\3\1\1\0\7\1\3\0\4\1\2\0"+
    "\6\1\4\0\15\1\5\0\3\1\1\0\7\1\16\0\5\2\32\0"+
    "\5\2\20\0\2\1\23\0\1\1\13\0\5\2\5\0\6\2\1\0"+
    "\1\1\15\0\1\1\20\0\15\1\3\0\32\1\26\0\15\2\4\0"+
    "\1\2\3\0\14\2\21\0\1\1\4\0\1\1\2\0\12\1\1\0"+
    "\1\1\3\0\5\1\6\0\1\1\1\0\1\1\1\0\1\1\1\0"+
    "\4\1\1\0\13\1\2\0\4\1\5\0\5\1\4\0\1\1\21\0"+
    "\51\1\u0a77\0\57\1\1\0\57\1\1\0\205\1\6\0\4\1\3\2"+
    "\16\0\46\1\12\0\66\1\11\0\1\1\17\0\1\2\27\1\11\0"+
    "\7\1\1\0\7\1\1\0\7\1\1\0\7\1\1\0\7\1\1\0"+
    "\7\1\1\0\7\1\1\0\7\1\1\0\40\2\57\0\1\1\u01d5\0"+
    "\3\1\31\0\11\1\6\2\1\0\5\1\2\0\5\1\4\0\126\1"+
    "\2\0\2\2\2\0\3\1\1\0\132\1\1\0\4\1\5\0\51\1"+
    "\3\0\136\1\21\0\33\1\65\0\20\1\u0200\0\u19b6\1\112\0\u51cc\1"+
    "\64\0\u048d\1\103\0\56\1\2\0\u010d\1\3\0\20\1\12\2\2\1"+
    "\24\0\57\1\1\2\14\0\2\2\1\0\31\1\10\0\120\1\2\2"+
    "\45\0\11\1\2\0\147\1\2\0\4\1\1\0\2\1\16\0\12\1"+
    "\120\0\10\1\1\2\3\1\1\2\4\1\1\2\27\1\5\2\20\0"+
    "\1\1\7\0\64\1\14\0\2\2\62\1\21\2\13\0\12\2\6\0"+
    "\22\2\6\1\3\0\1\1\4\0\12\2\34\1\10\2\2\0\27\1"+
    "\15\2\14\0\35\1\3\0\4\2\57\1\16\2\16\0\1\1\12\2"+
    "\46\0\51\1\16\2\11\0\3\1\1\2\10\1\2\2\2\0\12\2"+
    "\6\0\27\1\3\0\1\1\1\2\4\0\60\1\1\2\1\1\3\2"+
    "\2\1\2\2\5\1\2\2\1\1\1\2\1\1\30\0\3\1\43\0"+
    "\6\1\2\0\6\1\2\0\6\1\11\0\7\1\1\0\7\1\221\0"+
    "\43\1\10\2\1\0\2\2\2\0\12\2\6\0\u2ba4\1\14\0\27\1"+
    "\4\0\61\1\u2104\0\u012e\1\2\0\76\1\2\0\152\1\46\0\7\1"+
    "\14\0\5\1\5\0\1\1\1\2\12\1\1\0\15\1\1\0\5\1"+
    "\1\0\1\1\1\0\2\1\1\0\2\1\1\0\154\1\41\0\u016b\1"+
    "\22\0\100\1\2\0\66\1\50\0\15\1\3\0\20\2\20\0\7\2"+
    "\14\0\2\1\30\0\3\1\31\0\1\1\6\0\5\1\1\0\207\1"+
    "\2\0\1\2\4\0\1\1\13\0\12\2\7\0\32\1\4\0\1\1"+
    "\1\0\32\1\13\0\131\1\3\0\6\1\2\0\6\1\2\0\6\1"+
    "\2\0\3\1\3\0\2\1\3\0\2\1\22\0\3\2\4\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\14\2\1\3\2\0\1\2\1\4\4\2"+
    "\2\5\2\0\4\2\1\0\3\2";

  private static int [] zzUnpackAction() {
    int [] result = new int[35];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\33\0\66\0\121\0\33\0\154\0\207\0\242"+
    "\0\275\0\330\0\363\0\u010e\0\u0129\0\u0144\0\u015f\0\u017a"+
    "\0\u0195\0\u01b0\0\66\0\u01cb\0\u01e6\0\u0201\0\u021c\0\u0237"+
    "\0\33\0\u0252\0\u026d\0\u0288\0\u02a3\0\u02be\0\u02d9\0\u02f4"+
    "\0\u030f\0\u032a\0\u0345";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[35];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\2\1\4\2\5\1\6\1\5\2\7"+
    "\1\10\1\11\1\12\2\3\1\13\2\3\1\14\1\3"+
    "\1\15\3\3\1\16\1\3\1\17\34\0\2\3\11\0"+
    "\17\3\4\0\1\5\34\0\1\20\1\21\33\0\1\5"+
    "\34\0\1\5\33\0\1\5\20\0\2\3\11\0\1\3"+
    "\1\22\10\3\1\23\4\3\1\0\2\3\11\0\4\3"+
    "\1\24\12\3\1\0\2\3\11\0\5\3\1\25\11\3"+
    "\1\0\2\3\11\0\11\3\1\26\5\3\1\0\2\3"+
    "\11\0\15\3\1\27\1\3\32\0\1\17\3\20\1\30"+
    "\1\31\26\20\7\32\1\33\23\32\1\0\2\3\11\0"+
    "\2\3\1\23\14\3\1\0\2\3\11\0\4\3\1\34"+
    "\12\3\1\0\2\3\11\0\13\3\1\35\3\3\1\0"+
    "\2\3\11\0\1\36\16\3\1\0\2\3\11\0\1\37"+
    "\16\3\4\0\1\31\26\0\7\32\1\40\23\32\6\0"+
    "\1\31\1\33\24\0\2\3\11\0\5\3\1\41\11\3"+
    "\1\0\2\3\11\0\6\3\1\23\10\3\1\0\2\3"+
    "\11\0\5\3\1\35\11\3\1\0\2\3\11\0\1\3"+
    "\1\22\15\3\6\32\1\31\1\40\23\32\1\0\2\3"+
    "\11\0\6\3\1\42\10\3\1\0\2\3\11\0\7\3"+
    "\1\43\7\3\1\0\2\3\11\0\1\3\1\23\15\3";

  private static int [] zzUnpackTrans() {
    int [] result = new int[864];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\2\1\1\11\12\1\2\0\7\1\1\11"+
    "\2\0\4\1\1\0\3\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[35];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  void echo() {
    int len = yylength();       // Find length of current lexeme
    for (int i=0; i<len; i++) { // Run through each character in turn
      char c = yycharat(i);   
      switch (c) {              // and translate as appropriate ...
        case '<' : System.out.print("&lt;");  break;
        case '>' : System.out.print("&gt;");  break;
        case '&' : System.out.print("&amp;"); break;
        default  : System.out.print(c);       break;
      }
    }
  }
  void tag(String cl) {
    System.out.print("<span class=\"" + cl + "\">");
    echo();
    System.out.print("</span>");
  }
  void keyword() { tag("keyword"); }
  void comment() { tag("comment"); }
  void literal() { tag("literal"); }
  void invalid() { tag("invalid"); }


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  MiniColor(java.io.Reader in) {
    System.out.println("<html>");
  System.out.println("<head>");
  System.out.println("<title>My Syntax Colored Web Page</title>");
  System.out.println("<style type=\"text/css\">");
  System.out.println("  body     {white-space:pre;");
  System.out.println("            background-color:#ffffcc;");
  System.out.println("            color:black;");
  System.out.println("            font-family:\"Lucida Console\",\"Courier New\",Monotype}");
  System.out.println("  .keyword {color:blue}");
  System.out.println("  .comment {color:orange}");
  System.out.println("  .literal {color:green}");
  System.out.println("  .invalid {color:red}");
  System.out.println("</style>");
  System.out.println("</head>");
  System.out.println("<body>");
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  MiniColor(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 2198) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
      System.out.println("</body>");
  System.out.println("</html>");

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public int yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 2: 
          { echo();
          }
        case 6: break;
        case 3: 
          { literal();
          }
        case 7: break;
        case 5: 
          { comment();
          }
        case 8: break;
        case 4: 
          { keyword();
          }
        case 9: break;
        case 1: 
          { System.err.println("Invalid input");
                  System.exit(1);
          }
        case 10: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
            return YYEOF;
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }

  /**
   * Runs the scanner on input files.
   *
   * This is a standalone scanner, it will print any unmatched
   * text to System.out unchanged.
   *
   * @param argv   the command line, contains the filenames to run
   *               the scanner on.
   */
  public static void main(String argv[]) {
    if (argv.length == 0) {
      System.out.println("Usage : java MiniColor <inputfile>");
    }
    else {
      for (int i = 0; i < argv.length; i++) {
        MiniColor scanner = null;
        try {
          scanner = new MiniColor( new java.io.FileReader(argv[i]) );
          while ( !scanner.zzAtEOF ) scanner.yylex();
        }
        catch (java.io.FileNotFoundException e) {
          System.out.println("File not found : \""+argv[i]+"\"");
        }
        catch (java.io.IOException e) {
          System.out.println("IO error scanning file \""+argv[i]+"\"");
          System.out.println(e);
        }
        catch (Exception e) {
          System.out.println("Unexpected exception:");
          e.printStackTrace();
        }
      }
    }
  }


}