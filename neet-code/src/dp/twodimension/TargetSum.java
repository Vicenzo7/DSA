package dp.twodimension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TargetSum {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 1};
        int target = 3;

        nums = new int[]{1000};
        target = -1000;

        System.out.println(findTargetSumWays(nums, target));
    }

    public static int findTargetSumWays(int[] nums, int target) {
//        return bruteForce(0, 0, target, nums);

//        return memoization(0, target, nums, new HashMap<>());

        int[][] cache = new int[nums.length + 1][2001];
        for (int[] row : cache) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        return dp(0, target, nums, cache);
    }

    private static int bruteForce(int index, int curSum, int target, int[] nums) {
        if (index == nums.length) {
            if (target == curSum) {
                return 1;
            }
            return 0;
        }

        // two option -> either + nums[index] or - nums[index]
        int positive = bruteForce(index + 1, curSum + nums[index], target, nums);
        int negative = bruteForce(index + 1, curSum - nums[index], target, nums);
        return positive + negative;
    }

    private static int memoization(int index, int target, int[] nums, Map<String, Integer> cache) {
        if (target == 0 && index == nums.length) {
            return 1;
        }

        if (index == nums.length) {
            return 0;
        }

        if (cache.containsKey(index + ":" + target)) {
            return cache.get(index + ":" + target);
        }

        // two option -> either + nums[index] or - nums[index]
        int positive = memoization(index + 1, Math.abs(target + nums[index]), nums, cache);
        int negative = memoization(index + 1, Math.abs(target - nums[index]), nums, cache);

        cache.put(index + ":" + target, positive + negative);
        return positive + negative;
    }

    private static int dp(int index, int target, int[] nums, int[][] cache) {
        if (target == 0 && index == nums.length) {
            return 1;
        }

        if (index == nums.length) {
            return 0;
        }

        if (cache[index][Math.abs(target)] != Integer.MAX_VALUE) {
            return cache[index][Math.abs(target)];
        }

        // two option -> either + nums[index] or - nums[index]
        int positive = dp(index + 1, Math.abs(target + nums[index]), nums, cache);
        int negative = dp(index + 1, Math.abs(target - nums[index]), nums, cache);

        cache[index][Math.abs(target)] = positive + negative;
        return positive + negative;
    }
}
