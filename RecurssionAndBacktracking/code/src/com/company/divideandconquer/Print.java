package com.company.divideandconquer;

public class Print {
    public static void main(String[] args) {
        int[] arr = {3,4,1,5,6,2};
        solve(arr, arr.length);
        solveTwo(arr,0,arr.length-1);
    }

    private static void solveTwo(int[] arr, int start, int end) {
        if(start >= end)
        {
            //System.out.println(arr[start]);
            return;
        }

        for (int i = start; i < end ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        int mid = start + (end - start)/2;

        solveTwo(arr,start,mid);

    }


    public static void solve(int[] arr,int size){
        // base case
        if(size< 1)
            return;

        for (int i = 0; i <size ; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();

        solve(arr,(size)/2);

    }
}
