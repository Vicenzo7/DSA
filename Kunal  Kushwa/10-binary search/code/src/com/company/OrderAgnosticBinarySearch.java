package com.company;

public class OrderAgnosticBinarySearch {
    public static void main(String[] args) {
//        int[] arr ={-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int[] arr = {99,80,75,22,11,10,5,2,-3};
        int target= 22;
        System.out.println(orderAgnosticBinarySearch(arr,target));
    }

    static int orderAgnosticBinarySearch(int[] arr, int target) {
        int start = 0, end = arr.length - 1;

        //find whether the array is in sorted in ascending or descending
        boolean isAse = arr[start] < arr[end];

        while (start <= end) {
            //find the middle element
//            int mid=(start+end)/2; // might be possible that (start+end) exceeds the range of int in java
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            }

            //checking
            if (isAse) {
                if (arr[mid] < target) {
                    start = mid + 1;
                } else //arr[mid] > target
                {
                    end = mid - 1;
                }
            } else {

                if (arr[mid] < target) {
                    end = mid - 1;
                } else //arr[mid] > target
                {
                    start = mid + 1;
                }
            }


        }
        return -1;
    }
}
