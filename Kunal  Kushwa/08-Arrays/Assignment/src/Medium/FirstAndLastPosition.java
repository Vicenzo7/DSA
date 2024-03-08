package Medium;

/*
Given an array of integers nums sorted in non-decreasing order, find the starting and ending position of a given target value.

If target is not found in the array, return [-1, -1].

You must write an algorithm with O(log n) runtime complexity.
 */
public class FirstAndLastPosition {
    public static void main(String[] args) {
        int[] arr={5,7,7,8,8,10};
        int target=8;
        int[] result= findStartEnd(arr,target);
        for(int a:result)
        {
            System.out.print(a+" ");
        }

    }

    private static int[] findStartEnd(int[] arr, int target) {
//        int[] ans= new int[2];
//        int j=0;
//        for (int i = 0; i <arr.length ; i++) {
//            if(arr[i]==target)
//            {
//
//                ans[j++]=i;
//            }
//        }
//        return ans;

        // optimized approach with O(log n)
        int start =0,end =arr.length-1;
        while(start<=end)
        {
            if(arr[start]==target && arr[end]==target)
            {
                return new int[]{start,end};
            }
            else if(arr[start]==target && arr[end]!=target)
            {
                end--;
            }
            else if(arr[start]!=target && arr[end]==target)
            {
                start++;
            }
            else
            {
                start++;
                end--;
            }

        }

         return new int[] {-1,-1};




    }
}
