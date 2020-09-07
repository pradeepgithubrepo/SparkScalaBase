package org.apache.java.algo.interview;

import java.util.Arrays;

public class recursion {
    public void reverseString(char[] s) {
        int len = s.length - 1;
        for (int i = 0; i < s.length / 2; i++) {
            char temp = s[i];
            s[i] = s[len - i];
            s[len - i] = temp;
        }
        System.out.println(Arrays.toString(s));
    }

    //    3+sum(2)
//    3+2+sum(1)
//    3+2+1+Sum(0)
    public int reducebyone(int a) {
        if (a >= 0) {
            return a + reducebyone(a - 1);
        } else {
            return 0;
        }
    }

    public int fact(int a) {
        if (a > 1) {
            return a * fact(a - 1);
        } else {
            return 1;
        }

    }

    public boolean palindrome(String anum) {
        char[] achar = new char[anum.length()];
        int k = 0;
        while (k < anum.length()) {
            achar[k] = anum.charAt(k);
            k++;
        }
        return false;
    }

    public static void tower(int n, char sourcePole,
                      char destinationPole, char auxiliaryPole)
    {
        // Base case (termination condition)
        if (0 == n)
            return;

        // Move first n-1 disks from source pole
        // to auxiliary pole using destination as
        // temporary pole
        tower(n - 1, sourcePole, auxiliaryPole,
                destinationPole);

        // Move the remaining disk from source
        // pole to destination pole
        System.out.printf("Move the disk %d from %c to %c\n",
                n, sourcePole, destinationPole);

        // Move the n-1 disks from auxiliary (now source)
        // pole to destination pole using source pole as
        // temporary (auxiliary) pole
        tower(n - 1, auxiliaryPole, destinationPole, sourcePole);
    }

    public static void main(String[] args) {

        tower(3, 'S', 'D', 'A');

        recursion obj = new recursion();
//        System.out.println("Palindrom" + obj.palindrome(String.valueOf(2002)));

//        System.out.println(obj.fact(4));
//        System.out.println(obj.reducebyone(3));

//        char[] y = {'h','a','n','n','a','h'};
//        obj.reverseString(y);
    }
}
