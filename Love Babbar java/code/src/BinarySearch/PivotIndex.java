// problem description on Love Babbar Youtube video

package BinarySearch;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {3,4,5,6,1,2};
        int result = findIndex(nums);
        System.out.println("Pivot index is :" + result);

    }

    private static int findIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            //first line
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else//second line
            {
                end = mid;
            }
        }
        return start;//if we do start -1 we will get pivot as 6  // we can return end also



        //if pivot is 6
//        int n = nums.length;
//        int start = 0;
//        int end = n - 1;
//
//        while (start < end) {
//            int mid = start + (end - start) / 2;
//            //if mid is greater than mid+1(next of mid) than mid is pivot
//            if (mid<end && nums[mid]>nums[mid+1]) {
//                return mid;
//            }
//            //if mid is less than mid-1(previous of mid) than mid is pivot
//            if (mid>0 && nums[mid]<nums[mid-1]) {
//                return mid-1;
//            }
//
//            if(nums[mid]>=nums[start])
//            {
//                start=mid+1;
//            }
//            else{
//                end=mid-1;
//            }
//
//        }
//        return start;
    }
}
