package org.apache.java.algo.basics;

//Here we expose only the methods outside and hide out the implementation part
//Considering this we will use the same logic when invoking a list or a linked list . First create a object to those objects.
//Once object is created post that we can easily access the public apis to acomplish the functions.

public class counter {
    private int count ;
    public counter(int a){
        this.count = a;
    }

    public void incrementCounter(){
        this.count = this.count + 1;
    }

    public int getCountervalue(){
        return  this.count;
    }

    public String getCounterasstring(){
        return String.valueOf(this.count);
    }

    public static void main(String[] args) {
        counter obj = new counter(0);
        obj.incrementCounter();
        System.out.println(obj.getCountervalue());
        System.out.println(obj.getCounterasstring());
    }
}
