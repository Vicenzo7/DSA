package binarysearch;

public class FindMinimumInRotatedAndSortedArray {
    public static void main(String[] args) {
        /*
            1.if left part is sorted
                1a.check if target exist in that range
                    if exist go a search
                1b. if no go to right;
            2. Means right part is sorted
                2a. check if target exist is this range
                    if yes search in that range
                2b. if no go towards left

        */

        int[] nums = {3, 4, 5, 6, 7, 0, 1, 2};
        System.out.println(findMin(nums));

    }

    // Solution 2:

    public static int findMin(int[] nums) {
        int start = 0, end = nums.length - 1;

        int minimum = Integer.MAX_VALUE;
        while (start <= end) {
            // check if array is sorted
            if (nums[start] < nums[end]) {
                return Math.min(minimum, nums[start]);
            }

            int mid = start + (end - start) / 2;

            // check if left part is sorted
            if (nums[start] <= nums[mid]) {
                minimum = Math.min(minimum, nums[start]);
                start = mid + 1;
            } else {
                minimum = Math.min(minimum, nums[mid]);
                end = mid - 1;
            }
        }

        return minimum;
    }

    // Method 1: Pivot Method

    public static int findMin2(int[] nums) {
        int pivotIndex = findPivotIndex(nums);

        // pivotIndex means a index which has the greatest element
        // means array is not rotated
        if (pivotIndex == -1) return nums[0];

        return nums[pivotIndex + 1];
    }

    private static int findPivotIndex(int[] nums) {

        int start = 0, end = nums.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (mid < end && nums[mid] > nums[mid + 1]) {
                return mid;
            }

            if (mid > 0 && nums[mid - 1] > nums[mid]) {
                return mid - 1;
            }

            if (nums[start] < nums[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }
}
