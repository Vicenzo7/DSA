package binarysearch;

public class SearchIn2DMatrixII {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(searchMatrix(matrix, target));
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        // start from the last row and first column
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            // check if matrix[row][col] is a target
            if (matrix[row][col] == target) {
                return true;
            }

            // now since matrix[row][col] is not a target, we need to check if target in this row or previous row
            // check if the target is less than the last row first element,if true
            // discard that row as target doest lie in that row as the row's first element is
            // smallest, if target is smaller than the smallest then its obvious it doesn't lie in that row
            if (target < matrix[row][col]) {
                row--;
            } else { // the target lies in that row so increment the col.
                col++;
            }
        }
        return false;
    }
}
