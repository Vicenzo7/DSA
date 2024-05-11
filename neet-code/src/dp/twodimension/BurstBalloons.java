package dp.twodimension;

import java.util.*;

public class BurstBalloons {

    public static void main(String[] args) {
        int[] nums = {3, 1, 5, 8};

        System.out.println(maxCoins(nums));
    }


    /*
       TC = O(n^3)  SC = O(n^2)
       Why TC = O(n^3)
       for  n length, then we have (n.(n+1)) / 2 sub-arrays
       To create these sub-arrays  TC = O(n^2), and to iterate these sub-arrays TC = O(n)

       There TC = O(n^3),


       Instead of considering ith index to be removed consider ith index to be removed last

        Add 1 in the beginning and 1 at the last
        nums = 1  [3, 1, 5, 8]  1
                   L        R
        if we remove 5 last

        then sum =  nums[left-1] * 5 * nums[right+1] + dfs(left,i-1) + dfs(i+1,right)
    */

    public static int maxCoins(int[] nums) {
        return dfs(0, nums.length - 1, nums, new int[nums.length][nums.length]);
    }

    private static int dfs(int left, int right, int[] nums, int[][] cache) {
        if (left > right) {
            return 0;
        }

        if (cache[left][right] != 0) {
            return cache[left][right];
        }

        for (int i = left; i <= right; i++) {
            int leftBalloon = left - 1 >= 0 ? nums[left - 1] : 1;
            int rightBalloon = right + 1 < nums.length ? nums[right + 1] : 1;
            int coins = leftBalloon * nums[i] * rightBalloon;
            coins += dfs(left, i - 1, nums, cache) + dfs(i + 1, right, nums, cache);
            cache[left][right] = Math.max(cache[left][right], coins);
        }

        return cache[left][right];
    }


}
