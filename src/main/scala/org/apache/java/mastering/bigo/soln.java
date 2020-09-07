package org.apache.java.mastering.bigo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class soln {
    //    Approaching a problem
    static char[] aaray = new char[]{'a', 'b', 'c'};
    static char[] baray = new char[]{'x', 'y', 'a'};

    public static boolean pbm1(char[] ar, char[] br) {
//        This is o(n^2) whih is a expensive operation
        for (int i = 0; i < ar.length; i++) {
            for (int j = 0; j < br.length; j++) {
                if (ar[i] == br[j]) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean optzpbm1(char[] ar, char[] br) {
        HashMap<Character, Boolean> hm = new HashMap<Character, Boolean>();
        for (char ele : ar) {
            hm.put(ele, true);
        }

        for (char ele : br) {
            if (hm.containsKey(ele) == true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
//     System.out.println(pbm1(aaray,baray));
        System.out.println(optzpbm1(aaray, baray));
        ArrayList abc = new ArrayList<Character>();
        abc.addAll(Collections.singleton(aaray));
        ArrayList xyz = new ArrayList<Character>();
        xyz.addAll(Collections.singleton(baray));


    }


}
