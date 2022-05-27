package SortingUsingRecursion;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {-1,88,-6,-22,89,56,23,9};
        insertionSort(arr,0);
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr, int index) {

        //base case
        if (index == arr.length-1)
            return;

        for (int i = index + 1; i > 0; i--) {
            if (arr[i] < arr[i - 1]) {
                int temp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = temp;
            } else {
                break;
            }
        }

        insertionSort(arr,index+1);

    }
}
