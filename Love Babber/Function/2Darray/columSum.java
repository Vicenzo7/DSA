import java.lang.reflect.Array;
import java.util.Arrays;

class columSum
{
    public static void main(String[] args) {
        int maxSum=0;
        
        int[][] arr ={{1,2,3},{4,5,6},{7,8,9}};

        for(int[] a:arr)
        {
            System.out.println(Arrays.toString(a));
        }

        for(int row=0;row<3;row++)
        {
            int sum=0;
            for(int col=0;col<3;col++)
            {
                sum += arr[col][row];

            }
            maxSum=Math.max(maxSum, sum);
        }

        System.out.println(maxSum);
    }
}
