package org.apache.java.algo.stack;

public class stackapp {
    public static void main(String[] args) {
        stack stackobj = new stack(3);
        stackobj.push(5);
        stackobj.push(10);
        stackobj.push(15);
        stackobj.push(20);

        while (!stackobj.isStackEmpty()) {
         System.out.println(stackobj.currentStack());
         stackobj.pop();
        }

        stackobj.pop();


//        Reverse a string
        String hello = "Hello";
        stackrev stackrevobj = new stackrev(hello.length());

        for ( int i = 0 ; i< hello.length() ; i++){
            stackrevobj.push(hello.charAt(i));
        }

        while (!stackrevobj.isStackEmpty()) {
            System.out.println(stackrevobj.currentStack());
            stackrevobj.pop();
        }
    }
}
