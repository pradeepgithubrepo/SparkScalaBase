package org.apache.java.algo.sort;

//O(n^2) time even if the array is sorted. I
class bubble {

    public int[] processing(int[] unsortarray) {
        int array_len = unsortarray.length;
        for (int i = 0; i < array_len; i++) {
            for (int j = 0; j < array_len-i-1 ; j++) {
                if (unsortarray[i] < unsortarray[j+1]) {
                    int temp = unsortarray[i];
                    unsortarray[i] = unsortarray[j];
                    unsortarray[j] = temp;
                }
            }
        }
        return unsortarray;
    }

}

class bubbleApp {
    public static void main(String[] args) {
        int unsortarray[] = {64, 34, 25, 12, 22, 11, 90};
        bubble obj = new bubble();
        int sortedarray[] = obj.processing(unsortarray);

        for (int i = 0; i < sortedarray.length; i++) {
            System.out.println(sortedarray[i] + ",");
        }
    }
}

