package com.company.array;

public class PrintArray {
    public static void main(String[] args) {
        int[] arr = {1,3,5,7,9,34};
        printArray(arr, 0);
        System.out.println();
        reversePrintArray(arr,0);
    }

    public static void printArray(int[] arr,int index){

        if(index == arr.length){
            return ;
        }
        System.out.print(arr[index]+" ");
        printArray(arr,index+1);
    }


    public static void reversePrintArray(int[] arr,int index){

        if(index == arr.length){
            return ;
        }

        printArray(arr,index+1);

        System.out.print(arr[index]+" ");
    }
}
