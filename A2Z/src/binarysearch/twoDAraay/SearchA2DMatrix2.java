package binarysearch.twoDAraay;

import java.util.Arrays;

public class SearchA2DMatrix2 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}};

        int target = 5;
        System.out.println(searchMatrix(matrix,target));
        System.out.println(searchMatrix2(matrix,target));
    }

    /*
        TC of below code
        TC = O(m * log(n)) , where m is no. of rows and m is no. of columns.
        Reason we are iterating every row and applying binarySearch to that row of length n
    */

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] <= target && target <= row[row.length - 1]) {
                int ans = Arrays.binarySearch(row, target);
                if (ans >= 0) {
                    return true;
                }
            }
        }
        return false;
    }


    /*
        We need to improve the TC because we are provide with info
        Every row and col is sorted respectively

        Intuition
        Since it is given that array is sorted in non-increasing order both row-wise and column-wise,
        we wil start the traversal from the last row's first element.

        3 cases can occur:
        Case 1: when the current element is greater than the target,
        then the whole row will be of greater numbers than target since it's the smallest in the row, so discard the row

        Case 2 :
        when the current element is smaller than the target,
        then move to the next column since it is column wise sorted the target might lie in the next column

        Case 3: When the current elements is equal to the target,return true

        Approach
        Complexity
        Time complexity:O(log n)

    */

    public static boolean searchMatrix2(int[][] matrix, int target) {
        int row = matrix.length -1, col = 0;
        // start from last row first element
        while(row < matrix.length && col < matrix[0].length) {
            // check if target found
            if(matrix[row][col] == target) {
                return true;
            }

            // check if the target is less than the last row first element,if true
            // discard that row as target doest lie in that row as the row's first element is
            // smallest, if target is smaller than the smallest then its obvious it doesn't lie in that row
            if(row != 0 && target < matrix[row][col]) {
                row--;
            } else { // the target lies in that row so increment the col.
                col++;
            }
        }
        return false;
    }
}
