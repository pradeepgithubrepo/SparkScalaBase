package org.apache.java.mastering.ds;

import java.util.*;

public class onearray {
 static int[] marr = {6,5,4,3,2,1};
 public static void arrayreverse(int[] arr){
     System.out.println(Arrays.toString(arr));
     int j = arr.length -1;
     for(int i =0;i<arr.length/2;i++){
         int temp = arr[j];
         arr[j] = arr[i];
         arr[i] = temp;
         j--;
     }
     System.out.println(Arrays.toString(arr));
 }

 public static boolean palindrome(String ana){
     int j = ana.length()-1;

     for(int i = 0 ; i < ana.length()/2;i++){
         if(ana.charAt(i) != ana.charAt(j)){
           return false;
         }
         j--;
     }
     return true;
 }

 public static boolean anagram(String x ,String y ){
     if(x.length() != y.length()){
         return false;
     }
     HashMap<Character,Boolean> ham = new HashMap<>();
     for(int i=0;i<x.length();i++){
         ham.put(x.charAt(i),true);
     }

     for(int j=0;j<y.length();j++){
       if(!ham.containsKey(y.charAt(j))){
           return false;
       }{
           ham.remove(y.charAt(j));
         }
     }
     return true;
 }

 static boolean isduplicate(String x){
  HashMap<Character, Boolean> ham = new HashMap<>();
  for(int i =0 ; i < x.length() ; i++){
     if(ham.containsKey(x.charAt(i))){
         return true;
     }else
     {
         ham.put(x.charAt(i),true);
     }
  }
  return false;
 }

    public static void main(String[] args) {
//        Array reverse
//        arrayreverse(marr);
//        System.out.println(palindrome("restful"));
//        System.out.println(anagram("restlfu","fulrest"));
        System.out.println(isduplicate("monkey"));
        int[] a = new int[4];
        a[0] = 1;
        int[] b = new int[]{1,2,3,4};
        int[][] c = {{1,2},{3,4},{4,5}};
        System.out.println(Arrays.deepToString(c));

        for(int i=0;i<4;i++){
            a[i]=i;
        }

//        Finding the Value in an array is O(n) hence we can use hash table which is O(1)
        HashMap<Integer, Boolean> amp= new HashMap<>();
        for(int ele : a){
            amp.put(ele,true);
        }

        System.out.println("Finding an element");
        System.out.println(amp.get(3));

//        Arraylist
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(3);
        arr.add(1);
        arr.add(2);
        arr.sort(Integer::compareTo);
        for(Integer ele : arr){
            System.out.println(ele);
        }

        ArrayList<String> alist = new ArrayList<>();
        String[] ab = {"helo","world"};
        Collections.addAll(alist,ab);

        int[] xarray = {5,2,9,0};


    }
}
