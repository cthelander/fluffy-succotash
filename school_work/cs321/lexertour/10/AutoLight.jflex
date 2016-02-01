// Carly Thelander

%%

%standalone

%class AutoLight

// This section sets the style for the html output including the font
%init{
  System.out.println("<html>");
  System.out.println("<head>");
  System.out.println("<title>My AutoLight Web Page</title>");
  System.out.println("<style type=\"text/css\">");
  System.out.println("  body     {white-space:pre;");
  System.out.println("            background-color:#ffffcc;");
  System.out.println("            color:black;");
  System.out.println("            font-family:\"Lucida Console\",\"Courier New\",Monotype}");
  System.out.println("</style>");
  System.out.println("</head>");
  System.out.println("<body>");
%init}

// This section will be executed when the input file reaches the end.

%eof{
  System.out.println("</body>");
  System.out.println("</html>");
%eof}

// This echo function takes the input and displays it in the html output
// it also handles the special charecters that mean something different
// in html and would change the meaning of the output html.

%{
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
%}

// The tag and tag2 functions make the tokens recognized by the regular expessions
// into links in the html output. The email, times, ipv4, and websites without 
// http or https at the fron use the tag function and websites with http or https
// use the tag to function.

%{
  void tag(String cl) {
    System.out.print("<a href=\"" + cl + "://");
    echo();
    System.out.print("\">");
    echo();
    System.out.print("</a>");
  }
  void tag2() {
    System.out.print("<a href=\"" );
    echo();
    System.out.print("\">");
    echo();
    System.out.print("</a>");
  }
%}

// The parameter cl is used to specify a particular kind of link
// either a clock, mailto, ping or http kind of link.

%{
  void time12()     { tag("clock"); }
  void time24()     { tag("clock"); }
  void email()      { tag("mailto"); }
  void ipAdd()      { tag("ping"); }
  void website()    { tag("http"); }
  void preWeb()     { tag2(); }
  
%}

// regular expressions for each of the input elements that are to be linked


// Times in both 12 and 24 hour times macros

Hour12             = (0?{N}|1[0-2])":"
Hour24             = [0-1]{N}|2[0-3]
Minute             = [0-5]{N}
Suffix             = [aApP][mM]|[aApP]\.[mM]\.
Time24             = {Hour24}{Minute}{WhiteSpace}*{Suffix}?
Time12             = {Hour12}{Minute}{WhiteSpace}*{Suffix}?

// Invalid times that should not be linked

NumTime            = {N}+({Hour24}|{Hour12})  
TimeNum            = ({Minute}){N}+  
Long24             = {Time24}{N}+
InvalidTime        = ({NumTime})|({Hour12}{TimeNum})|{Long24}

// Email address macros

Email              = {Name}"@"{WholeDomain}
Name               = (([a-z]|[A-Z])|{N}[~_.+-])+
Domain             = (([a-z]|[A-Z])|{N}|[~_+-])+
WholeDomain        = {Domain}\.{Domain}(\.{Domain})?(\.{Domain})?

// Invalid email address

InvalidEmail       = {Email}\.{Domain}

// Website macro

File               = "/"{Domain}"/"? 
Prefix             = "http://" | "https://"
Website            = {WholeDomain}{File}*
PreWeb             = {Prefix}?{WholeDomain}{File}*

// Invalid websites

BadPrefix          = ([a-z]|[A-Z])+{Prefix}{WholeDomain}{File}*
TooManySlashes     = {Prefix}[/]+{WholeDomain}{File}*
TooLong            = {Domain}\.{Domain}\.{Domain}\.{Domain}\.{Domain}
InvalidURL         = {BadPrefix}|{TooLong}|{TooManySlashes}

// Ip address macro

NumIp              = ({N})|({N}{N})|([0-1]{N}{N})|2([0-4]{N})|25[0-5]
IpAdd              = {NumIp}\.{NumIp}\.{NumIp}\.{NumIp}

// Invalid ip address

TooShort           = {NumIp}\.{NumIp}|{NumIp}\.{NumIp}\.{NumIp}
InvalidIp          = {TooShort}|{TooHigh}
BigNum             = 2((5[6-9])|([6-9]{N}))|([3-9]{N}{N})|({N}{N}{N}+)
TooHigh            = {BigNum}\.{NumIp}\.{NumIp}\.{NumIp}
                     |{NumIp}\.{BigNum}\.{NumIp}\.{NumIp}
                     |{NumIp}\.{NumIp}\.{BigNum}\.{NumIp}
                     |{NumIp}\.{NumIp}\.{NumIp}\.{BigNum}
 
// macros for the white spcaes that might be present in the input

LineTerminator     = \r|\n|\r\n
WhiteSpace         = {LineTerminator} | [ \t\f] 

// Macro for holding the integers 0 through 9

N                  = [0-9]

// rules for matching the differen tokens that can appear in a file with corresponding actions
// to generate the appropriate output in each case.

%%


//the functions that are called when the attached macros are found in the input
// so call the echo function and are just out put but others call the functions 
// to turn them into links

{InvalidTime}  { echo(); }
{IpAdd}        { ipAdd(); }
{InvalidEmail} { echo(); }
{InvalidIp}    { echo(); }
{InvalidURL}   { echo(); }
{Time12}       { time12(); }
{Time24}       { time24(); }
{Email}        { email(); }
{Website}      { website(); }
{PreWeb}       { preWeb(); }


// whitespace are output without any action

{WhiteSpace}    { echo(); }

// a catch all that matches any input not already matched and outputs it

.|\n            { echo(); }

// Notes:
// Getting the correct regular expression to find the right cases and link them
// was not the hard part most of mine worked on the first try when I used a
// test file with some input that I came up with it worked great the hard part 
// was not recognizing things. I thought from my test program I created that my 
// I had dont ir perfectly but when I ran the test program from the customer through
// it way more was linked then should have been and all of the links that should 
// have been ip addresses were actullay websites. So I then had to create all of
// cases for invalid input and after a lot of trial an error and about 20 passes
// I was able to get all of the links working correctly with not extra links.
// besides the invalid macros I also tested the ordering to make sure the I was
// taking advantage of the miximal munch. I had to put the invalid macros fist 
// because most of the included longer leximes then the valid macros.  


// ---------------------------------------------------------------------

