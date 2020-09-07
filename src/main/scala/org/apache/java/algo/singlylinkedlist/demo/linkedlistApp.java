package org.apache.java.algo.singlylinkedlist.demo;

public class linkedlistApp {
    public static void main(String[] args) {
        node anode = new node();
        anode.adata = 1;

        node bnode = new node();
        bnode.adata = 2;
        anode.nextnode = bnode;

        node cnode = new node();
        cnode.adata = 3;
        bnode.nextnode = cnode;

        node dnode = new node();
        dnode.adata = 4;
        cnode.nextnode = dnode;
        dnode.nextnode = null;

        System.out.println("List Length 1st node"+listlength(anode));
        System.out.println("List Length 3st node"+listlength(cnode));

    }

    public static int listlength(node anode){
        node xnode = anode;
        int listlen = 0;
        while (xnode.nextnode != null){
            listlen ++;
            xnode = xnode.nextnode;
        }
      return listlen;
    }
}

class node {
  int adata;
  node nextnode = null;
}
