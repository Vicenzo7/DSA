package Medium;

import java.util.Arrays;

public class SpiralMatrix2 {
    public static void main(String[] args) {
        int n=4;
        int[][] result =generateMatrix(n);
        for(int[] num:result)
        {
            System.out.println(Arrays.toString(num));
        }
    }


    private static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        if(n==1)
        {
            matrix[0][0]=1;
            return matrix;
        }

        int rowBegin=0;
        int rowEnd= n-1;
        int colBegin= 0;
        int colEnd= n-1;
        int insert=1;


        while(rowBegin<= rowEnd && colBegin<= colEnd){
            for(int i= colBegin; i<=colEnd; i++){
                matrix[rowBegin][i]= insert++;
                System.out.println(matrix[rowBegin][i]);
            }
            rowBegin++;

            for(int i= rowBegin; i<=rowEnd; i++){
                matrix[i][colEnd]=insert++;
                System.out.println(matrix[i][colEnd]);
            }
            colEnd--;

            if(rowBegin<=rowEnd){
                for(int i= colEnd; i>=colBegin; i--){
                    matrix[rowEnd][i]=insert++;
                    System.out.println(matrix[rowEnd][i]);
                }
            }
            rowEnd--;

            if(colBegin<=colEnd){
                for(int i=rowEnd; i>=rowBegin; i--){
                    matrix[i][colBegin]=insert++;
                    System.out.println(matrix[i][colBegin]);
                }
            }
            colBegin++;
        }



        return matrix;

    }
}
