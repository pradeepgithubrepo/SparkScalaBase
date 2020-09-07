package org.apache.java.algo.declartion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class decs {
    public static void main(String[] args) {
//        Array
        int[] aarray = new int[5];
        int[] barray = new int[]{1,2,3};

//        List Declaration
        List alist = new LinkedList();
        alist.add(1);
        List<Integer> blist = Arrays.asList(1,2,3);

//        2D List
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(Arrays.asList(11,2,4));
        listOfLists.add(Arrays.asList(4,5,6));
        listOfLists.add(Arrays.asList(10,8,-12));
    }
}
