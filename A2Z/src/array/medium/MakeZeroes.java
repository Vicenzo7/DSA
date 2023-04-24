package array.medium;
//https://practice.geeksforgeeks.org/problems/make-zeroes4042/1

import java.util.Arrays;

public class MakeZeroes {

    public static void main(String[] args) {
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 0, 7},
                {8, 9, 4, 6},
                {8, 4, 5, 2}};

        makeZeros(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    /*
     * TC = O(2(m*n))  because we are traversing the array twice
     * SC = O(m*n)
     *
     * Approach
     * Declare a tempArray whose size is equal to the given matrix
     * Traverse the matrix and when we encounter a 0, take a variable sum = 0;
     * then check the left,right,up and down element exist for that element which is 0
     * If exist add them to sum and mark the left,right,up and down element to -1 in the tempArray,
     * after store the sum where element was zero.
     *
     * After the traversal is complete,traverse the tempMatrix and when we find an element == -1, in the
     * given matrix update that element to zero,
     * if it's not -1 and greater than zero, in the given matrix update that element to the element present in tempArray.
     *
     * */


    public static void makeZeros(int[][] matrix) {
        int[][] mat = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == 0) {
                    int sum = 0;
                    if (row > 0) {
                        sum += matrix[row - 1][col];
                        mat[row - 1][col] = -1;
                    }
                    if (row < matrix.length - 1) {
                        sum += matrix[row + 1][col];
                        mat[row + 1][col] = -1;
                    }
                    if (col > 0) {
                        sum += matrix[row][col - 1];
                        mat[row][col - 1] = -1;
                    }
                    if (col < matrix.length - 1) {
                        sum += matrix[row][col + 1];
                        mat[row][col + 1] = -1;
                    }
                    mat[row][col] = sum;
                }
            }
        }

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (mat[row][col] == -1) {
                    matrix[row][col] = 0;
                }
                if (mat[row][col] > 0) {
                    matrix[row][col] = mat[row][col];
                }
            }
        }
    }
}
