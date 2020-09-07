package org.apache.java.algo.interview;

import org.apache.java.algo.singlylinkedlist.singlylkdlist;

class MyLinkedList {
    node head = null;

    class node {
        int adata;
        node next;

        public node(int valu) {
            adata = valu;
            next = null;
        }
    }

    public MyLinkedList insertNode(MyLinkedList alist, int key) {
        node newnode = new node(key);
        if (alist.head == null) {
            alist.head = newnode;
        } else {
            node currentnode = alist.head;
            while (currentnode.next != null) {
                currentnode = currentnode.next;
            }
            currentnode.next = newnode;
        }
        return alist;
    }

    public MyLinkedList deleteNode(MyLinkedList alist, int key) {
        node temp = alist.head;
        node prev = null;
        while (temp.next != null && temp.adata != key) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        return alist;
    }

    public void reverse_display(node n){
        if(n == null) {
            return;
        }else
        {
            reverse_display(n.next);
        }
        System.out.println("REverse Print"+n.adata);
    }
    public static void main(String[] args) {
        MyLinkedList alist = new MyLinkedList();
        alist = alist.insertNode(alist, 5);
        alist = alist.insertNode(alist, 15);
        alist = alist.insertNode(alist, 25);
        alist = alist.insertNode(alist, 35);
        alist = alist.deleteNode(alist, 35);

        node currentnode = alist.head;
        while (currentnode != null) {
            System.out.println(currentnode.adata);
            currentnode = currentnode.next;
        }
        System.out.println("Printining in reverse");
        alist.reverse_display(alist.head);

    }
}


/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */