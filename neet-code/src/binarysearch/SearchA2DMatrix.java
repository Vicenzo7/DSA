package binarysearch;

public class SearchA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}
        };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));

    }

    /*

        You are given an m x n integer matrix with the following two properties:

        Each row is sorted in non-decreasing order.
        The first integer of each row is greater than the last integer of the previous row.

        Given an integer target, return true if target is in matrix or false otherwise.

        You must write a solution in O(log(m * n)) time complexity.


        Solution
        Since Each row is sorted in non-decreasing order.
        Treat the 2D matrix as 1D matrix


    */


    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length, column = matrix[0].length;
        int start = 0, end = (row - column) - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = matrix[mid / column][mid % column];
            if (result == target) return true;
            else if (result < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }
}
