package binarysearch;
//https://practice.geeksforgeeks.org/problems/floor-in-a-sorted-array-1587115620/1?track=DSASP-Searching&amp%3BbatchId=154
public class FloorInSortedArray {
    public static void main(String[] args) {
        int x = 106;
        long[] nums = {66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89,
                90, 91, 92, 93, 94, 95, 96, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112,
                113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130};
        System.out.println(findFloor(nums, x));
    }

    /*
        Solution
        Since the array is sorted we can apply binary search
        Steps
        1. If nums[mid] == X return mid
        2 If nums[mid] < X
            then check if nums[mid]> maxTillNow, if true update maxTillNow and also store the mid;
            update low = mid+1
        3. If nums[mid] > X , then update high = mid-1

        TC = O(log(n))
    */

    public static int findFloor(long[] nums, long x) {
        int result = -1;
        long max = Long.MIN_VALUE;

        int low = 0, high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] == x) {
                return mid;
            } else if (nums[mid] < x) {
                if (nums[mid] > max) {
                    max = nums[mid];
                    result = mid;
                }
                low = mid + 1;

            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
