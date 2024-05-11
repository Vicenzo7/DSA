package dp.pattern.grid_problems;

import java.util.HashMap;
import java.util.Map;

public class MinimumPathSum {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };

//        int[][] grid = {
//                {1, 2},
//                {1, 1},
//        };
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        System.out.println(bruteForce(0, 0, grid));
        System.out.println(memoization(0, 0, grid, new HashMap<>()));

        return dp(grid);
    }

    private static int dp(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = grid[row][col];
                } else if (row == 0) {
                    dp[row][col] = grid[row][col] + dp[row][col - 1];
                } else if (col == 0) {
                    dp[row][col] = grid[row][col] + dp[row - 1][col];
                } else {
                    dp[row][col] = grid[row][col] + Math.min(dp[row][col - 1], dp[row - 1][col]);
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    private static int memoization(int row, int col, int[][] grid, Map<String, Integer> cache) {
        if (row > grid.length - 1 || col > grid[0].length - 1) {
            return Integer.MAX_VALUE;
        }

        if (cache.containsKey(row + ":" + col)) {
            return cache.get(row + ":" + col);
        }

        // go right
        int option1 = memoization(row, col + 1, grid, cache);
        // go down
        int option2 = memoization(row + 1, col, grid, cache);

        int result;

        if (option1 == Integer.MAX_VALUE && option2 == Integer.MAX_VALUE) {
            result = grid[row][col];
        } else if (option1 != Integer.MAX_VALUE && option2 != Integer.MAX_VALUE) {
            result = grid[row][col] + Math.min(option1, option2);
        } else if (option1 == Integer.MAX_VALUE) {
            result = grid[row][col] + option2;
        } else {
            result = grid[row][col] + option1;
        }

        cache.put(row + ":" + col, result);
        return result;
    }


    /*
        Here's a closer look:

    Out of Bounds Indices:

    When row is greater than or equal to the number of rows in the grid (grid.length - 1) or col is greater than or
    equal to the number of columns in the grid (grid[0].length - 1), it means we're trying to move beyond the grid
    boundaries. At this point, we should not consider this path because it's invalid.

    Why not sending 0?:

    If we send 0 when row or col is out of bounds, it would imply that moving outside the grid has no cost.
    However, this is not the case. In the problem, moving outside the grid is not allowed, so it should not be
    considered as a valid path with a cost of 0. By sending Integer.MAX_VALUE, we effectively indicate that this
    path is not valid and should not be considered in finding the minimum path sum.

    Impact on Path Sum Calculation:

    By returning Integer.MAX_VALUE for out-of-bounds moves, we ensure that these paths are not considered when
    calculating the minimum path sum. This is crucial because it allows us to correctly compute the minimum sum
    of numbers along a valid path from the top-left to the bottom-right of the grid.

    */

    private static int bruteForce(int row, int col, int[][] grid) {
        if (row > grid.length - 1 || col > grid[0].length - 1) {
            return Integer.MAX_VALUE;
        }

        // go right
        int option1 = bruteForce(row, col + 1, grid);
        // go down
        int option2 = bruteForce(row + 1, col, grid);

        if (option1 == Integer.MAX_VALUE && option2 == Integer.MAX_VALUE) {
            return grid[row][col];
        } else if (option1 != Integer.MAX_VALUE && option2 != Integer.MAX_VALUE) {
            return grid[row][col] + Math.min(option1, option2);
        } else if (option1 == Integer.MAX_VALUE) {
            return grid[row][col] + option2;
        }
        return grid[row][col] + option1;
    }
}
