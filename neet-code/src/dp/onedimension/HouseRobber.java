package dp.onedimension;

public class HouseRobber {
    public static void main(String[] args) {
//        int[] nums = {2, 7, 9, 3, 1};
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
        System.out.println(robOptimised(nums));
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

    public static int rob(int[] nums) {

        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        if (n == 1) {
            return nums[0];
        }

        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }

        return dp[n - 1];

    }
}
