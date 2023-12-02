package binarysearch;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println(search(nums, target));
    }


    public static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check if mid == target
            if (nums[mid] == target) return mid;

            // check if left part is sorted
            if (nums[start] <= nums[mid]) {
                // check if target lies in this range
                if (nums[start] <= target && target < nums[mid]) {
                    // target in left so moving left
                    end = mid - 1;
                } else { // target in right so moving right
                    start = mid + 1;
                }
            } else { // right part is sorted
                // check if target lies in this range
                if (nums[mid] < target && target <= nums[end]) {
                    // target in right so moving right
                    start = mid + 1;
                } else { // target in left so moving left
                    end = mid - 1;
                }
            }
        }
        return -1;
    }
}
