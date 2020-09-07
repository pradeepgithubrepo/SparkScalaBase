package org.apache.java.algo.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class sequence {
    public void processdata() {
        List<Integer> alist = Arrays.asList(1, 2, 3, 5, 6, 7, 8, 10, 11);
        List<Integer> resultlist = new ArrayList<Integer>();
        List<Integer> currentList = new ArrayList<Integer>();
        int counter = 0;
        int resultcounter = 0;

        resultlist.add(resultlist.get(1));
        currentList.add(resultlist.get(1));
        
        for (int i = 1; i < alist.size(); i++) {
            if( resultlist.get(i) == resultlist.get(i-1)-1){
                resultlist.add(resultlist.get(i));
                currentList.add(resultlist.get(i));
                resultcounter++;
                counter++;
            }else
            {
                currentList.add(resultlist.get(i));

            }

        }
    }

    public static void main(String[] args) {
        sequence obj = new sequence();
        obj.processdata();
    }
}
