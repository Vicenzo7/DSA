package ArraysProblems;

import java.util.Arrays;

public class MinimizeTheHeightsII {
    public static void main(String[] args) {
        int[] arr={1, 5, 8, 10};
        int k=2;
        int n= arr.length;
        int result = getminDiff(arr,n,k);
        System.out.println(result);
    }

    public static int getminDiff(int[] arr, int n, int k) {

        //TC O(nlogn) for sorting
        Arrays.sort(arr);

       int diff=arr[n-1]-arr[0];
       int max,min;
       for(int i=1;i<n;i++)
       {
           if(arr[i]-k<0)
           {
               continue;
           }
           max=Math.max(arr[i-1]+k,arr[n-1]-k);
           min = Math.min(arr[0]+k,arr[i]-k);

           diff=Math.min(diff,max-min);
       }
       return diff;
    }
}
