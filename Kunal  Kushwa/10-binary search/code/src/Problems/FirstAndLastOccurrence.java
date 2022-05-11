package Problems;

import java.util.Arrays;

public class FirstAndLastOccurrence {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 5, 5, 5, 12};
        int target = 5;
        System.out.println(Arrays.toString(searchRange(arr,target)));

    }

    public static int[] searchRange(int[] nums, int target) {

        if(nums.length==0 || nums== null)
        {
            return new int[] {-1,-1};
        }
        int[] ans={-1,-1};
         ans[0] =search(nums,target,true);
        if(ans[0]!=-1)
        {
            ans[1] =search(nums,target,false);
        }


        return ans;
    }

    static int search(int[] arr, int target,boolean findStartIndex) {
        int start = 0, end = arr.length - 1;
        int ans = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = mid;
                if(findStartIndex)
                {
                    end = mid - 1;
                }
                else{
                    start=mid+1;
                }

            } else if (arr[mid] < target) {
                start = mid + 1;
            } else //arr[mid] > target
            {
                end = mid - 1;
            }
        }
        return ans;
    }
}
