package dp.twodimension;

public class LongestIncreasingPathInAMatrix {

    public static void main(String[] args) {
        int[][] matrix = {
                {9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}
        };

        System.out.println(longestIncreasingPath(matrix));
    }


    static int ROWS;
    static int COLS;

    public static int longestIncreasingPath(int[][] matrix) {
        ROWS = matrix.length;
        COLS = matrix[0].length;

        int[][] cache = new int[ROWS][COLS];

        int count = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
//                int ans = bruteForce(row, col, matrix, Integer.MIN_VALUE);
                int ans = dp(row, col, matrix, Integer.MIN_VALUE, cache);
                count = Math.max(ans, count);
            }
        }
        return count;
    }


    private static int bruteForce(int row, int col, int[][] matrix, int previousValue) {

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || matrix[row][col] <= previousValue) {
            return 0;
        }

        int count = 1;
        int left = bruteForce(row, col - 1, matrix, matrix[row][col]);
        int right = bruteForce(row, col + 1, matrix, matrix[row][col]);
        int up = bruteForce(row - 1, col, matrix, matrix[row][col]);
        int down = bruteForce(row + 1, col, matrix, matrix[row][col]);

        return count + Math.max(left, Math.max(right, Math.max(up, down)));
    }

    // TC = O(m.n) SC = O(m.n)

    private static int dp(int row, int col, int[][] matrix, int previousValue, int[][] cache) {

        if (Math.min(row, col) < 0 || row == ROWS || col == COLS || matrix[row][col] <= previousValue) {
            return 0;
        }

        if (cache[row][col] != 0) {
            return cache[row][col];
        }

        int count = 1;
        int left = dp(row, col - 1, matrix, matrix[row][col], cache);
        int right = dp(row, col + 1, matrix, matrix[row][col], cache);
        int up = dp(row - 1, col, matrix, matrix[row][col], cache);
        int down = dp(row + 1, col, matrix, matrix[row][col], cache);


        cache[row][col] = count + Math.max(left, Math.max(right, Math.max(up, down)));
        return cache[row][col];
    }
}
