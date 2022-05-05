package BinarySearch;

/*
Search element in infinite sorted array
 */

import java.util.Arrays;

public class InfiniteSortedArray {
    public static void main(String[] args) {

        //actually the array is infinite.
        //if we try to remove arr.length in online assessment we wil get error
        int[] arr={0,5,6,8,9,45,78,96,100,112,115,117,119,123,128,130,900,10000,102564,450000};
        int target =128;
        int index=infiniteSearch(arr,target);
        System.out.println(index);
    }

    static int infiniteSearch(int[] arr,int key)
    {
        int low=0;
        int high=1;
        while(arr[high]<key)
        {
            low=high;
            high=2*high;
        }

        return Arrays.binarySearch(arr,low,high,key);
    }
}
