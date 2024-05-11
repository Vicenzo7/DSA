package dp.pattern.grid_problems;

public class CountSquareSubMatricesWithAllOnes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}
        };

        System.out.println(countSquares(matrix));
    }


    public static int countSquares(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int[][] dp = new int[m][n];
        int count = 0;
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == 1) {
                    // If the square is on the boundary, it's a single square of size 1
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else { // Check if the current cell can form a square with its neighbors
                        // min(top,left,diagonal
                        int top = dp[row - 1][col];
                        int left = dp[row][col - 1];
                        int diagonal = dp[row - 1][col - 1];
                        // Size of the largest square submatrix ending at the current cell is 1 plus the minimum of the sizes of its neighbors
                        dp[row][col] = Math.min(top, Math.min(left, diagonal)) + 1;
                    }
                    count += dp[row][col];
                }
            }
        }
        return count;
    }
}
