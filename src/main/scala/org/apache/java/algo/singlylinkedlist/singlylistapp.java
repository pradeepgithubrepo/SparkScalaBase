package org.apache.java.algo.singlylinkedlist;

public class singlylistapp {
    public static void main(String[] args) {
        singlylkdlist obj = new singlylkdlist();
        obj = obj.insertNode(obj,5);
        obj = obj.insertNode(obj,15);
        obj = obj.insertNode(obj,25);

        obj.displayNode(obj);

        obj = obj.deleteNode(obj,15);
        obj.displayNode(obj);
    }
}
