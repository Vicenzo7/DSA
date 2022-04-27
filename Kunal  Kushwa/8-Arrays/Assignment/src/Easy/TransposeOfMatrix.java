package Easy;
import java.util.Arrays;

public class TransposeOfMatrix {
    public static void main(String[] args) {
        int[][] inputs = {
                {1,2,3},
                {4,5,6},
//                {7,8,9}
        };
        for(int[] a :inputs)
        {
                System.out.println(Arrays.toString(a));
        }

        int[][] result = transpose(inputs);
        for(int[] a :result)
        {
            System.out.println(Arrays.toString(a));
        }

    }

    private static int[][] transpose(int[][] matrix)
    {
        int m = matrix.length;
        int n= matrix[0].length;
        System.out.println(m+" "+n);
        int[][] ans = new int[n][m];
        for (int i = 0; i < n ; i++)
        {
            for (int j = 0; j < m; j++)
            {
                ans[i][j] = matrix[j][i];
            }
        }
        return ans;
    }
}
