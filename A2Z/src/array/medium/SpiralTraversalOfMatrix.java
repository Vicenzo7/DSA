package array.medium;

import java.util.ArrayList;
import java.util.List;

public class SpiralTraversalOfMatrix {
    public static void main(String[] args) {
        //Matrix initialization.
        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};

        int[][] matrix1 = {{1,2,3}};
        System.out.println(spiralOrderTraversal(matrix1));
    }

    /*
    * Approach
    * In this approach, we will be using four loops to print all four sides of the matrix.
    * 1st loop: This will print the elements from left to right.
    * 2nd loop: This will print the elements from top to bottom.
    * 3rd loop: This will print the elements from right to left.
    * 4th loop: This will print the elements from bottom to top.
    *
    * Note: As we can see in the code snippet below, two edge conditions are being added in the last two ‘for’ loops:
    * when we are moving from right to left and from bottom to top.
    * These conditions are added to check if the matrix is a single column or a single row.
    * So, whenever the elements in a single row are traversed they cannot be traversed again backward
    * so the condition is checked in the right-to-left loop.
    * When a single column is present, the condition is checked in the bottom-to-top loop as elements from
    * bottom to top cannot be traversed again.
    *
    * Time Complexity: O(m x n) { Since all the elements are being traversed once and there are total
    * n x m elements ( m elements in each row and total n rows) so the time complexity will be O(n x m)}.
    * Space Complexity: O(n) { Extra Space used for storing traversal in the ans array }.
    *
    * */

    public static List<Integer> spiralOrderTraversal(int[][] matrix) {
        int top = 0;
        int right = matrix[0].length - 1;
        int bottom = matrix.length - 1;
        int left = 0;

        List<Integer> result = new ArrayList<>();

        while (top <= bottom && left <= right) {
            // left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++;

            // top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--;

            // right to left
            // if condition here is used to check if it's not a single row matrix
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--;
            }
            // bottom to top
            // if condition is used here to check if it's not a single col matrix
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++;
            }

        }
        return result;
    }
}
