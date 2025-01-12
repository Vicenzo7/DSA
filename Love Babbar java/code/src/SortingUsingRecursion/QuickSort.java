package SortingUsingRecursion;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = {3, 1, 4, 5, 2};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int start, int end) {
        //base case
        if (start >= end) return;

        int p = partition(arr, start, end);

        //recursive call

        //sort left part;
        quickSort(arr, start, p - 1);

        //sort right part;
        quickSort(arr, p + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {

        int pivot = arr[start];
        int count = 0;
        for (int i = start + 1; i <= end; i++) {
            if (arr[i] <= pivot) count++;
        }
        //place pivot at right index
        int pivotIndex = start + count;
        int temp = arr[pivotIndex];
        arr[pivotIndex] = arr[start];
        arr[start] = temp;

        int i = start;
        int j = end;

        // placing elements less than pivot on left &and greater than pivot on your right
        while (i < pivotIndex && j > pivotIndex) {
            while (arr[i] <= pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }

            if (i < pivotIndex && j > pivotIndex) {
                int temp1 = arr[i];
                arr[i] = arr[j];
                arr[j] = temp1;
                i++;
                j--;
            }

        }

        return pivotIndex;
    }
}
