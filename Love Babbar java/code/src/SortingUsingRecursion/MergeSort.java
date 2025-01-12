package SortingUsingRecursion;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 7, 0, 5, 1, 45, 8, 6, 9, 1, 2, 12, 1, 2, 12, 12, 46, 13, 88, 96, 24};

        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergeSort(int[] arr, int start, int end) {

        //base case
        if (start >= end) return;

        int mid = start + (end - start) / 2;

        //sort left part
        mergeSort(arr, start, mid);

        //sort right part
        mergeSort(arr, mid + 1, end);

        //merge
        merge(arr, start, end);
    }

    private static void merge(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;

        int len1 = mid - start + 1;
        int len2 = end - mid;
        //creating two arrays
        int[] first = Arrays.copyOfRange(arr, start, mid + 1);
        int[] second = Arrays.copyOfRange(arr, mid + 1, end + 1);

        //copying values
        int mainArrayIndex = start;
        for (int i = 0; i < len1; i++) {
            first[i] = arr[mainArrayIndex++];
        }

        mainArrayIndex = mid + 1;
        for (int i = 0; i < len2; i++) {
            second[i] = arr[mainArrayIndex++];
        }

        //merger two sorted Arrays
        int index1 = 0;
        int index2 = 0;
        mainArrayIndex = start;
        while (index1 < len1 && index2 < len2) {
            if (first[index1] < second[index2]) {
                arr[mainArrayIndex++] = first[index1++];
            } else {
                arr[mainArrayIndex++] = second[index2++];
            }
        }

        while (index1 < len1) {
            arr[mainArrayIndex++] = first[index1++];
        }
        while (index2 < len2) {
            arr[mainArrayIndex++] = second[index2++];
        }

    }
}
