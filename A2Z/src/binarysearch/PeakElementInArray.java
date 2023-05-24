package binarysearch;

public class PeakElementInArray {
    public static void main(String[] args) {

        /*Problem Statement: Given an array, find a peak element(print anyone, if many are found).
        A peak element is one such that it is either greater than or equal to its neighbors.
                For the first and last element, it is enough to look at its only one neighbor.*/
        int[] nums = {1, 2, 3};
        // peak element here is 5

        System.out.println(findPeakElement(nums));
        System.out.println(binarySearch(nums));
        System.out.println(binarySearch2(nums));
    }


    /*
        Brute Force
        Traverse each element and check if it's a peak element

        TC = O(n)
    */

    public static int findPeakElement(int[] nums) {
        if (nums[0] >= nums[1]) {
            return nums[0];
        }
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i - 1] && nums[i] >= nums[i + 1]) {
                return nums[i];
            }
        }

        return nums[nums.length - 1];
    }

    /*
        Optimal solution is using Binary Search

        Steps
        1.So we are going to use binary search. As usual, we find a middle element and if it is a peak, then we are done.
        2.If not, we follow a greater element. That is, we shrink the binary search to one half. To be precise,
        if the left element is greater, we then do binary search only on the left half.

        3.Else(the right element must be a greater one), we search on the right half.
        Ultimately, we'll end up with one of the peaks.
    */


    public static int binarySearch(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if mid == 0, then peak element is either at 0th or 1st index
            if (mid == 0)
                return Math.max(nums[0], nums[1]);

            // if mid == n-1, then peak element is at (n-1)th or (n-2)th index
            if (mid == n - 1)
                return Math.max(nums[n - 1], nums[n - 2]);

            // check if mid is the peak element,
            if ((nums[mid] >= nums[mid - 1]) && nums[mid] >= nums[mid + 1]) {
                return nums[mid];
            } else if (nums[mid - 1] > nums[mid]) { // if mid is not peak element, move towards the greater element side
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }


    public static int binarySearch2(int[] nums) {
        int n = nums.length;
        int low = 0, high = n - 1;

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (nums[mid] < nums[mid + 1])
                low = mid + 1;
            else
                high = mid;
        }

        return nums[low];
    }

}
