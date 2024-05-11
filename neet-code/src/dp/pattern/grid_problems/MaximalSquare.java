package dp.pattern.grid_problems;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {{'1', '0', '1', '0', '0' },
                {'1', '0', '1', '1', '1' },
                {'1', '1', '1', '1', '1' },
                {'1', '0', '0', '1', '0' }};

        System.out.println(maximalSquare(matrix));
    }

    public static int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];

        int side = 0;

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (matrix[row][col] == '1') {
                    // if the square is on the boundary it's single square of size 1
                    if (row == 0 || col == 0) {
                        dp[row][col] = 1;
                    } else {
                        // check if the current cell can form cel with
                        // neighbours(top,left,diagonal)
                        int top = dp[row - 1][col];
                        int left = dp[row][col - 1];
                        int diagonal = dp[row - 1][col - 1];
                        // Size of the largest square sub matrix ending at the current cell is 1 +
                        // minimum size of it's neighbours square
                        dp[row][col] = Math.min(top, Math.min(left, diagonal)) + 1;
                    }

                    side = Math.max(side, dp[row][col]);
                }
            }
        }

        return side * side;
    }
}
