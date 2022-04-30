import java.util.Arrays;

public class RotateImage {
    public static void main(String[] args) {
        int[][] mat = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };

        for(int[] a:mat)
        {
            System.out.println(Arrays.toString(a));
        }
        System.out.println();
        findRotation(mat);
    }

    private static void findRotation(int[][] mat) {
        int n=mat.length;
        int col=mat[0].length;
        //transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            {
                int temp=mat[i][j];
                mat[i][j]=mat[j][i];
                mat[j][i]=temp;
            }
        }
        System.out.println("transpose");

        for(int[] a:mat)
        {
            System.out.println(Arrays.toString(a));
        }

        //swap
        int start=0,end=n-1;
        while(start<end)
        {
            for(int row=0;row<n;row++)
            {
                int temp=mat[row][start];
                mat[row][start]=mat[row][end];
                mat[row][end]= temp;
                
            }
            start++;
            end--;
        }
        System.out.println("After swap");
        for(int[] a:mat)
        {
            System.out.println(Arrays.toString(a));
        }

    }
    
}
