package EasyBS;

import java.util.Arrays;
import java.util.HashSet;

public class FairCandySwap {
    public static void main(String[] args) {
        int[] aliceSizes={35,17,4,24,10};
        int[] bobSizes={63,21};
        int[] result =fairCandySwap(aliceSizes,bobSizes);
        for(int x:result)
        {
            System.out.print(x+" ");
        }
    }
    public static int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        //first approach using hashset
        int sa=0,sb=0;
        //total candies alices has
        for(int x:aliceSizes)
            sa+=x;

        //total candies bob has
        for(int x:bobSizes)
            sb+=x;

        int delta=(sb-sa)/2;
        // If Alice gives x, she expects to receive x + delta

        HashSet<Integer> setB = new HashSet<>();

        //adding bob candies into set
        for(int x:bobSizes)
            setB.add(x);

        for(int x:aliceSizes)
        {
            if(setB.contains(x+delta))
            {
                return new int[]{x,x+delta};
            }
        }
        throw null;


        //approach using Binary search
        //so both arrays must be sorted
//        Arrays.sort(aliceSizes);
//        Arrays.sort(bobSizes);
//        int sa=0,sb=0;
//        //total candies alices has
//        for(int x:aliceSizes)
//            sa+=x;
//
//        //total candies bob has
//        for(int x:bobSizes)
//            sb+=x;
//
//        int delta=(sb-sa)/2;
//        // If Alice gives x, she expects to receive x + delta
//
//        for(int x:aliceSizes)
//        {
//            if(binarySearch(bobSizes,x+delta))
//            {
//                return new int[]{x,x+delta};
//            }
//        }
//        throw null;
    }

    private static boolean binarySearch(int[] arr, int target) {
        int start=0;
        int end=arr.length-1;
        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(arr[mid]==target)
            {
                return true;
            }
            else if(arr[mid]<target)
            {
                start=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return false;
    }
}
