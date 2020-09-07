package org.apache.java.algo.queque;
//FIFO
public class que {
    private int maxsize;
    private long[] queue;
    private int front;
    private int rear;
    private int nitems; //Total items in the queuqe

    public que(int size) {
        this.maxsize = size;
        this.queue = new long[this.maxsize];
        this.front = 0;
        this.rear = -1;
        this.nitems = 0;
    }

    public void insert(long avalue){
        rear ++;
        queue[rear] = avalue;
        nitems++;
    }

    public void remove(){
     front ++;
     nitems--;
    }

    public void view(){
        for(int i = front ; i<= rear ; i++){
            System.out.println("queue value "+ queue[i]);
        }
    }
}
