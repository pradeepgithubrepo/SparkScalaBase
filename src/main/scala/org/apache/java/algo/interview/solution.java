package org.apache.java.algo.interview;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Solution {

    // Complete the compareTriplets function below.
    public List<Integer> compareTriplets(List<Integer> a, List<Integer> b) {
        int acounter = 0;
        int bcounter = 0;
        int k = 0;
        while (k < a.size() && k < b.size()) {
            if (a.get(k) > b.get(k)) {
                acounter++;
            } else if (a.get(k) < b.get(k)) {
                bcounter++;
            }
            k++;
        }
        System.out.println("acounter" + acounter);
        System.out.println("bcounter" + bcounter);
        List<Integer> result = Arrays.asList(acounter, bcounter);
        return result;

    }

    static long aVeryBigSum(long[] ar) {
        int k = 0;
        long acc = 0;
        while (k < ar.length) {
            acc = acc + ar[k];
            k++;
        }
        return acc;
    }

    public int diagonalDifference(List<List<Integer>> arr) {
        // Write your code here
        int lftdiag = 0;
        int rightdiag = 0;
        int leftdiagcouner =0;
        int rightdiagcouner=arr.size()-1;

        System.out.println(arr.size());
        for (List<Integer> alist : arr) {
            lftdiag = lftdiag + alist.get(leftdiagcouner);
            rightdiag = rightdiag + alist.get(rightdiagcouner);
            leftdiagcouner++;
            rightdiagcouner--;
        }

        return Math.subtractExact(lftdiag,rightdiag);
    }


    public static void main(String[] args) throws IOException {
        Solution obj = new Solution();
//        List<Integer> alist = Arrays.asList(17, 28, 30);
//        List<Integer> blist = Arrays.asList(99, 16, 8);
//        obj.compareTriplets(alist, blist);

        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        listOfLists.add(Arrays.asList(11, 2, 4));
        listOfLists.add(Arrays.asList(4, 5, 6));
        listOfLists.add(Arrays.asList(10, 8, -12));

        obj.diagonalDifference(listOfLists);
    }
}

