package org.apache.java;

import java.util.LinkedList;
import java.util.List;

class home{
 int a ;
 String x;

 home(int a , String x ){
     this.a = a;
     this.x = x;
 }

 @Override
    public String toString(){
     return this.a + " " + this.x;
 }

}
public class learning {
    public static void main(String args[]) {
        List<String> alist = new LinkedList<String>();
        alist.add("hello");
        System.out.println(String.join(",",alist));

    home h1 = new home(1,"hello");
    home h2 = new home(2,"world");
    System.out.println(h1);
    System.out.println(h2);
    }
}
