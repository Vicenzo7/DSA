package dp.twodimension;

import java.util.Arrays;

public class CoinChangeII {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1, 2, 5};

//        coins = new int[]{2};
//        amount = 3;
        System.out.println(change(amount, coins));
    }

    public static int change(int amount, int[] coins) {
//        return bruteForce(0, coins, amount);

//        int[][] cache = new int[coins.length][amount + 1];
//        for (int[] row : cache) {
//            Arrays.fill(row, -1);
//        }
//        return memoization(0, coins, amount, cache);

        return dp(coins, amount);
    }

    public static int bruteForce(int index, int[] coins, int amount) {
        if (index == coins.length || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }
        // include
        int option1 = bruteForce(index, coins, amount - coins[index]);
        // exclude
        int option2 = bruteForce(index + 1, coins, amount);
        return option1 + option2;
    }

    public static int memoization(int index, int[] coins, int amount, int[][] cache) {
        if (index == coins.length || amount < 0) {
            return 0;
        }

        if (amount == 0) {
            return 1;
        }

        if (cache[index][amount] != 0) {
            return cache[index][amount];
        }

        // include
        int option1 = memoization(index, coins, amount - coins[index], cache);
        // exclude
        int option2 = memoization(index + 1, coins, amount, cache);

        cache[index][amount] = option1 + option2;
        return cache[index][amount];
    }

    public static int dp(int[] coins, int amount) {
        int[][] dp = new int[coins.length + 1][amount + 1];

        // base case: If the amount is zero there is one way to make change (by choosing no coins)
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 1;
        }

        for (int i = 1; i <= coins.length; i++) {
            for (int currentAmount = 1; currentAmount <= amount; currentAmount++) {
                // number of ways to make the change without considering the current coin
                int skip = dp[i - 1][currentAmount];

                int include = 0;
                // current amount - previous amount if previous coin was used
                if (currentAmount - coins[i-1] >= 0) {
                    // number of ways to make change considering the current coin
                    include = dp[i][currentAmount - coins[i - 1]];
                }
                dp[i][currentAmount] = skip + include;
            }
        }

        return dp[coins.length][amount];
    }
}
