package com.company;

import java.util.Arrays;

public class Max {
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 99,53,133,12,45,67,9,90000};
        System.out.println(Arrays.toString(arr));
        System.out.println(maxRange(arr,9,4));
    }

    static int maximum(int[] arr) {
        if(arr.length == 0 ){
            return -1;
        }
        int max =arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(max<arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }

    // finding max in a range
    // work on edge cases here, like array being null
    static int maxRange(int[] arr, int start, int end) {

        if(end < start){
            return -1;
        }

        if(arr == null)
        {
            return -1;
        }

        int max =arr[start];
        for (int i = start; i <=end  ; i++) {
            if(max<arr[i]) {
                max = arr[i];
            }
        }
        return max;
    }
}
