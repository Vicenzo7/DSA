package binarysearch.oneDArray;

public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = {-1, 0, 3, 5, 9, 12};
        int target = 9;
//        System.out.println(binarySearch(nums, target));
        System.out.println(recursiveBinarySearch(nums, target, 0, nums.length - 1));
    }


  /*  Time complexity: O(log n)

    Space complexity : O(1)*/

    private static int binarySearch(int[] nums, int target) {
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
        return -1;
    }

//    Time complexity: O(log n)
//
//    Space complexity: O(logn) for auxiliary space

    private static int recursiveBinarySearch(int[] nums, int target, int low, int high) {
        if (low > high) {
            return -1;
        }

        int mid = low + (high - low) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) {
            return recursiveBinarySearch(nums, target, mid + 1, high);
        } else {
            return recursiveBinarySearch(nums, target, low, mid - 1);
        }
    }
}
