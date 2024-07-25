package dp.onedimension;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
//        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] nums = {0, 1, 0, 3, 2, 3};
//        int[] nums = {7, 7, 7, 7, 7, 7, 7};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
//        return bruteForce(0, nums, -1);

//         two dp since two variables are chancing
//        int[][] cache = new int[nums.length][nums.length + 1];
//        for (int[] rows : cache) {
//            Arrays.fill(rows, -1);
//        }
//        return memoization(0, nums, -1, cache);


        return dp(nums);
    }

    // TC =  O(n^2)
    private static int dp(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, 1); // filling with 1 because, every element is a sub-sequence

        //Traverse the array from back to front
        for (int i = nums.length - 1; i >= 0; i--) {
            // Iterate over elements to the right of nums[i]
            for (int j = i + 1; j < nums.length; j++) {
                // If the current element is greater than nums[i], it can be appended to form an increasing subsequence
                if (nums[i] < nums[j]) {
                    // Update the length of the longest increasing subsequence ending at nums[i]
                    cache[i] = Math.max(cache[i], 1 + cache[j]);
                }
            }
        }


        return Arrays.stream(cache).max().orElse(0);
    }

    private static int memoization(int index, int[] nums, int previousIndex, int[][] cache) {
        if (index == nums.length) {
            return 0;
        }


        if (cache[index] [previousIndex + 1] != -1) {
            return cache[index][previousIndex + 1]; // previousIndex+1 because previousIndex is -1
        }

        // pick nums[index]
        int option1 = 0;
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            option1 = 1 + memoization(index + 1, nums, index, cache);
        }

        // don't pick nums[index]
        int option2 = memoization(index + 1, nums, previousIndex, cache);
        cache[index][previousIndex + 1] = Math.max(option1, option2);
        return cache[index][previousIndex + 1];


    }

    private static int bruteForce(int index, int[] nums, int previousIndex) {
        if (index >= nums.length) {
            return 0;
        }

        // pick nums[index]
        int option1 = 0;
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            option1 = 1 + bruteForce(index + 1, nums, index);
        }

        // don't pick nums[index]
        int option2 = bruteForce(index + 1, nums, previousIndex);

        return Math.max(option1, option2);
    }
}
