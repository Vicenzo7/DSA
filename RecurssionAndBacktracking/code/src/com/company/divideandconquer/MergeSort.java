package com.company.divideandconquer;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 5, 9, 6};
        System.out.println("Array before sorting:\n" + Arrays.toString(arr));
        mergeSort(arr, 0, arr.length - 1);
        System.out.println("Array after sorting:\n" + Arrays.toString(arr));

    }

    private static void mergeSort(int[] arr, int start, int end) {

        if (start >= end)
            return;

        int mid = start + (end - start) / 2;
        // merge sort left
        mergeSort(arr, start, mid);

        // merger sort right
        mergeSort(arr, mid + 1, end);

        // merge
        merge(arr, start, end);

    }

    private static void merge(int[] arr, int start, int end) {

        int mid = start + (end - start) / 2;

        int len1 = mid-start+1;
        int len2 = end -mid;

        int[] first = Arrays.copyOfRange(arr,start,mid+1);
        int[] second = Arrays.copyOfRange(arr,mid+1,end+1);

        int startIndex = start;
        int index1 =0;
        int index2 =0;

        while(index1<len1 && index2 < len2){
            if(first[index1] < second[index2]){
                arr[startIndex++]=first[index1++];
            }else{
                arr[startIndex++]=second[index2++];
            }
        }


        while(index1<len1){
            arr[startIndex++]=first[index1++];
        }

        while(index2<len2){
            arr[startIndex++]=second[index2++];
        }

    }
}
