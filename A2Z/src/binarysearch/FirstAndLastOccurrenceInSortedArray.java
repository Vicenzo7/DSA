package binarysearch;

import java.util.Arrays;

public class FirstAndLastOccurrenceInSortedArray {
    public static void main(String[] args) {
        int target = 13;
        int[] nums = {3, 4, 13, 13, 13, 20, 40};
        System.out.println(Arrays.toString(searchRange(nums, target)));
    }


   /* Brute Force
    Run a for loop and find first and last occurrence
            TC = O(n)

    Optimal Approach
    Since the Array is sorted use binarySearch
    Once the element is found update the index and then move the low or high pointer accordingly based on
    what you want to find ie: first or last occurence

    If first occurrence then re-assign high = mid -1 when element found
    If last occurrence then re-assign low = mid +1 when element found

    Rest same process as binarySearch

    TC = O(log(n))*/

    public static int[] searchRange(int[] nums, int target) {
        int firstOccurrence = occurrence(nums, target, true);
        int lastOccurrence = occurrence(nums, target, false);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    public static int occurrence(int[] nums, int target, boolean firstOccurrence) {
        int low = 0, high = nums.length - 1;
        int index = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (firstOccurrence) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return index;
    }
}
