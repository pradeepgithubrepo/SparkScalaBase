package org.apache.java.mastering.ds;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class twolinkedlist {
    public node headnode = null;

    class node {
        int data;
        node nextnode;

        public node(int key) {
            this.data = key;
            this.nextnode = null;
        }
    }

    public twolinkedlist insert(twolinkedlist alist, int key) {
        node newnode = new node(key);
        if (alist.headnode == null) {
            alist.headnode = newnode;
        } else {
            node currentnode = alist.headnode;
            while (currentnode.nextnode != null) {
                currentnode = currentnode.nextnode;
            }
            currentnode.nextnode = newnode;
        }
        return alist;
    }

    public twolinkedlist remove(twolinkedlist alist, int key) {
        node currentnode = alist.headnode;
        node prev = null;
        while (currentnode != null && currentnode.data != key) {
            prev = currentnode;
            currentnode = currentnode.nextnode;
        }
        prev.nextnode = currentnode.nextnode;
        return alist;
    }

    public void displaydata(twolinkedlist alist) {
        node currentnode = alist.headnode;
        while (currentnode != null) {
            System.out.println("Node Info " + currentnode.data);
            currentnode = currentnode.nextnode;
        }
    }

    public static int middlenode(twolinkedlist alist){
        node currentnode = alist.headnode;
        node fastnode = alist.headnode;

        while (fastnode.nextnode != null && fastnode.nextnode.nextnode !=null){
            currentnode = currentnode.nextnode;
            fastnode = fastnode.nextnode.nextnode;
        }
        return currentnode.data;
    }

    public static void main(String[] args) {
//        Using list from java.util
//        List<Integer> blist = new LinkedList<>();
//        blist.add(3);
//        blist.add(4);
//        blist.add(2);
//        blist.sort(Integer::compareTo);
//        blist.size();
//        System.out.println(Arrays.toString(blist.toArray()));


        twolinkedlist alist = new twolinkedlist();
        alist = alist.insert(alist, 5);
        alist = alist.insert(alist, 15);
        alist = alist.insert(alist, 25);
        alist = alist.insert(alist, 35);
        alist = alist.insert(alist, 45);
        alist = alist.insert(alist, 55);
        alist = alist.insert(alist, 65);
        alist.displaydata(alist);
        System.out.println(middlenode(alist));
//        alist.remove(alist,25);
//        alist.displaydata(alist);

    }
}
