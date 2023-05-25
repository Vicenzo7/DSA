package binarysearch;


public class RotationCount {
    public static void main(String[] args) {
        int[] nums = {2, 3, 4, 5, 1};
        System.out.println(findKRotation(nums));
    }

    /*
         Find the pivotIndex if pivotIndex does not exist then array is rotated 0 times
         else rotationCount = pivotIndex+1;
     */

    public static int findKRotation(int[] nums) {
        int pivotIndex = getPivotIndex(nums);

        if (pivotIndex == -1) return 0;

        return pivotIndex + 1;
    }

    private static int getPivotIndex(int[] nums) {
        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            // check if mid is a pivotIndex
            if (mid < high && nums[mid] > nums[mid + 1])
                return mid;

            // check if mid -1 is pivotIndex
            if (mid > 0 && nums[mid - 1] > nums[mid])
                return mid - 1;


            if (nums[mid] >= nums[low]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }
}
