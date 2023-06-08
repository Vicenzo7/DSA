package binarysearch.twoDAraay;

import java.util.Arrays;

public class FindAPeakElementII {
    public static void main(String[] args) {
        int[][] matrix = {{1, 4}, {3, 2}};

        System.out.println(Arrays.toString(findPeakGrid(matrix)));
    }


    public static int[] findPeakGrid(int[][] matrix) {
        int rowIndex = 0;
        for (int[] row : matrix) {
            int ans = binarySearch(row);
            if (ans != -1) return new int[]{rowIndex, ans};
            rowIndex++;
        }

        return new int[]{-1, -1};
    }

    private static int binarySearch(int[] row) {
        int n = row.length - 1;
        int low = 0, high = row.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (mid == 0)
                return row[0] > row[1] ? 0 : 1;

            if (mid == n - 1)
                return row[n - 1] > row[n - 2] ? n - 1 : n - 2;

            if (row[mid] > row[mid - 1] && row[mid] > row[mid + 1]) {
                return mid;
            } else if (row[low] > row[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;

    }
}
