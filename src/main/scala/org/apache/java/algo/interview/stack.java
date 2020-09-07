package org.apache.java.algo.interview;
//LIFO
public class stack {
    int counter = 0;
    int[] arr;

    public stack(int size) {
        arr = new int[size];
    }

    public void push(int key) {
        arr[counter] = key;
        counter++;
        System.out.println("Push Counter" + counter);
    }

    public void pop() {
        counter--;
        System.out.println("POP Counter" + counter);
    }

    public void display() {
        int k = 0;
        while (k < counter) {
            System.out.println("Ele" + arr[k]);
            k++;
        }
    }

    public void remove_random(int key){

    }

    public static void main(String[] args) {
        stack obj = new stack(5);
        obj.push(5);
        obj.push(15);
        obj.push(25);
        obj.display();
        obj.pop();
        obj.display();


    }
}
