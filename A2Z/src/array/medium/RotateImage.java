package array.medium;

import java.util.Arrays;

//https://leetcode.com/problems/rotate-image/
public class RotateImage {
    public static void main(String[] args) {
        int[][] matrix = {
                {5, 1, 9, 11},
                {2, 4, 8, 10},
                {13, 3, 6, 7},
                {15, 14, 12, 16}};
//        rotate(matrix);
        rotateOptimal(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*
     *
     * Approach to rotate a matrix my 90 degree
     * Step 1: Find adjacent of the matrix
     * Step 2: Reverse the matrix
     *
     * TC = O(m*n) + O(m*n/2)
     * SC = O(m*n)
     * */

    public static void rotate(int[][] matrix) {
        int[][] result = new int[matrix.length][matrix[0].length];

        // find the adjacent of the given matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                result[row][col] = matrix[col][row];
            }
        }

        // after finding the adjacent reverse the matrix
        for (int[] row : result) {
            reverse(row);
        }
        System.out.println(Arrays.deepToString(result));
    }

    private static void reverse(int[] row) {
        int start = 0, end = row.length - 1;
        while (start < end) {
            int temp = row[start];
            row[start] = row[end];
            row[end] = temp;
            start++;
            end--;
        }
    }

    /*
     *
     * In the above algo we are taking additional space.
     * To reduce the space complexity from O(m*n) to O(1), we will to in place transpose
     *
     * Rest algo remains the same
     *
     * */

    public static void rotateOptimal(int[][] matrix) {
        // find the adjacent of the given matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
        // after finding the adjacent reverse the matrix
        for (int[] row : matrix) {
            reverse(row);
        }
    }

//    https://practice.geeksforgeeks.org/problems/rotate-by-90-degree-1587115621/1

//Reverse Rotate
//    matrix[][] =
//    {{1, 2, 3},
//    {4, 5, 6}
//    {7, 8, 9}}
//    Output:
//    Rotated Matrix:
//            3 6 9
//            2 5 8
//            1 4 7

    public static void rotateBy90(int[][] matrix) {
        // reverse the array
        for (int[] row : matrix) {
            reverse(row);
        }

        // inplace transpose of the matrix
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < row; col++) {
                int temp = matrix[row][col];
                matrix[row][col] = matrix[col][row];
                matrix[col][row] = temp;
            }
        }
    }


}
