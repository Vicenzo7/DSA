package dp.pattern.linear_sequence_with_constant_transition;

public class MinCostClimbingStairs {
    public static void main(String[] args) {
        int[] cost = {1, 100, 1, 1, 1, 100, 1, 1, 100, 1};
        System.out.println(minCostClimbingStairs(cost));
    }

    public static int minCostClimbingStairs(int[] cost) {
        return dp(cost);
//        return optimalSolution(cost);
    }

    private static int optimalSolution(int[] cost) {
        for (int i = cost.length - 1; i >= 0; i--) {
            /*
                solving the sub problem(trying to reach target from 1 step behind it)
                standing on the last index and making 1 jump and 2 jump
                and finding out the minimum cost to reach the top.
            */
            if (i + 2 < cost.length) {
                cost[i] = cost[i] + Math.min(cost[i + 1], cost[i + 2]);
            }
        }

        // we can either start from index 0 (1 jump) or index 1(2 jump)
        return Math.min(cost[0], cost[1]);
    }

    public static int dp(int[] cost) {
        /*
            to reach some staircase n
            option 1:
            go there from stair n - 1
            (min cost to reach staircase n - 1) + (cost to go to n from n - 1)
            (min cost to reach staircase n - 1) + cost[n-1]

            option 2:
            go there from stair n - 2
            (min cost to reach staircase n - 2) + (cost to go to n from n - 2)
            (min cost to reach staircase n - 2) + cost[n-2]

            base cases:
            index 0,
            index 1,
            both indices 0,1 have a cost 0
        */

        int n = cost.length;
        // dp[i] store minimum cost to reach staircase i
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 0;

        for (int i = 2; i <= n; i++) {
            int option1 = dp[i - 1] + cost[i - 1];
            int option2 = dp[i - 2] + cost[i - 2];

            dp[i] = Math.min(option1, option2);
        }
        return dp[n];
    }
}
