// This is supporting software for CS321 Compilers and Language Design I
// Copyright (c) Mark P Jones, Portland State University

package regexp;

/** A quick demo of the classes in this package.
 */
public class Demo {
    public static void main(String[] args) {

        // Build up the basic machine:
        State r  = new State();       // An accept state with no transitions
        r.trans  = new Transition[0]; 
        r.accept = 1;

        State q  = new State();
        q.trans  = new Transition[] { // Transition to r on input 'a'
                     new Transition('a', r)
                   };
   
        State p  = new State();
        p.trans  = new Transition[] { // Epsilon transitions to q and r
                     new Transition(q),
                     new Transition(r)
                   };

        // Find and display the set of all NFA states, starting from p:
        System.out.println("NFA: --------------");
        State[] nfaStates = p.reachableStates();
        State.display(nfaStates);

        // Find and display the corresponding DFA:
        System.out.println("DFA: --------------");
        State[] dfaStates = State.toDFA(nfaStates);
        State.display(dfaStates);

        System.out.println("-------------------");

        DotOutput.toDot(nfaStates, "nfa.dot");
        DotOutput.toDot(dfaStates, "dfa.dot");
    }
}
