package dp.pattern.linear_sequence_with_constant_transition;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        nums = new int[]{1, 2, 3, 1};
        System.out.println(rob(nums));
        System.out.println(robOptimised(nums));
    }

    private static int rob(int[] nums) {
        /*
            option 1:
            Rob from first house
            dp[0] = nums[0]

            option 2:
            Rob from second house
        */


        int[] dp = new int[nums.length + 1];
        dp[0] = nums[0]; // because we are robbing from the first house

        /*
            How to row from second house
            dp[1] = max(nums[1] + dp[1-2], dp[1-1])
            dp[1] = max(nums[1] + 0, dp[0])
            dp[1] = max(nums[1],nums[0]);
       */
        dp[1] = Math.max(nums[0], nums[1]);


        for (int i = 2; i < nums.length; i++) {
            // if ith house is robbed,we cannot rob i - 1 house
            // if ith house is not robbed,we can rob i - 1 house
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }

    // recurrence relation -> rob = max(arr[0] + rob[2:n], rob[1:n]
    // TC = O(n)
    public static int robOptimised(int[] nums) {
        int rob1 = 0; // Maximum amount robbed with considering current house
        int rob2 = 0; // Maximum amount robbed without considering current house

        for (int moneyInHouse : nums) {
            int maxCash = Math.max(rob1 + moneyInHouse, rob2);
            rob1 = rob2;
            rob2 = maxCash;
        }

        return rob2;
    }
}
