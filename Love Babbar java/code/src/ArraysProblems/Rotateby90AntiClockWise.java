package ArraysProblems;

import java.util.Arrays;

//Rotate the array by 90 degree in anticlockwise direction
public class Rotateby90AntiClockWise {
    public static void main(String[] args) {
        int[][] arr={
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int n= arr.length;
        rotateby90(arr,n);
    }

    static void rotateby90(int matrix[][], int n)
    {

        //transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int temp=matrix[i][j];
                matrix[i][j]= matrix[j][i];
                matrix[j][i]=temp;
            }
        }


        //swap
        int start=0,end=n-1;

        while(start<= end)
        {
            for(int i=0;i<n;i++)
            {
                int temp= matrix[start][i];
                matrix[start][i] = matrix[end][i];
                matrix[end][i] = temp;

            }
            start++;
            end--;
        }


        for(int[] a:matrix)
        {
            System.out.println(Arrays.toString(a));
        }
    }
}
