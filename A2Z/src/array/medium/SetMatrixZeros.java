package array.medium;
//https://leetcode.com/problems/set-matrix-zeroes/description/
import java.util.Arrays;

public class SetMatrixZeros {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}};

        int[][] matrix2 = {{-1}, {2}, {3}};

        int[][] matrix3 = {
                {-1, 1, 1},
                {1, 0, 1},
                {1, 1, -1}};

//        setZeroes(matrix3);
//        setZeroesOptimal1(matrix);
        setZeroesOptimal2(matrix3);
        System.out.println(Arrays.deepToString(matrix3));
    }

    /*
     * Here the TC =O((m*n)(m+n) + (m*n))
     * Reason: Firstly, we are traversing the matrix to find the cells with the value 0.
     * It takes O(N*M). Now, whenever we find any such cell we mark that row and column with -1.
     * This process takes O(N+M). So, combining this the whole process, finding and marking, takes O((N*M)*(N + M)).
     * Another O(N*M) is taken to mark all the cells with -1 as 0 finally.
     * */

    public static void setZeroes(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    setMatrixZero(matrix, i, j);
                }
            }
        }

        // set all -1 to 0
        for (int[] row : matrix) {
            for (int i = 0; i < row.length; i++) {
                if (row[i] == Integer.MAX_VALUE) {
                    row[i] = 0;
                }
            }
        }
    }

    private static void setMatrixZero(int[][] matrix, int row, int col) {
        //row
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] != 0) {
                matrix[i][col] = Integer.MAX_VALUE;
            }
        }
        // col
        for (int i = 0; i < matrix[0].length; i++) {
            if (matrix[row][i] != 0) {
                matrix[row][i] = Integer.MAX_VALUE;
            }
        }
    }

    /*
     * Optimal Approach 1 - using two extra array, row array and column array.
     * First we traverse the array and whenever we encounter zero we mark row[i] = 1 and col[j]= 1.
     * This way we keep a track of row and column which needs to be marked as zero.
     * Later we again traverse the matrix and mark the rows and columns as 0
     *
     * TC = O(2(m*n)) -> we traverse the matrix twice
     * SC = O(m+n)
     * */

    public static void setZeroesOptimal1(int[][] matrix) {
        int[] rows = new int[matrix.length];
        int[] col = new int[matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    rows[i] = 1;
                    col[i] = 1;
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (rows[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /*
     * Complexity of first optimal approach
     * TC = O(m*n)
     * SC = O(m+n) reason row and col array
     *  In the first optimal approach we reduced the TC here we will reduce the SC
     * Instead of taking a separate row and col array, lets keep a track of it inside the matrix itself.
     * Approach
     * 1.First we'll traverse through first row and first column of the matrix(0th row and 0th column).
     * Whenever we find 0 in this row we'll set isrow0 to true.
     * Similarly, whenever we find 0 in this column we'll set iscol0 to true.
     * This will be used later.
     * 2.Now we'll go through the entire matrix(Except the 0th row and 0th column).
     * Whenever 0 is encountered we'll set that row's first column's element to 0.
     * Similarly, we'll set that column's first row's element to 0.
     * 3.After that, we go through the matrix one more time and for any row or column where the first element is zero, we set all the other elements in that row or column to zero as well.
     * 4.lastly, we'll set the entire 0th row and 0th column to zero if isrow0 and iscol0 is true respectively.
     *
     * Intuition
     * Instead of using extra row and col array,we are going to treat 0th row and 0th col as our tracking index array.
     * So before we do that it's better to check if the first column and row contains 0 or not.
     * And then later use is as inplace row array and col array
     *
     * Time complexity:O(m*n)
     * Space complexity:O(1)
     * */


    public static void setZeroesOptimal2(int[][] matrix) {
        int rowLength = matrix.length;
        int colLength = matrix[0].length;
        boolean isRow0 = false, isCol0 = false;

        // check if 0th row contains zero

        for (int i = 0; i < rowLength; i++) {
            if (matrix[i][0] == 0) {
                isRow0 = true;
                break;
            }
        }
        // check if 0th col contains zero
        for (int i = 0; i < colLength; i++) {
            if (matrix[0][i] == 0) {
                isCol0 = true;
                break;
            }
        }

        // now treat the Oth row and col as row array to keep track of the index which needs to be turned zero
        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][j] == 0) {
                    // mark the index in inplace Matrix row and col array
                    matrix[0][j] = 0; // col index marking
                    matrix[i][0] = 0; // row index marking;
                }
            }
        }

        for (int i = 1; i < rowLength; i++) {
            for (int j = 1; j < colLength; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        // After this is the 0th row or col might have contained 0 this info is stored in isRow0 and isCol0
        if (isRow0) {
            for (int i = 0; i < rowLength; i++) {
                matrix[i][0] = 0;
            }
        }
        if (isCol0) {
            for (int i = 0; i < colLength; i++) {
                matrix[0][i] = 0;
            }
        }
    }


}
