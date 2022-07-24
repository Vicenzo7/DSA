package com.company;

import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElementInArray {

    static int getKthLargestElement(int[] arr,int n,int k){
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        //process first k element
        for (int i = 0; i <k ; i++) {
            minHeap.add(arr[i]);
        }

        for (int i = k; i <n ; i++) {
            if(arr[i]> minHeap.peek()){
                minHeap.remove();
                minHeap.add(arr[i]);
            }
        }
        return minHeap.peek();

    }
    public static void main(String[] args) {
        int[] arr = {3,2,5,1,6,7,8,9};
        int k =3;
        System.out.println(getKthLargestElement(arr, arr.length, k));
    }
}
