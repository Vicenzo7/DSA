package binarysearch.twoDAraay;

import java.util.Arrays;

public class SearchInA2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 60}};
        int target = 30;

        System.out.println(bruteForce(matrix, target));
        System.out.println(searchMatrix(matrix, target));
        System.out.println(searchMatrix2(matrix, target));
    }

    /*
        Brute Force
        Traverse the entire matrix and check if element exist
        TC = O(n*m) where n is no. of rows and m is no. of columns

    */

    public static boolean bruteForce(int[][] matrix, int target) {
        for (int[] row : matrix) {
            for (int element : row) {
                if (element == target) return true;
            }
        }
        return false;
    }


    /*
        Optimal Solution
        TC = O(n * log(m))

    */

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (int[] row : matrix) {
            if (row[0] == target) return true;
            else if (row[row.length - 1] == target) return true;
            if (row[0] < target && target < row[row.length - 1]) {
                int ans = Arrays.binarySearch(row, target);
                return ans > 0;
            }
        }
        return false;
    }

    /*
        More Optimised : TC O(log(n*m))
        This complexity can be achieved when we treat the 2D matrix as 1D matrix
        and binarySearch on 1D matrix is O(log(n)) where n is number of elements.

        So here no of elements is n*m.
        Question is if we have 2D matrix, and we want to treat it as 1D matrix
        how we access the elements without 2 loops

        Answer
        row = matrix.length , column = matrix[0].length
        let low = 0 and high = row * column

        apply binary search and find out the mid,
        now element at mid is element = matrix[mid/column][mid%column]
        check element == target, if true return true or
        check if element < target , low = mid +1,
        else high = mid -1;
    */

    public static boolean searchMatrix2(int[][] matrix, int target) {
        if (matrix.length == 0) return false;

        int rows = matrix.length;
        int columns = matrix[0].length;

        int low = 0;
        int high = (rows * columns) - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int element = matrix[mid / columns][mid % columns];
            if (element == target)
                return true;
            else if (element < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false;
    }
}
