package org.apache.java.algo.sort;

public class quicksort {

    //    5, 6,8,3, 1,4
    public void partition(int arr[], int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        if (arr[i] < pivot) {
            i++;
        }
        while (arr[i] < pivot) {
            i++;
        }
        while (arr[j] > pivot) {
            j--;
        }

        if(i < j ){

        }

    }
}
