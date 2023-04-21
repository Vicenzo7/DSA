package array.medium;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 200, 1, 2, 3, 4, 4};
        System.out.println(longestConsecutive(nums));
        System.out.println(longestConsecutiveOptimal(nums));
    }


    /*
     * Brute Force approach
     * TC = O(nlog(n))
     * Due to sorting
     *
     * The Arrays.sort() method in Java uses a tuned quicksort algorithm for primitive types and a mergesort
     * algorithm for object types.
     * The sorting technique is chosen based on the data type of the array to be sorted.
     *
     * The time complexity of quicksort is O(n log n) in the average case and O(n^2) in the worst case,
     * where n is the number of elements to be sorted. The worst-case time complexity occurs when the input
     * array is already sorted or nearly sorted.
     *
     * The time complexity of mergesort is O(n log n) in all cases, including the worst case.
     * This makes it a preferred choice for sorting large arrays or collections of objects.
     *
     * In general, both quicksort and mergesort are efficient sorting algorithms with good average-case performance.
     * However, mergesort is preferred when worst-case performance is a concern or when stability is important, while quicksort is preferred for its simplicity and cache efficiency.
     * */

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0 || nums.length == 1) {
            return nums.length;
        }
        Arrays.sort(nums);
        int maxLength = 0;
        int previousElement = nums[0];
        int currentLength = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == previousElement + 1) {
                currentLength++;
            } else if (nums[i] != previousElement) { // this condition to avoid duplicates
                currentLength = 1;
            }
            previousElement = nums[i];
            maxLength = Math.max(maxLength, currentLength);
        }
        return maxLength;
    }

    /*
     * Optimal approach - Using Hashset
     * TC = O(n)
     * SC = O(n)
     *
     * Intuition
     * First insert all array elements into the HashSet
     * Now we traverse the array and for each element we check if it's a starting element of the sequence
     * For eg , 200 100 3 1 2 4
     * For the above array the ans = 4 and the sequence is 1 2 3 4 and 1 is the staring element of the sequence
     *
     * How to find if element is a starting element of sequence,just check if the Hashset contains element less than
     * the current element
     * eg for 200 does 199 exist
     * 100 - 99 exits
     * for 1 - 0 exists
     *
     * If they don't exist then the current element is the starting element of the sequence
     * Once the staring element is confirmed , we than find for y = x+1, x+2, x+3 ... where x is the starting element of sequence
     * and stop till x+k is not present.
     * */

    public static int longestConsecutiveOptimal(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int maxLengthOfConsecutiveSequence = 0;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                // this means num is the starting element of the sequence
                int currentElement = num;
                int currentStreak = 1;
                while (set.contains(currentElement + 1)) {
                    currentElement += 1;
                    currentStreak++;
                }
                maxLengthOfConsecutiveSequence = Math.max(maxLengthOfConsecutiveSequence, currentStreak);
            }
        }
        return maxLengthOfConsecutiveSequence;
    }
}
