package binarysearch.twoDAraay;

import java.util.Arrays;
import java.util.List;

public class MedianInARowWiseSortedMatrix {
    public static void main(String[] args) {
        int r = 3, c = 3;
        int[][] matrix = {{1, 3, 5},
                {2, 6, 9},
                {3, 6, 9}};

        System.out.println(median(matrix, r, c));
        System.out.println(medianOptimised(matrix, r, c));
    }

    public static int median(int[][] matrix, int r, int c) {
        // code here
        List<Integer> list = Arrays.stream(matrix)
                .flatMapToInt(Arrays::stream)
                .boxed()
                .sorted()
                .toList();

        return list.get(list.size() / 2);
    }


   /*
    An efficient approach for this problem is to use a binary search algorithm.
    The idea is that for a number to be median there should be exactly (n/2) numbers that are less than this number.
    So, we try to find the count of numbers less than all the numbers.


    Now our search space is between minimum element and maximum element of the 2D array.
    minimum and maximum can be easily found since the row are sorted
    we find the minimum and maximum elements in the matrix. The minimum element can be easily found by comparing the first
    element of each row, and similarly, the maximum element can be found by comparing the last element of each row.

    But let's increase our search space according to the constraints
    low = 0 and high = 1_000_000_000 and calculate the mid

    Now count how many elements are less than mid --> this counting can be done by binarySearch upperBound
    Logic if mid <= target(mid-searchSpace)
    we need to find a point that is greater than mid,so we move forward - low = mid+1
    else high = mid -1
    return low

    if count <= (m*n) /2
    low = mid +1
    else high =  mid -1

    finally our answer will be stored in low
    */

    public static int medianOptimised(int[][] matrix, int r, int c) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        // finding our search space
        for (int i = 0; i < r; i++) {
            if (matrix[i][0] < min) {
                min = matrix[i][0];
            }

            if (matrix[i][c - 1] > max) {
                max = matrix[i][c - 1];
            }
        }
        // assigning our search space
        int low = min, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            for (int i = 0; i < r; i++) {
                count += countNumberLessThanMidEqualToMid(matrix[i], mid);
            }
            // checking if mid can be a possible median
            if (count <= (r * c) / 2) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }

    private static int countNumberLessThanMidEqualToMid(int[] row, int target) {
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // if mid is <= to target we forward towards a break point where element is greater than target
            if (row[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
}
