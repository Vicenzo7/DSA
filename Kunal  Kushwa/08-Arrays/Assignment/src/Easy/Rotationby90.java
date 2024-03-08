//Determine Whether Matrix Can Be Obtained By Rotation
package Easy;

public class Rotationby90 {
    public static void main(String[] args) {
        int[][] mat = {
                {0,0,0},
                {0,1,0},
                {1,1,1}
        };
        int[][] target= {
                {1,1,1},
                {0,1,0},
                {0,0,0}
        };
        System.out.println(findRotation(mat,target));

    }

    public static boolean findRotation(int[][] mat, int[][] target){

        for (int i = 0; i < 4; i++) {
            if(check(mat,target))
            {
                return true;
            }
            rotate(mat);

        }
        return false;
    }

    private static void rotate(int[][] mat) {
        int n = mat.length;

        //transpose
        for(int i=0;i<n;i++)
        {
            for(int j=0; j<i;j++)
            {
                int temp=mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }

        //swap
        int start=0, end=n-1;
        while(start<=end)
        {
            for (int row = 0; row < n; row++) {
                int temp=mat[row][start];
                mat[row][start] = mat[row][end];
                mat[row][end] = temp;
            }
            start++;
            end--;
        }

//        for (int i = 0; i <n ; i++) {
//            for (int j = 0; j < n/2; j++) {
//                int temp=mat[i][j];
//                mat[i][j] = mat[i][n-j-1];
//                mat[i][n-j-1] = temp;
//            }
//
//        }
    }

    private static boolean check(int[][] mat, int[][] target) {
        for (int i = 0; i < mat.length ; i++) {
            for (int j = 0; j < mat.length ; j++) {
                if(mat[i][j] != target[i][j])
                {
                    return false;
                }
            }
        }
        return true;
    }
}
