package com.company;

import java.util.Arrays;

public class BuildHeapFromArray {
    public static void heapify(int[] arr,int n,int i){
        int largestindex = i;
        int left = 2*i;
        int right = 2*i +1;

        if(left <=n && arr[left]>=arr[largestindex]){
            largestindex = left;
        }
        if(right <=n && arr[right]>=arr[largestindex]){
            largestindex = right;
        }

        if(largestindex !=i){
            swap(arr,largestindex,i);
            heapify(arr,n,largestindex);
        }
    }

    public static void  swap(int[] arr ,int a,int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void buildHeap(int[]arr ,int size){
        //logic for buildHeap
        int n=size-1;  // size -1 because we have done zero based indexing
        for (int i = n/2; i >=1 ; i--) {
            heapify(arr,n,i);
        }
    }

    public static  void main(String[] args) {
        int arr[] = {-1,2,6,8,3,7};

        buildHeap(arr,arr.length);

        System.out.println(Arrays.toString(arr));
    }
}
