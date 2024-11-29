package dp.twodimension.batchII;

public class UniquePathII {
    public static void main(String[] args) {
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(uniquePathsWithObstacles(obstacleGrid));
    }

    static
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        // int m = obstacleGrid.length;
        // int n = obstacleGrid[0].length;
        // return dfs(0, 0, m, n, obstacleGrid, new Integer[m + 1][n + 1]);

        return dp(obstacleGrid);
    }

    static
    public int dfs(int row, int col, int m, int n, int[][] obstacleGrid, Integer[][] cache) {
        // if out of bound
        if (row >= m || col >= n) {
            return 0;
        }

        // found obstacle
        if (obstacleGrid[row][col] == 1) {
            return 0;
        }

        // if reached the end
        if (row == m - 1 && col == n - 1) {
            return 1;
        }

        if (cache[row][col] != null) {
            return cache[row][col];
        }

        // go down
        int option1 = dfs(row + 1, col, m, n, obstacleGrid, cache);
        // go right
        int option2 = dfs(row, col + 1, m, n, obstacleGrid, cache);
        return cache[row][col] = option1 + option2;
    }


    static
    public int dp(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] cache = new int[m + 1][n + 1];

        if (obstacleGrid[0][0] == 1) {
            return 0;
        }

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                // check for obstacle
                if (obstacleGrid[row][col] == 1) {
                    cache[row][col] = 0;
                } else if (row == 0 && col == 0) {
                    // to move along the boundaries the total unique ways is 1
                    cache[row][col] = 1;
                } else if (row == 0) {
                    cache[row][col] = cache[row][col - 1];
                } else if (col == 0) {
                    cache[row][col] = cache[row - 1][col];
                } else {
                    cache[row][col] = cache[row - 1][col] + cache[row][col - 1];
                }
            }
        }

        return cache[m - 1][n - 1];
    }
}
