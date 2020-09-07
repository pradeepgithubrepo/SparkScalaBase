package org.apache.java.algo.stack;

public class stack {
    private Integer maxSize;
    private long stackArray[];
    private int top;

    public stack(int size) {
        this.maxSize = size;
        this.stackArray = new long[this.maxSize];
        this.top = -1;
    }

    public void push(long avalue) {

        if (top == maxSize - 1) {
            System.out.println("Max size reached can't add elements");
        } else {
            top++;
            stackArray[top] = avalue;
        }
    }

    public long pop() {
        if (!isStackEmpty()) {
            int oldvalue = top;
            top--;
            return stackArray[oldvalue];
        }
        else
        {
            System.out.println("This is already empty");
            return  -1;
        }
    }

    public int currenttopvalue() {
        return top;
    }

    public boolean isStackEmpty() {
        return (top == -1);
    }

    public long currentStack() {
        return stackArray[top];
    }
}
