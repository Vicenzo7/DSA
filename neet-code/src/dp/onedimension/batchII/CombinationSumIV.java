package dp.onedimension.batchII;

import java.util.HashMap;
import java.util.Map;

public class CombinationSumIV {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        int target = 4;
        System.out.println(combinationSum4(nums, target));
    }


    public static int combinationSum4(int[] nums, int target) {
//        return bruteForce(0, nums, target);
//        return memoization(0, nums, target, new HashMap<>());
        return memoizationWithArray(0, nums, target, new Integer[nums.length][target + 1]);
    }


    public static int bruteForce(int index, int[] nums, int target) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }
        int ans = 0;
        for (int i = index; i < nums.length; i++) {
            ans += bruteForce(index, nums, target - nums[i]);
        }
        return ans;
    }

    public static int memoization(int index, int[] nums, int target, Map<String, Integer> cache) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (cache.containsKey(index + ":" + target)) {
            return cache.get(index + ":" + target);
        }
        int ans = 0;
        for (int i = index; i < nums.length; i++) {
            ans += memoization(index, nums, target - nums[i], cache);
        }

        cache.put(index + ":" + target, ans);
        return ans;
    }

    public static int memoizationWithArray(int index, int[] nums, int target, Integer[][] cache) {
        if (target == 0) {
            return 1;
        }

        if (target < 0) {
            return 0;
        }

        if (cache[index][Math.abs(target)] != null) {
            return cache[index][Math.abs(target)];
        }
        int ans = 0;
        for (int i = index; i < nums.length; i++) {
            ans += memoizationWithArray(index, nums, target - nums[i], cache);
        }

        cache[index][Math.abs(target)] = ans;
        return ans;
    }
}
