package org.apache.java.algo.interview;

public class queue {
    int front =0;
    int back =0;
    int[] arr;
    public queue(int size){
        arr = new int[size];
    }

    public void push(int key){
        arr[front]=key;
        front++;
    }
    public void pop(){
        back++;
    }
    public void queudisplya(){
        for(int i = back;i<front;i++){
            System.out.println(arr[i]);
        }
    }

    public static void main(String[] args) {
        queue obj = new queue(5);
        obj.push(5);
        obj.push(15);
        obj.push(25);
        obj.pop();
        obj.queudisplya();
    }
}
