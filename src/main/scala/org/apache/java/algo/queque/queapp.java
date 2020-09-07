package org.apache.java.algo.queque;

public class queapp {
    public static void main(String[] args) {
        que queobj = new que(5);
        queobj.insert(5);
        queobj.insert(15);
        queobj.insert(25);
        queobj.remove();
        queobj.view();
    }
}
