package binarysearch.oneDArray;

public class RowWithMax1s {
    public static void main(String[] args) {
//        int[][] matrix = {{0, 1, 1, 1},
//                {0, 0, 1, 1},
//                {1, 1, 1, 1},
//                {0, 0, 0, 0}};

        int[][] matrix = {{0, 0},
                {0, 0}};

        System.out.println(rowWithMax1s(matrix));
        System.out.println(rowWithMax1sOptimal(matrix));

    }

    /*
        Brute Force
        The simplest approach is to iterate each row and keep count of number of 1's in that row
        Once the count is found, and it's greater than the maxCount the update our answer with that row index

        TC = O(n*m) where n is no of rows and m is no of columns.
        SC = O(1)

    */

    public static int rowWithMax1s(int[][] matrix) {
        // code here
        int max = 0;
        int max1Row = 0;
        for (int i = 0; i < matrix.length; i++) {
            int count = 0;
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 1) {
                    count++;
                }
            }
            if (count > max) {
                max = count;
                max1Row = i;
            }

        }
        return max1Row;
    }

    /*
        Optimal approach - Binary Search
        Since each row is sorted we can find the first occurrence of 1 if we get that we can calculate the no.of 1's in
        that row,

        Step1 : if element at mid is 1 and element at mid-1 is zero that means mid is starting index of 1
        step2 : If element at mid is 0 we move our search space from mid+1 to high
        step3 : If element at mid is 1 we move our search space from low to mid -1
        step4 if not found we return -1

        We do this for each row and then calculate the numbers of 1 in that row;

        TC = O(nlog(n))
        Reason Binary Search takes TC of O(log(n)) and we are applying binary search for n rows
        SC = O(1)ones
    */


    public static int rowWithMax1sOptimal(int[][] matrix) {
        int result = -1;
        int maxCount = 0;
        int index = 0;
        for (int[] row : matrix) {
            int startIndex = binarySearch(row, 0, row.length - 1);
            if (startIndex != -1) {
                int onesCount = row.length - startIndex;
                if (onesCount > maxCount) {
                    maxCount = onesCount;
                    result = index;
                }
            }
            index++;
        }
        return result;
    }

    private static int binarySearch(int[] row, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if ((mid == 0 || row[mid - 1] == 0) && row[mid] == 1) {
                return mid;
            } else if (row[mid] == 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

}
