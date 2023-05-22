package binarysearch;

public class CountOccurrencesInSortedArray {
    public static void main(String[] args) {
        int target = 4;
        int[] nums = {1, 1, 2, 2, 2, 2, 3};

        System.out.println(countOccurrence(nums, target));
    }

    /*

        Brute force
        Run a for loop and find first and last occurrence
         count = last - first + 1

        TC = O(n)

        Since the array is sorted use Binary Search

         Step1: Find the first occurrence
         Step2: Find the second occurrence
         Step3: count = lastOccurrence - firstOccurrence + 1


         TC = O(log(n))

    */


    public static int countOccurrence(int[] nums, int target) {
        int firstOccurrence = occurrence(nums, target, true);
        int lastOccurrence = occurrence(nums, target, false);

        if (firstOccurrence == -1 || lastOccurrence == -1) return 0;

        return lastOccurrence - firstOccurrence + 1;
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
