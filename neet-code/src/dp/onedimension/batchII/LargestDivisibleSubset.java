package dp.onedimension.batchII;

import java.util.*;

public class LargestDivisibleSubset {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 4, 8};
//        int[] nums = {1, 2, 3};
//        int[] nums = {5, 9, 18, 54, 108, 540, 90, 180, 360, 720};
        int[] nums = {4, 8, 10, 240};
        System.out.println(largestDivisibleSubset(nums));
    }

    static
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums); // sorting helps in finding the largest divisible in sorted order
        List<Integer> current = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
//        bruteForce(0, -1, nums, current, result);

//        int[] dp = new int[nums.length + 1];
//        Arrays.fill(dp, -1);
//        memoization(0, -1, nums, current, result, dp);
//        return result;


//        Map<Integer, List<Integer>> cache = new HashMap<>();
//        for (int i = 0; i < nums.length; i++) {
//            List<Integer> temp = memoizationOptimised(i, nums, cache);
//            if (temp.size() > result.size()) {
//                result = temp;
//            }
//        }
//        return result;

        return dp(nums);

    }


    static
    private void bruteForce(int index, int prevIndex, int[] nums, List<Integer> current, List<Integer> result) {
        if (index >= nums.length) {
            if (result.size() < current.size()) {
                result.clear();
                result.addAll(current);
            }
            return;
        }

        // include
        current.add(nums[index]);
        if (prevIndex == -1 || (nums[index] % nums[prevIndex] == 0 || nums[prevIndex] % nums[index] == 0)) {
            bruteForce(index + 1, index, nums, current, result);
        }

        // exclude
        current.remove(current.size() - 1);
        bruteForce(index + 1, prevIndex, nums, current, result);
    }


    /*
        TC = O(n^2) -> height of the tree is n, and we have to decision but so normally
        it would be 2^n but due to caching its n^2
        SC = O(n^2)
    */


    static
    private void memoization(int index, int prevIndex, int[] nums, List<Integer> current, List<Integer> result, int[] dp) {
        if (index >= nums.length) {
            if (result.size() < current.size()) {
                result.clear();
                result.addAll(current);
            }
            return;
        }

        // include
        current.add(nums[index]);
        if (current.size() > dp[index] && (prevIndex == -1 || (nums[index] % nums[prevIndex] == 0 || nums[prevIndex] % nums[index] == 0))) {
            dp[index] = current.size();
            memoization(index + 1, index, nums, current, result, dp);
        }


        // exclude
        current.remove(current.size() - 1);
        memoization(index + 1, prevIndex, nums, current, result, dp);
    }

     /*
        TC = O(n^2) -> height of the tree is n, and we have to decision but so normally
        it would be 2^n but due to caching its n^2
        SC = O(n) -> Below solution is more memory efficient

        cache[i] = longest divisible subset at i, including nums[i
    */

    static
    private List<Integer> memoizationOptimised(int i, int[] nums, Map<Integer, List<Integer>> cache) {
        if (i >= nums.length) {
            return new ArrayList<>();
        }

        if (cache.containsKey(i)) {
            return new ArrayList<>(cache.get(i));
        }
        List<Integer> result = new ArrayList<>();
        result.add(nums[i]);

        // Explore all possible elements to form a subset.
        for (int j = i + 1; j < nums.length; j++) {
            if (nums[j] % nums[i] == 0) {
                List<Integer> temp = memoizationOptimised(j, nums, cache);
                // Prepend nums[i] and create a new list.
                List<Integer> candidate = new ArrayList<>(temp);
                candidate.add(0, nums[i]);

                if (candidate.size() > result.size()) {
                    result = candidate;
                }
            }
        }
        cache.put(i, result);
        return result;
    }

    static
    private List<Integer> dp(int[] nums) {
        List<List<Integer>> dp = new ArrayList<>();
        for (int num : nums) {
            List<Integer> temp = new ArrayList<>();
            temp.add(num);
            dp.add(temp);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] % nums[i] == 0) {
                    List<Integer> temp = new ArrayList<>(dp.get(j));
                    temp.add(0, nums[i]);
                    if (temp.size() > dp.get(i).size()) {
                        dp.set(i, temp);
                    }
                }
            }
            if (dp.get(i).size() > result.size()) {
                result = dp.get(i);
            }
        }
        return result;
    }

}
