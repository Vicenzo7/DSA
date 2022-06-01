package RecursionUnacedemy;

import java.util.Arrays;

public class InversionCount {
    public static void main(String[] args) {
        long[] arr={2, 4, 1, 3, 5};
//        System.out.println(bruteForce(arr));

        mergeSort(arr,0,arr.length-1);
        System.out.println(count);
    }


    public static int bruteForce(int[] arr)
    {
        int count =0;
        for (int i = 0; i < arr.length-1 ; i++) {

            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]>arr[j])
                {
                    count++;
                }
            }

        }
        return count;
    }


    // counting inversion using merge Sort
    static long count = 0;
    public static long[] mergeSort(long[] arr, int start,int end)
    {
        if(start==end){
            long[] base = new long[1];
            base[0] = arr[start];
            return base;
        }

        int mid=start+(end-start)/2;

        //sort left part
        long[] left = mergeSort(arr,start,mid);

        //sort right part
        long[] right = mergeSort(arr,mid+1,end);

        //merge the array
        long[] merged = merge(left,right);

        return merged;
    }

    private static long[] merge(long[] left,long[] right) {

        int index1=0;
        int index2=0;
        int k=0;
        long[] merged = new long[left.length+right.length];

        while(index1< left.length && index2 < right.length)
        {
            if(left[index1]<=right[index2])
            {
                merged[k++]=left[index1++];
            }else{
                count += (left.length-index1);
                merged[k++]=right[index2++];
            }
        }

        while(index1<left.length)
        {
            merged[k++]=left[index1++];
        }
        while(index2<right.length)
        {
            merged[k++]=right[index2++];
        }

        return merged;

    }
}
