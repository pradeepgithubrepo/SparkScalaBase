package org.apache.java.algo.basics;

public class earth {
    public static void main(String[] args) {
//        This is just a variable
        human tom;
//        The actual invocation happens only when constructor is invoked.
        tom = new human("pradeep",31,70);
        tom.speak();

        human joe = new human("Rahul",34,78);
        joe.speak();
//

    }
}
