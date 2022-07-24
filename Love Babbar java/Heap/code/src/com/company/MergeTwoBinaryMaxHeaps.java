package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeTwoBinaryMaxHeaps {

//    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
//        // your code here
//
//        int[] arr = new int[n+m];
//        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
//
//        for(int i=0;i<n;i++){
//            maxHeap.add(a[i]);
//        }
//
//
//        for(int i=0;i<m;i++){
//            maxHeap.add(b[i]);
//        }
//
//        for(int i=0;i<m+n;i++){
//            arr[i] = maxHeap.remove();
//        }
//
//        return arr;
//    }



    public static int[] mergeHeaps(int[] a, int[] b, int n, int m) {
        // your code here

        int[] arr = new int[n+m];
        int k=0;
        for(int i=0;i<n;i++){

            arr[k++] = a[i];
        }

        for(int i=0;i<m;i++){

            arr[k++] = b[i];
        }
        System.out.println(Arrays.toString(arr));

        int size = n+m;

        for(int i = (size/2)-1 ;i>=0;i--){
            heapify(arr,size,i);
        }

        return arr;
    }

    public static void heapify(int[] arr,int n,int i){
        int largestIndex = i;
        int left =2*i+1;
        int right =2*i+2;

        if(left<n && arr[left]> arr[largestIndex]){
            largestIndex = left;
        }

        if(right<n && arr[right]> arr[largestIndex]){
            largestIndex = right;
        }

        if(largestIndex !=i) {
            int temp = arr[i];
            arr[i] = arr[largestIndex];
            arr[largestIndex] = temp;
            heapify(arr, n, largestIndex);
        }
    }
    public static void main(String[] args) {
        int n = 4, m = 3;
        int[] a = {10, 5, 6, 2};
        int[]b = {12, 7, 9};

        System.out.println(Arrays.toString(mergeHeaps(a,b,n,m)));


    }



}
