package binarysearch.twoDAraay;

import java.util.Arrays;

public class FindAPeakElementII {
    public static void main(String[] args) {
//        int[][] matrix = {{4, 2, 5, 1, 4, 5},
//                {2, 9, 3, 2, 3, 2},
//                {1, 7, 6, 0, 1, 3},
//                {3, 6, 2, 3, 7, 2}};

        int[][] matrix = {{1, 2, 3, 4, 5, 6, 7, 8},
                          {2, 3, 4, 5, 6, 7, 8, 9},
                         {3, 4, 5, 6, 7, 8, 9, 10},
                         {4, 5, 6, 7, 8, 9, 10, 11}};

        System.out.println(Arrays.toString(findPeakGrid(matrix)));
        System.out.println(Arrays.toString(findPeakGrid2(matrix)));
    }

   /* Logic:
    For given matrix[M][N], create a new 1D array maxPlaneOfCol[N] which stores the largest number in each column.

    image
    int[][] matrix = {{4, 2, 5, 1, 4, 5},
                     {2, 9, 3, 2, 3, 2},
                     {1, 7, 6, 0, 1, 3},
                     {3, 6, 2, 3, 7, 2}};


    For the above matrix, maxPlaneOfCol = {4, 9, 6, 3, 7, 5}
    Let maxPlaneOfCol[i] represent a height of the plane at index i
            image

    Now we have reduced the 2D problem to a 1D problem. Using the same logic as in Solution-Find-Peak-Element, we can find the column that has the peak plane. Remember, the elements in maxPlaneOfCol represent the largest number of each column. If we find a peak plane at index 'p', then it means that there is an element in column# p which is bigger than all the elments in column# p-1 and column# p+1. Once we have the peak column p, we can easily find the row# of the peak element in the column# p. Now you have both row# and col# of a peak element in 2D array. Thats it !!

    BUT!! BUT!! BUT!!

    To populate maxPlaneOfCol[N], we need to traverse all the columns in the 2D array, which basically means that we have to read all the elements in 2D array. So, when you are reading the entire 2D array, why not just return the coordinates of the largest number in the 2D array ?!! The largest element is gauranteed to be a peak element, isn't it !!??

    HOLD ON 🤔🤔🤔

    Do we really need to find the max in each and every column? Will it not be sufficent to just find the max of the midColumn ? If we find the max of only the midColumn, we will calculate max of only log(N) columns in our entire algorithm.
    Hence the Time Complexity is M*log(N). Below is the prettiest code I could come up with.*/


    public static int[] findPeakGrid(int[][] matrix) {
        int startCol = 0, endCol = matrix[0].length - 1;

        while (startCol <= endCol) {
            int maxRow = 0, midCol = startCol + (endCol - startCol) / 2;

            for (int row = 0; row < matrix.length; row++) {
                maxRow = matrix[row][midCol] >= matrix[maxRow][midCol] ? row : maxRow;
            }

            boolean leftIsBig = midCol - 1 >= startCol && matrix[maxRow][midCol - 1] > matrix[maxRow][midCol];
            boolean rightIsBig = midCol + 1 <= endCol && matrix[maxRow][midCol + 1] > matrix[maxRow][midCol];

            if (!leftIsBig && !rightIsBig)   // we have found the peak element
                return new int[]{maxRow, midCol};

            else if (rightIsBig)  // if rightIsBig, then there is an element in 'right' that is bigger than all the elements in the 'midCol',
                startCol = midCol + 1; //so 'midCol' cannot have a 'peakPlane'

            else // leftIsBig
                endCol = midCol - 1;
        }
        return null;
    }

    /*

    Above Logic in my own word

    The idea is simple. we will apply binary search to column space.
    After calculating the midCol, in that column we will find a row which contains the greatest element.
    We do this because the greatest in the column means any element above or below it will be smaller. So no need to check for top and bottom condition.

    After we get maxRow now check if element at matrix[maxRow][midCol] has a greater element to its right or left.

    If it doesn't have the ans is {maxRow,midCol}

    else if it has right side big go towards the right, or else go towards the left.
    */


    public static int[] findPeakGrid2(int[][] mat) {
        // apply binarySearch on column space
        int startCol = 0, endCol = mat[0].length - 1;

        while (startCol <= endCol) {
            int maxRow = 0, midCol = startCol + (endCol - startCol) / 2;
            // find the row which has the greatest element in midCol.
            // we do this so or top and bottom check gets avoided.
            for (int row = 0; row < mat.length; row++) {
                maxRow = mat[row][midCol] >= mat[maxRow][midCol] ? row : maxRow;
            }

            // now check if that element has a greater element on its left or right
            boolean isLeftBig = midCol - 1 >= startCol && mat[maxRow][midCol - 1] > mat[maxRow][midCol];
            boolean isRightBig = midCol + 1 <= endCol && mat[maxRow][midCol + 1] > mat[maxRow][midCol];

            // if left and right are not big , the ans is maxRow,midCol
            if (!isLeftBig && !isRightBig) {
                return new int[]{maxRow, midCol};
            }

            if (isLeftBig) { // if left is big move towards the left to find the peak element
                endCol = midCol - 1;
            } else {
                startCol = midCol + 1; //if right is big move towards the right to find the peak element
            }
        }
        return null;
    }


}
