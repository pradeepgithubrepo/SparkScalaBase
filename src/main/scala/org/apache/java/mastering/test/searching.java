package org.apache.java.mastering.test;

// 1,2,3,4,5,6,7,8
//key = 7
class unsortedsearch{

public  int ussearch(int[] a ,int lw , int hi , int key){
    while (lw <=hi){
        if(a[lw] == key || a[hi] == key){
           return  (a[lw] == key)?lw : hi;
        }else
        {
            lw++;
            hi--;
        }
    }
    return  -1;
}
}

public class searching {
    public static void main(String args[]){
        int[] a = {1,2,13,4,65,6,87,8};
        unsortedsearch obj = new unsortedsearch();
        System.out.println(obj.ussearch(a,0,a.length-1,87));

    }
}
