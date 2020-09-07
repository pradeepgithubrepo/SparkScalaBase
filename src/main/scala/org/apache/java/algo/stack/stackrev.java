package org.apache.java.algo.stack;

public class stackrev {
    private Integer maxSize;
    private char stackArray[];
    private int top;

    public stackrev(int size) {
        this.maxSize = size;
        this.stackArray = new char[this.maxSize];
        this.top = -1;
    }

    public void push(char avalue) {

        if (top == maxSize - 1) {
            System.out.println("Max size reached can't add elements");
        } else {
            top++;
            stackArray[top] = avalue;
        }
    }

    public char pop() {
        if (!isStackEmpty()) {
            int oldvalue = top;
            top--;
            return stackArray[oldvalue];
        }
        else
        {
            System.out.println("This is already empty");
            return  '0';
        }
    }

    public int currenttopvalue() {
        return top;
    }

    public boolean isStackEmpty() {
        return (top == -1);
    }

    public char currentStack() {
        return stackArray[top];
    }
}
