package HardBS;

import java.util.Arrays;

public class Eko {
    public static void main(String[] args) {
        int [] arr={4, 42, 40, 26, 46};
        int target=20;

        int maxHeight=getMaxHeightOfSaw(arr,target);
        System.out.println(maxHeight);
    }

    private static int getMaxHeightOfSaw(int[] arr,int target) {
        //sorted the array to get max tree height which will be our end;
        Arrays.sort(arr);
        int n=arr.length;
        int start=0;
        int end=arr[n-1];

        int ans=-1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(isPossibleSolution(mid,arr,target))
            {
                //store ans
                ans=mid;
                start=mid+1;
            }
            else
            {
                //left
                end=mid-1;
            }
        }
        return ans;
    }

    private static boolean isPossibleSolution(int mid, int[] arr, int target) {
        int sum=0;
//        for (int i = 0; i <arr.length ; i++) {
//            int diff=0;
//            if(arr[i]>mid)
//            {
//                diff=arr[i]-mid;
//            }
//            sum +=diff;
//        }
//        if(sum>=target)
//        {
//            return true;
//        }

        for(int x:arr)
        {
            if(x>mid)
            {
                sum= sum+x-mid;
                if(sum>=target)
                {
                    return true;
                }
            }
        }
        return false;
    }
}
