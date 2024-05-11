package dp.pattern.grid_problems;

import java.util.HashMap;
import java.util.Map;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        System.out.println(uniquePaths(m, n));
    }

    public static int uniquePaths(int m, int n) {
        System.out.println(bruteForce(0, 0, m, n));
        System.out.println(memoization(0, 0, m, n, new HashMap<>()));
        System.out.println(memoizationWithArray(0, 0, m, n, new int[m][n]));
        return dp(m, n);
    }


    private static int bruteForce(int row, int col, int m, int n) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }

        // go right
        int option1 = bruteForce(row, col + 1, m, n);
        // go down
        int option2 = bruteForce(row + 1, col, m, n);

        return option1 + option2;
    }

    private static int memoization(int row, int col, int m, int n, Map<String, Integer> cache) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }

        if (cache.containsKey(row + ":" + col)) {
            return cache.get(row + ":" + col);
        }

        // go right
        int option1 = memoization(row, col + 1, m, n, cache);
        // go down
        int option2 = memoization(row + 1, col, m, n, cache);
        cache.put(row + ":" + col, option1 + option2);
        return option1 + option2;
    }

    private static int memoizationWithArray(int row, int col, int m, int n, int[][] cache) {
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (row >= m || col >= n) {
            return 0;
        }

        if (cache[row][col] > 0) {
            return cache[row][col];
        }

        // go right
        int option1 = memoizationWithArray(row, col + 1, m, n, cache);
        // go down
        int option2 = memoizationWithArray(row + 1, col, m, n, cache);
        cache[row][col] = option1 + option2;
        return option1 + option2;
    }


    private static int dp(int m, int n) {
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // to move along the boundary unique ways is 1
                if (row == 0 || col == 0) {
                    dp[row][col] = 1;
                } else {
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
