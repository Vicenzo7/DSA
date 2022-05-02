
package Easy;
import java.util.Arrays;

public class ReshapetheMatrix {
    public static void main(String[] args) {
        int[][] mat ={
                {1,2},
                {3,4}
        };
        int r=1,c=4;
        int[][] result = matrixReshape(mat,r,c);
        System.out.println();
        for(int[] i:result)
        {
            System.out.println(Arrays.toString(i));
        }

    }

    private static int[][] matrixReshape(int[][] mat, int r, int c) {

        int m=mat.length;
        int n =mat[0].length;
        int[]  oneD = new int[m*n];
        int[][] ans = new int[r][c];
        int[][] empty = new int[0][];// if we return this 2D array it will print "[]" this represents empty;


       if(m*n == r*c)
       {
           for (int i = 0; i < m ; i++) {
               for (int j = 0; j < n ; j++) {
                   oneD[n*i+j]= mat[i][j];
               }
           }
           for(int i:oneD)
           {
               System.out.print(i+" ");
           }
           for (int i = 0; i < r*c; i++) {
               ans[i/c][i%c]= oneD[i];
           }

           System.out.println();
           for(int[] i:ans)
           {
               System.out.print(Arrays.toString(i));
           }

           return ans;
       }


        return mat;
    }

}

