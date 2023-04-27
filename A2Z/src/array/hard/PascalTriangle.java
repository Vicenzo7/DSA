package array.hard;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 5;
        System.out.println(generate(numRows));

    }

    /*Intuition: When you see the image above, you get a pretty good idea of what you are supposed to do here.
    Think about the image as a matrix now where each line is basically a row in the matrix. So, first things first,
    if you are at the edge of the matrix, the value is 1, that’s for sure.
    Now, what about the inner elements? Well, any inner element is obtained by doing the sum of the 2 values present
    in the row just above it, i.e., if the element is at index (i, j), then matrix[i][j] can be obtained
    by doing matrix[i – 1][j – 1] + matrix[i – 1][j].

    Approach: To solve the problem, we need to first create an array of size N or numRows (input value).
    This array is used to store each of the rows expected in the output, so, for example, array[1] = [1,1].
    In this array, the number of columns (say, numCols) is equal to the number of the i-th row + 1 (Since, 0-indexed)
    , i.e., for 0-th row, numCols = 1. So, the number of columns is different for each row.

    Next, we need to run a loop from i = 0 to numRows – 1 (inclusive) in order to store each row in our array.
    For each of iteration of this loop, we follow the below steps:

    Create an array of size (i + 1) (For some languages such as C++, you need to create a 2D array at the start of the program and resize array[i] to (i + 1)).
    Set the first and last value of array[i] to 1.
    Run another loop from j = 1 to i – 1 (inclusive) and for each iteration
    put array[i][j] = array[i – 1][j – 1] + array[i – 1][j].
    After iterating numRows times, you return the array.

    Time Complexity: We are creating a 2D array of size (numRows * numCols) (where 1 <= numCols <= numRows),
    and we are traversing through each of the cells to update it with its correct value,
    so Time Complexity = O(numRows^2).

    Space Complexity: Since we are creating a 2D array, space complexity = O(numRows2).

    */

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> row, previousRow = null;

        for (int i = 0; i < numRows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    row.add(1);
                } else {
                    row.add(previousRow.get(j-1) + previousRow.get(j));
                }
            }
            previousRow = row;
            result.add(row);
        }
        return result;
    }
}
