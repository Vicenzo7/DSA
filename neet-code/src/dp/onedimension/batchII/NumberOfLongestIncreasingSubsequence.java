package dp.onedimension.batchII;

import util.CustomPair;

public class NumberOfLongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 7};
//        int[] nums = {2, 2, 2, 2, 2};
//        int[] nums = {1, 2, 4, 3, 5, 4, 7, 2};
        System.out.println(findNumberOfLIS(nums));
    }

    public static int findNumberOfLIS(int[] nums) {
//        int[] ans = bruteForce(0, -1, nums);
//        return ans[1];

        CustomPair<Integer, Integer> ans = memoization(0, -1, nums, new CustomPair[nums.length + 1][nums.length + 1]);
        return ans.getValue();


    }


    private static int[] bruteForce(int index, int previousIndex, int[] nums) {
        if (index >= nums.length) {
            // found LIS of length 0 and occurrence of such LIS is 1
            return new int[]{0, 1};
        }

        int numberOfLIS = 0;
        int maxLengthOfLIS = 0;

        // include
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            int[] include = bruteForce(index + 1, index, nums);
            int includeLength = 1+ include[0]; // because current element was in LIS sequence
            if (includeLength > maxLengthOfLIS) {
                maxLengthOfLIS = includeLength;
                numberOfLIS = include[1];
            } else if (include[0] == maxLengthOfLIS) {
                numberOfLIS += include[1];
            }
        }

        // dont pick
        int[] exclude = bruteForce(index + 1, previousIndex, nums);
        if (exclude[0] > maxLengthOfLIS) {
            maxLengthOfLIS = exclude[0];
            numberOfLIS = exclude[1];
        } else if (exclude[0] == maxLengthOfLIS) {
            numberOfLIS += exclude[1];
        }
        return new int[]{maxLengthOfLIS, numberOfLIS};
    }

    private static CustomPair<Integer, Integer> memoization(int index, int previousIndex, int[] nums, CustomPair<Integer, Integer>[][] cache) {
        if (index >= nums.length) {
            // found LIS of length 0 and occurrence of such LIS is 1
            return new CustomPair<>(0, 1);
        }

        if (cache[index][previousIndex + 1] != null) {
            return cache[index][previousIndex + 1];
        }


        int numberOfLIS = 0;
        int maxLengthOfLIS = 0;

        // include
        if (previousIndex == -1 || nums[index] > nums[previousIndex]) {
            CustomPair<Integer, Integer> include = memoization(index + 1, index, nums, cache);
            int includeLength = 1 + include.getKey();  // because current element was in LIS sequence
            if (includeLength > maxLengthOfLIS) {
                maxLengthOfLIS = includeLength;
                numberOfLIS = include.getValue();
            } else if (include.getKey() == maxLengthOfLIS) {
                numberOfLIS += include.getValue();
            }
        }

        // dont pick
        CustomPair<Integer, Integer> exclude = memoization(index + 1, previousIndex, nums, cache);
        if (exclude.getKey() > maxLengthOfLIS) {
            maxLengthOfLIS = exclude.getKey();
            numberOfLIS = exclude.getValue();
        } else if (exclude.getKey() == maxLengthOfLIS) {
            numberOfLIS += exclude.getValue();
        }
        cache[index][previousIndex + 1] = new CustomPair<>(maxLengthOfLIS, numberOfLIS);
        return cache[index][previousIndex + 1];
    }


}
