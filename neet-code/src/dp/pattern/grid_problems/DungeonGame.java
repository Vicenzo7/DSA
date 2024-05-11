package dp.pattern.grid_problems;

public class DungeonGame {
    public static void main(String[] args) {
        int[][] dungeon = {
                {-2, -3, 3},
                {-5, -10, 1},
                {10, 30, -5}};

        System.out.println(calculateMinimumHP(dungeon));
    }

    public static int calculateMinimumHP(int[][] dungeon) {
        return dp(dungeon);
    }

    public static int dp(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] dp = new int[m][n];

        // Fill the dp table starting from the bottom-right corner
        for (int i = m - 1; i >= 0; i--) { // Iterate through rows starting from the bottom
            for (int j = n - 1; j >= 0; j--) { // Iterate through columns starting from the right
                if (i == m - 1 && j == n - 1) {
                    // Calculate the minimum health needed for the bottom-right cell
                    // Bottom-right cell should have at least 1 health point remaining
                    dp[i][j] = Math.max(1, 1 - dungeon[i][j]);
                } else if (i == m - 1) {
                    // Calculate the minimum health needed for cells in the last row
                    // Minimum health needed depends on the cell to the right
                    // We are assuming that the knight has reached the cell to the right (i, j + 1)
                    // with at least 1 health point remaining after considering all the cells it has traversed
                    dp[i][j] = Math.max(1, dp[i][j + 1] - dungeon[i][j]);
                } else if (j == n - 1) {
                    // Calculate the minimum health needed for cells in the last column
                    // Minimum health needed depends on the cell below
                    // We are assuming that the knight has reached the cell below (i + 1, j)
                    // with at least 1 health point remaining after considering all the cells it has traversed
                    dp[i][j] = Math.max(1, dp[i + 1][j] - dungeon[i][j]);
                } else {
                    // Calculate the minimum health needed for other cells
                    // Minimum health needed depends on the cells to the right and below
                    // We are assuming that the knight has reached the cells to the right (i, j + 1)
                    // and below (i + 1, j) with at least 1 health point remaining
                    // after considering all the cells it has traversed
                    dp[i][j] = Math.max(1, Math.min(dp[i][j + 1], dp[i + 1][j]) - dungeon[i][j]);
                }
            }
        }

        // Minimum initial health needed is the value of dp[0][0]
        return dp[0][0];
    }
}
