package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix = {
                {0,1,2,0},
                {3,4,5,2},
                {1,3,1,5}
        };

//        int m = matrix.length;
//        int n = matrix[0].length;

        //first approach
//        int[] rows =new int[m];
//        int[] cols = new int[n];
//
//        for (int i = 0; i < m ; i++) {
//            for (int j = 0; j <n ; j++) {
//                if(matrix[i][j] == 0)
//                {
//                    rows[i] =1;
//                    cols[j] =1;
//                }
//            }
//        }
//
//        for (int i = 0; i <m ; i++) {
//            if (rows[i]==1)
//            {
//                for (int j = 0; j < n ; j++) {
//                    matrix[i][j]=0;
//                }
//            }
//        }
//
//        for (int i = 0; i <n ; i++) {
//            if (cols[i]==1)
//            {
//                for (int j = 0; j < rSize ; j++) {
//                    matrix[j][i]=0;
//                }
//            }
//        }
        //First approach with List
//        List<Integer> rows = new ArrayList<>();
//        List<Integer> cols = new ArrayList<>();
//
//
//        for (int i = 0; i < m ; i++) {
//            for (int j = 0; j <n ; j++) {
//                if(matrix[i][j] == 0)
//                {
//                    rows.add(i);
//                    cols.add(j);
//                }
//            }
//        }
//
//        for (int i = 0; i < m ; i++) {
//            for (int j = 0; j <n ; j++) {
//                if(rows.contains(i) || cols.contains(j) )
//                {
//                    matrix[i][j]=0;
//                }
//            }
//        }

        //The best Optimal approach
        Boolean isCol = false;
        int R = matrix.length;
        int C = matrix[0].length;

        for (int i = 0; i < R; i++) {

            // Since first cell for both first row and first column is the same i.e. matrix[0][0]
            // We can use an additional variable for either the first row/column.
            // For this solution we are using an additional variable for the first column
            // and using matrix[0][0] for the first row.
            if (matrix[i][0] == 0) {
                isCol = true;
            }

            for (int j = 1; j < C; j++) {
                // If an element is zero, we set the first element of the corresponding row and column to 0
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // Iterate over the array once again and using the first row and first column, update the elements.
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        // See if the first row needs to be set to zero as well
        if (matrix[0][0] == 0) {
            for (int j = 0; j < C; j++) {
                matrix[0][j] = 0;
            }
        }

        // See if the first column needs to be set to zero as well
        if (isCol) {
            for (int i = 0; i < R; i++) {
                matrix[i][0] = 0;
            }
        }


        for(int[] a:matrix)
        {
            System.out.println(Arrays.toString(a));
        }

    }
}
