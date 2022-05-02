package com.company;

import java.util.Arrays;

public class Swap {
    public static void main(String[] args) {
        int[] arr= {1, 2, 3, 4, 99};
        System.out.println(Arrays.toString(arr));
//        swap(arr, 0, 4);
//        System.out.println(Arrays.toString(arr));
//        reverse(arr,0,arr.length-1);
        reverse2(arr);
        System.out.println(Arrays.toString(arr));
    }

    static  void reverse(int[] arr, int start,int end){
        for (int i = 0; i < arr.length/2; i++) {
            swap(arr, start, end);
            start++;
            end--;

        }
    }
    static void swap(int[] arr, int index1, int index2) {
        int temp =arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;

    }

    static void reverse2(int[] arr){
        int start =0;
        int end = arr.length-1;
        while(start < end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }
}
