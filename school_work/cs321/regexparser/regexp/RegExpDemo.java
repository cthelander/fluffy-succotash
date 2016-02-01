// This is supporting software for CS321 Compilers and Language Design I
// Copyright (c) Mark P Jones, Portland State University

package regexp;

/** A quick demo of the RegExp AST classes in this package.
 */
public class RegExpDemo {
    public static void main(String[] args) {
        RegExp r = new Rep(new Alt(new Char('a'), new Char('b')));

        // Print out in fully parenthesized form:
        System.out.println("r = " + r. fullParens());

        // Generate a dot version of the AST:
        r.toDot("ast.dot");

        // Generate an NFA, capturing the start state in p, and
        // terminating in an accept state, done, with no transitions.
        State done  = new State();
        done.accept = 1;
        done.trans  = new Transition[0];
        State p     = r.toNFA(done);

        // Find and display the set of all NFA states, starting from p:
        System.out.println("NFA: --------------");
        State[] nfaStates = p.reachableStates();
        State.display(nfaStates);
        DotOutput.toDot(nfaStates, "nfa.dot");

        // Find and display the corresponding DFA:
        System.out.println("DFA: --------------");
        State[] dfaStates = State.toDFA(nfaStates);
        State.display(dfaStates);
        DotOutput.toDot(dfaStates, "dfa.dot");

        System.out.println("-------------------");
    }
}
