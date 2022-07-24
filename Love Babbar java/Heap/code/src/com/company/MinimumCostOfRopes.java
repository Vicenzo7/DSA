package com.company;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
    //Function to return the minimum cost of connecting the ropes.
    static long minCost(long[] arr, int n)
    {
        long cost = 0;
        PriorityQueue<Long> minHeap = new  PriorityQueue<>();

        //convert into a minHeap
        for(int i=0;i<n;i++){
            minHeap.add(arr[i]);
        }

        //add two min element and add it to cost and add back to heap
        // summation of those min element
        while(minHeap.size() !=1){
            long a = minHeap.remove();
            long b = minHeap.remove();

            cost += a+b;

            minHeap.add(a+b);
        }

        return cost;
    }

    public static void main(String[] args) {
        int n = 5;
        long[] arr = {4, 2, 7, 6, 9};

        System.out.println(minCost(arr,n));
    }
}
