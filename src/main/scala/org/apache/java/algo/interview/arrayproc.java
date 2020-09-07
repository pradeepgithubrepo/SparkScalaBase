package org.apache.java.algo.interview;

import java.util.*;

public class arrayproc {

    public int findMaxConsecutiveOnes(int[] arr) {
        int counter = 0;
        int maxcounter = 0;
        int i = 0;
        while (i < arr.length) {
            if (arr[i] == 1) {
                counter++;
            } else {
                maxcounter = counter > maxcounter ? counter : maxcounter;
                counter = 0;
            }
            if (i + 1 == arr.length) {
                maxcounter = counter > maxcounter ? counter : maxcounter;
            }
            i++;
        }
        return maxcounter;
    }

    public int findNumbers(int[] nums) {

        int i = 0;
        int counter = 0;
        while (i < nums.length) {
            String adata = String.valueOf(nums[i]);
            if (adata.length() % 2 == 0) counter++;
            i++;
        }
        return counter;
    }

    public Integer[] sortedSquares(int[] A) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        int k = 0;
        System.out.println("Arraylist processing");
        while (k < A.length) {
            arrayList.add(A[k]);
            k++;
        }
        System.out.println("Loading processing");
        ArrayList<Integer> procssedarraylist = new ArrayList<Integer>();
        Collections.sort(arrayList);
        k = 0;
        System.out.println("Sorted processing");
        while (k < arrayList.size()) {
            Integer temp = arrayList.get(k) * arrayList.get(k);
            System.out.println("Temp" + temp);
            procssedarraylist.add(temp);
            k++;
        }
        System.out.println("Crossed processing");
        Integer[] arr = new Integer[procssedarraylist.size()];
        arr = procssedarraylist.toArray(arr);
        return arr;
    }

    public int[] insertArray(int[] ar, int pos, int avalue) {
        int k = 0;
        int[] newarray = new int[ar.length + 1];

        while (k < ar.length) {
            newarray[k] = ar[k];
            k++;
        }
        k = newarray.length - 2;
        System.out.println("Array Lenght" + k);
        while (k >= pos) {
            newarray[k + 1] = newarray[k];
            k--;
        }
        newarray[pos] = avalue;
        return newarray;
    }

    public int[] duplicatezeroes(int[] datax) {
        int k = 0;
        int[] datay = new int[datax.length];
        int i = 0;
        int p = -1;
        while (i < datax.length && p < datay.length - 3) {
            System.out.println("X value " + datax[i]);
            if (datax[i] == 0) {
                p++;
                datay[p] = 0;
                p++;
                datay[p] = 0;
                p++;
                datay[p] = datax[i + 1];
                i++;
            } else {
                p++;
                datay[p] = datax[i];
            }
            i++;
        }

        return datay;
    }

    public int[] mergesort(int[] aarray, int[] barray) {
//2,3,7
//        4,5
        int[] carray = new int[aarray.length + barray.length];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < aarray.length && j < barray.length) {
            if (aarray[i] < barray[j]) {
                carray[k] = aarray[i];
                k++;
                i++;
            } else {
                carray[k] = barray[j];
                k++;
                j++;
            }
        }
        if (i < aarray.length) {
            while (i < aarray.length) {
                carray[k] = aarray[i];
                k++;
                i++;
            }
        }

        System.out.println("J Value" + j);
        System.out.println("K Value" + k);
        if (j < barray.length) {
            while (j < barray.length) {
                carray[k] = barray[j];
                k++;
                j++;
            }
        }

        return carray;
    }

    public int inlineremove(int[] nums, int val) {

        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }

        System.out.println("Ele " + Arrays.toString(nums));
        return i;
    }

    public int duplicate_from_sortedarr(int[] nums) {

        int i = 0;
        int tracker = 0;
        for (int j = 0; j < nums.length; j++) {
            if (tracker != nums[j] || j == 0) {
                tracker = nums[j];
                nums[i] = nums[j];
                i++;
            }
        }
        System.out.println("Ele " + Arrays.toString(nums));
        return i;
    }


    public boolean checkIfExist(int[] arr) {
        int i = 0;
        boolean flag = false;
        while (i < arr.length) {
            int k = 0;
            while (k < arr.length) {
                if (arr[i] * 2 == arr[k] || arr[k] * 2 == arr[i]) {
                    System.out.println("arr[i]" + arr[i]);
                    System.out.println("arr[k]" + arr[k]);
                    flag = true;
                }
                k++;
            }
            i++;
        }
        return flag;
    }

    public boolean validMountainArray(int[] A) {
        int alen = A.length;
        if (alen < 3) {
            return false;
        }
        int median = new Integer(alen / 2);
        System.out.println("median" + median);
        for (int k = 1; k < median; k++) {
            if (A[k - 1] > A[k]) {
                return false;
            }
        }
        for (int k = median + 1; k < A.length; k++) {
            if (A[k - 1] < A[k]) {
                return false;
            }
        }

        return true;
    }


    public int removeDuplicates(int[] nums) {
        int k = 0;
        int i = 0;
        int tracker = 0;
        while (k < nums.length) {
            if (nums[k] != tracker || k == 0) {
                tracker = nums[k];
                nums[i] = nums[k];
                i++;
            }
            k++;
        }
        System.out.println(Arrays.toString(nums));
        return i;
    }


    public void moveZeroes(int[] nums) {
        int i = 0;
        int k = 0;
        while (k < nums.length) {
            if (nums[k] != 0) {
                nums[i++] = nums[k];
            }
            k++;
        }
        while (i < nums.length) {
            nums[i++] = 0;
        }
        System.out.println("Arr" + Arrays.toString(nums));
    }

    public int[] sortArrayByParity(int[] A) {
        int front = 0;
        int back = A.length - 1;
        int[] B = new int[A.length];
        for (int e : A) {
            if (e % 2 == 0) {
                B[front] = e;
                front++;
            } else {
                B[back] = e;
                back--;
            }
        }
        int k = 0;
        while (k < B.length) {
            A[k] = B[k];
            k++;
        }
        System.out.println("SorrtArray" + Arrays.toString(A));
        return A;
    }

    public int[] sortedsqr(int[] A) {
        int k = 0;
        while (k < A.length) {
            A[k] = A[k] * A[k];
            k++;
        }
        Arrays.sort(A);
        System.out.println("Sorted Array" + Arrays.toString(A));
        return A;
    }

    public int[] longseq(int[] A) {
        int k = 0;
        int cur_ind = 0;
        int cur_end = 0;
        int bst_ind = 0;
        int bst_end = 0;
        int cur_tracker = 0;
        int bst_tracker = 0;
        boolean breaker = false;
        while (k < A.length-1) {

            if (A[k] + 1 == A[k + 1]) {
                if (breaker == false) {
                    cur_ind = k;
                    cur_tracker++;
                    breaker = true;
                }
                cur_end = k;
                cur_tracker++;
            } else {
                if (cur_tracker > bst_tracker) {
                    bst_tracker = cur_tracker;
                    bst_ind = cur_ind;
                    bst_end = cur_end;
                    cur_tracker = 0;
                    breaker = false;
                }
            }
            cur_ind = k;
            cur_end = k;
            cur_tracker++;
            k++;
        }
        System.out.println("bst_ind" + bst_ind);
        System.out.println("bst_end" + bst_end);
        return A;
    }

    public  boolean palindrome(String word){
        int k=0;
        char[] wrdset = new char[word.length()];
        int median = word.length() / 2;
        System.out.println("Median"+median);

        while (k<word.length()){
            wrdset[k] = word.charAt(k);
            k++;
        }

        int j = word.length()-1;
        int breaker =0;
        for(int i=0;i<median;i++){
          if(wrdset[i]!=wrdset[j]){
              breaker++;
          }
            j--;
        }

        if (breaker >1){
            return false;
        }else
        {
            return true;
        }

    }

    public int mostpopular(int[] arr,int length){
        Arrays.sort(arr);
        int res=0;
        int tracker =0;
        int best =0;

        int k=0;
        while (k<arr.length-1){
            if(arr[k]==arr[k+1]){
                tracker++;
            }else
            {
                if(tracker>best){
                    res=arr[k];
                    best=tracker;
                }
                tracker=0;

            }
            k++;
        }
        return res;
    }

    public static void main(String[] args) {
        arrayproc obj = new arrayproc();

        int[] dataz = new int[]{22,101,102,101,102,525,88};
        System.out.println("Arraypoc"+obj.mostpopular(dataz,7));
//        String aword = "abccfx";
//        obj.palindrome(aword);
//        int[] datay = new int[]{1, 2, 3, 5, 6, 7, 8, 11, 12, 13};
//        System.out.println(Arrays.toString(obj.longseq(datay)));

//        int[] dataz = new int[]{-7,-3,2,3,11};
//        obj.sortedsqr(dataz);

//        int[] dataa = new int[]{3,1,2,4};
//        obj.sortArrayByParity(dataa);


//        int[] datan = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
//        System.out.println(obj.removeDuplicates(datan));

//        int[] datam = new int[]{0, 3, 2, 1};
//        System.out.println("validMountainArray" + obj.validMountainArray(datam));

//        int[] datap = new int[]{-20, 8, -6, -14, 0, -19, 14, 4};
//        obj.checkIfExist(datap);


//        int[] datay = new int[]{0,0,1,1,1,2,2,3,3,4};
//        System.out.println("Datay"+obj.duplicate_from_sortedarr(datay));

//        int[] datax = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
//        int rem_val = 2;
//        System.out.println(obj.inlineremove(datax, rem_val));


        int[] data = new int[]{-4, -1, 0, 3, 10};
//        Declaring Array
        int[] data1 = new int[9];
        int[] data2 = new int[]{1, 2, 3,};
        ArrayList<Integer> arraylis = new ArrayList<Integer>();
        List alist = new LinkedList();


//    Given a binary array, find the maximum number of consecutive 1s in this array.
//        System.out.println("findMaxConsecutiveOnes :" + obj.findMaxConsecutiveOnes(data));

        //    Squares of sorted array.
//        System.out.println("findMaxConsecutiveOnes :");
//        Integer[] newrestult = obj.sortedSquares(data);
//        int j = 0;
//        while(j<newrestult.length){
//            System.out.println(newrestult[j]);
//        }

//        Inserting Anywhere in the Array
//        int[] datax = new int[]{3,6,7,9};
//        int[] resultarr = obj.insertArray(datax,0,1000);
//        System.out.println(Arrays.toString(resultarr));

//        Duplicate Zeros
//      int[] datay = new int[]{1,2,3};
//      int[] datares = obj.duplicatezeroes(datay);
//      System.out.println("REsult "+Arrays.toString(datares));

//        Merge Sorted Array
//
//        int[] adata =new int[]{1,2,3};
//        int[] bdata =new int[]{2,5,6};
//        System.out.println("Result"+Arrays.toString(obj.mergesort(adata,bdata)));
    }
}
