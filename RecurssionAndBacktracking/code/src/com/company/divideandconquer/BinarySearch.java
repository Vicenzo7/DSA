package com.company.divideandconquer;

public class BinarySearch {

    public static void main(String[] args) {
        int[] arr = {3,6,9,12,15,17,19};

        int target = 17;
        System.out.println(binarySearch(arr,0, arr.length-1, target));
    }




    public static boolean binarySearch(int[] arr, int start,int end,int target){

        if(start > end)
            return false;

        int mid = start + (end -start)/2;

        if(arr[mid] == target){
            return true;
        }

        if(arr[mid]< target)
            return binarySearch(arr,mid +1,end,target);
        else {
            return binarySearch(arr, start, mid - 1, target);
        }
    }
}
