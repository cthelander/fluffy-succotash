// Carly Thelander 00-59 regex example

// jflex Example.jflex 
// javac Yylex.java
// java Yylex test.mini

/* user code */

%%

/* operations and declarations */
%standalone

%%

/* lexical rules */

[0-5][0-9]	     	{ System.out.print(yytext()+": accepted"); }
[0-5][0-9].+		{ System.out.print(yytext()+": not accepted"); }
[a-z]+		        { System.out.print(yytext()+": not accepted"); }
.|\n                {  }
