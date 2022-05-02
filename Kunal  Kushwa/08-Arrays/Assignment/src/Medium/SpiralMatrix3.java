package Medium;

import java.util.Arrays;

public class SpiralMatrix3 {
    public static void main(String[] args) {
        int rStart=0,cStart=0;
        int[][] matrix ={
                {1,2,3,4}
        };
        int rows=1,cols=4;
        int[][] result =spiralMatrix3(rows,cols,rStart,cStart);
        for(int[] a:result)
        {
            System.out.println(Arrays.toString(a));
        }
    }

    private static int[][] spiralMatrix3(int rows, int cols, int rStart, int cStart) {
        int[][] matrix = new int[rows*cols][2];
        int i=0;
        matrix[i++] = new int[]{rStart,cStart};
        int len=0;
        int d=0;
        int[] direction = new int[] {0,1,0,-1,0};
        while(i<rows*cols)
        {
            if(d==0 || d==2)
            {
                len++;
            }
            for(int k=0;k<len;k++)
            {
                rStart +=direction[d];
                cStart += direction[d+1];
                if(rStart < rows && rStart>=0 && cStart < cols && cStart>=0)
                {
                    matrix[i++]= new int[]{rStart,cStart};
                }
            }
            d= ++d % 4;
        }

        return matrix;
    }
}
