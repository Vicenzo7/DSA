package com.company.array;

public class MaxInArray {
    public static void main(String[] args) {
        int[] arr = {1, 3, 64, 7, 9, 34};

        System.out.println(maxElement(arr,0));
    }

    public static int maxElement(int[] arr, int index) {

        if (index == arr.length) {
            return Integer.MIN_VALUE;
        }

        int maxi = arr[index];
        int ans = maxElement(arr, index + 1);

        return Math.max(maxi,ans);


    }
}
