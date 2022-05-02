package com.company;

public class BinarySearch {

    public static void main(String[] args) {
//        int[] arr = {-18,-12,-4,0,2,3,4,15,16,18,22,45,89};
        int[] arr = {99,80,75,22,11,10,5,2,-3};
        int target= 22;
        System.out.println(binarySearch2(arr,target));
    }


    //return the index
    //return -1 if it does not exist
    static int binarySearch(int[] arr, int target)
    {
        int start=0,end=arr.length-1;

        while(start <= end)
        {
            //find the middle element
//            int mid=(start+end)/2; // might be possible that (start+end) exceeds the range of int in java
            int  mid= start + (end-start)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                start=mid+1;
            }
            else //arr[mid] > target
            {
                end = mid-1;
            }
        }
        return -1;
    }

    //descending order
    static int binarySearch2(int[] arr, int target)
    {
        int start=0,end=arr.length-1;

        while(start <= end)
        {
            //find the middle element
//            int mid=(start+end)/2; // might be possible that (start+end) exceeds the range of int in java
            int  mid= start + (end-start)/2;
            if(arr[mid] == target)
            {
                return mid;
            }
            else if(arr[mid] < target)
            {
                end = mid-1;
            }
            else //arr[mid] > target
            {
                start=mid+1;
            }
        }
        return -1;
    }
}
