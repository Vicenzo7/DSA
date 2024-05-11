package dp.pattern.grid_problems;

import java.util.HashMap;

public class UniquePathsII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };

//        int[][] obstacleGrid = {
//                {0, 0},
//                {1, 1},
//                {0, 0}
//        };

//        int[][] obstacleGrid = {
//                {1, 0},
//        };
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        System.out.println(bruteForce(0, 0, obstacleGrid));
        System.out.println(memoization(0, 0, obstacleGrid, new HashMap<>()));
        System.out.println(memoizationWithArray(0, 0, obstacleGrid, new int[obstacleGrid.length][obstacleGrid[0].length]));
        return dp(obstacleGrid);
    }


    private static int bruteForce(int row, int col, int[][] obstacleGrid) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return 1;
        }

        // go right
        int option1 = bruteForce(row, col + 1, obstacleGrid);
        // go down
        int option2 = bruteForce(row + 1, col, obstacleGrid);

        return option1 + option2;
    }


    private static int memoization(int row, int col, int[][] obstacleGrid, HashMap<String, Integer> cache) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return 1;
        }

        if (cache.containsKey(row + ":" + col)) {
            return cache.get(row + ":" + col);
        }

        // go right
        int option1 = memoization(row, col + 1, obstacleGrid, cache);
        // go down
        int option2 = memoization(row + 1, col, obstacleGrid, cache);

        int result = option1 + option2;
        cache.put(row + ":" + col, result);
        return result;
    }

    private static int memoizationWithArray(int row, int col, int[][] obstacleGrid, int[][] cache) {
        if (row >= obstacleGrid.length || col >= obstacleGrid[0].length) {
            return 0;
        }

        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        if (row == obstacleGrid.length - 1 && col == obstacleGrid[0].length - 1) {
            return 1;
        }

        if (cache[row][col] > 0) {
            return cache[row][col];
        }

        // go right
        int option1 = memoizationWithArray(row, col + 1, obstacleGrid, cache);
        // go down
        int option2 = memoizationWithArray(row + 1, col, obstacleGrid, cache);

        int result = option1 + option2;
        cache[row][col] = result;

        return result;
    }

    private static int dp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {

//                if (obstacleGrid[row][col] == 1) {
//                    // set the number of ways to zero if there's an obstacle
//                    dp[row][col] = 0;
//                } else if (row == 0 && col == 0) {
//                    // to move along the boundaries the unique ways are 1
//                    dp[row][col] = 1;
//                } else if (row == 0) {
//                    // handle first row
//                    dp[row][col] = dp[row][col - 1];
//                } else if (col == 0) {
//                    // handle first col
//                    dp[row][col] = dp[row - 1][col];
//                } else {
//                    // general case;
//                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
//                }

                if (obstacleGrid[row][col] == 1) {
                    // set the number of ways to zero if there's an obstacle
                    dp[row][col] = 0;
                } else if (row == 0 && col == 0) {
                    // to move along the boundaries the unique ways are 1
                    dp[row][col] = 1;
                } else if (row == 0 || col == 0) {
                    // handle first row
                    dp[row][col] = 1;
                } else {
                    // general case;
                    dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }
}
