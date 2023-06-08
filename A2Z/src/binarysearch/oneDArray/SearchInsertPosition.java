package binarysearch.oneDArray;

public class SearchInsertPosition {
    public static void main(String[] args) {
        /*Example 1:

        Input: nums = [1,3,5,6], target = 5
        Output: 2

        Example 2:
        Input: nums = [1,3,5,6], target = 2
        Output: 1

        Example 3:
        Input: nums = [1,3,5,6], target = 7
        Output: 4*/

        int[] nums = {1, 3, 5, 6};
        int target = 7;

        System.out.println(searchInsert(nums,target));
    }

    /*
        Solution - BinarySearch

        Since the array is sorted apply a binary search,
        if we find the target we return its index or the index where it could have been placed

        Step1 : run the loop while low <= high
        if nums[mid] == target return mid;
        else if nums[mid] < target -> low = mid+1
        else if nums[mid] > target -> high = mid-1;

        if we don't find the element just return the low pointer that will be the index at which we need to insert the target

    */

    public static int searchInsert(int[] nums, int target) {
        int low = 0, high = nums.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {

                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }
}
