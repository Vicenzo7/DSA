package com.company;

import java.util.Arrays;

public class Heap_Sort {
    //Function to build a Heap from array.
    public static void buildHeap(int arr[], int n)
    {

        for(int i=(n/2)-1;i>=0;i--){
            heapify(arr,n,i);
        }
    }

    //Heapify function to maintain heap property.
    public static void heapify(int arr[], int n, int i)
    {
        int largestIndex = i;
        int left = 2*i+1;
        int right = 2*i+2;

        if(left<n && arr[left]>=arr[largestIndex]){
            largestIndex=left;
        }
        if(right< n && arr[right]>=arr[largestIndex]){
            largestIndex=right;
        }


        if(largestIndex != i){
            int temp = arr[largestIndex];
            arr[largestIndex]= arr[i];
            arr[i] = temp;
            heapify(arr,n,largestIndex);
        }
    }

    //Function to sort an array using Heap Sort.
    public static void heapSort(int arr[], int n)
    {

        buildHeap(arr,n);
        int size =n-1;
        for(int i=size;i>0;i--){
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;


            heapify(arr,i,0);
        }
    }




    public static  void main(String[] args) {
        int arr[] = {10,9,8,7,6,5,4,3,2,1};

        heapSort(arr, arr.length);
        System.out.println(Arrays.toString(arr));


    }
}
