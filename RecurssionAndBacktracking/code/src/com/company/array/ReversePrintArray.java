package com.company.array;

public class ReversePrintArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,34};
        printArray(arr, arr.length-1);
    }

    public static void printArray(int[] arr,int index){

        if(index < 0){
            return ;
        }

        System.out.print(arr[index]+" ");

        printArray(arr,index-1);
    }
}
