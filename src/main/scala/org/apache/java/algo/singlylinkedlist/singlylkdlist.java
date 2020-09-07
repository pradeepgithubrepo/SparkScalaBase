package org.apache.java.algo.singlylinkedlist;

import org.w3c.dom.Node;

public class singlylkdlist{
   Node head = null;

    class Node{
        int adata;
        Node nextnode;
        Node(int avalue){
            adata = avalue;
            nextnode = null;
        }
    }

    public singlylkdlist insertNode(singlylkdlist list,int adata){
        Node newNode = new Node(adata);

        if(list.head == null){
            list.head =newNode;
        }else
        {
            Node currentNode = list.head;
            while(currentNode.nextnode != null)
            {
                currentNode = currentNode.nextnode;
            }
            currentNode.nextnode = newNode;
        }

        return list;

    }

    public singlylkdlist deleteNode(singlylkdlist list,int key){
        Node currentNode = list.head;
        Node prev_Node= null;
        while (currentNode.nextnode != null){
            if(currentNode.adata == key){
                prev_Node = currentNode;
            }
            currentNode = currentNode.nextnode;
            prev_Node = currentNode.nextnode;
            System.out.println("in loop"+currentNode.adata);
        }

        return list;
    }

    public void displayNode(singlylkdlist list){
        Node iterativenode = list.head;
        while(iterativenode.nextnode != null){
            System.out.println("Next Node "+iterativenode.adata);
            iterativenode = iterativenode.nextnode;
        }
        System.out.println("Next Node "+iterativenode.adata);
    }


}
