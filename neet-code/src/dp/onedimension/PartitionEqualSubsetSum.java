package dp.onedimension;

import java.util.Arrays;
import java.util.Map;

public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        int[] nums = {1, 5, 11, 5};
        System.out.println(canPartition(nums));
    }

    public static boolean canPartition(int[] nums) {
        /*
         * Intuition:
         * If the sum of the given array is odd then equal partition is not possible
         *
         * If sum is even there is chance of equal partition
         * How ??
         * If sum is even then we have to find out if there is a subset whose sum is
         * equal to half of array sum
         *
         * ie [a sub set] whos sum = sum(arr)/2
         *
         * eg [1,5,11,5] -> sum = 22
         *
         * need a subset that can sum 11
         */

        int sum = Arrays.stream(nums).sum();
        if (sum % 2 == 1) {
            return false;
        }

        int halfSum = sum / 2;
//        return bruteForce(0, halfSum, nums);
//        return memoization(0, halfSum, nums, new HashMap<>());
        Boolean[][] dp = new Boolean[nums.length + 1][halfSum + 1];
        return dp(0, halfSum, nums, dp);
    }


    //TC(n.halfSum)  SC = (n.halfSum)
    private static boolean dp(int index, int sum, int[] nums, Boolean[][] cache) {
        if (sum == 0) {
            return true;
        }

        if (index == nums.length || sum < 0) {
            return false;
        }

        if (cache[index][sum] != null) {
            return cache[index][sum];
        }

        // include
        boolean option1 = dp(index + 1, sum - nums[index], nums, cache);
        // exclude
        boolean option2 = dp(index + 1, sum, nums, cache);

        cache[index][sum] = option1 || option2;
        return cache[index][sum];
    }

    private static boolean memoization(int index, int sum, int[] nums, Map<String, Boolean> cache) {
        if (sum == 0) {
            return true;
        }

        if (index == nums.length || sum < 0) {
            return false;
        }

        if (cache.containsKey(index + ":" + sum)) {
            return cache.get(index + ":" + sum);
        }

        // include
        boolean option1 = memoization(index + 1, sum - nums[index], nums, cache);
        // exclude
        boolean option2 = memoization(index + 1, sum, nums, cache);
        boolean result = option1 || option2;
        cache.put(index + ":" + sum, result);
        return result;
    }

    public static boolean bruteForce(int index, int sum, int[] nums) {
        if (sum == 0) {
            return true;
        }

        if (index == nums.length || sum < 0) {
            return false;
        }

        // option1 -> include nums[index] in the subset
        boolean option1 = bruteForce(index + 1, sum - nums[index], nums);

        // option2 -> exclude nums[index] from the subset
        boolean option2 = bruteForce(index + 1, sum, nums);

        return option1 || option2;
    }

}
