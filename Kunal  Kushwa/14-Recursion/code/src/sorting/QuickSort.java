package sorting;

import java.lang.reflect.Array;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[]arr = {40,12,5,49,86,5,1,78,66};
        quickSort(arr,0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }


    public static void quickSort(int[] arr,int low,int hi){

        if(low>=hi)
            return;


        int start = low;
        int end = hi;
        int mid = start + (end-start)/2;
        int pivot = arr[mid];

        while(start<=end){
            while(arr[start] < pivot){
                start++;
            }
            while(arr[end] > pivot){
                end--;
            }

            if(start<=end){
                int temp = arr[start];
                arr[start]=arr[end];
                arr[end] = temp;
                start++;
                end--;
            }
        }

        // now my pivot is at correct index, please sort two halves now
        quickSort(arr, low, end);
        quickSort(arr, start,hi);


    }
}
