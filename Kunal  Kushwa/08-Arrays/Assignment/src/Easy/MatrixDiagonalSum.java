
package Easy;
public class MatrixDiagonalSum {
    public static void main(String[] args) {
        int[][] input = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        int sum = diagonalSum(input);
        System.out.println(sum);
    }

    private static int diagonalSum(int[][] input) {
        int primary=0,secondary =0;


        for (int row = 0; row < input.length ; row++) {
            for (int col = 0; col <input[row].length ; col++) {
                if(row == col){
                    primary += input[row][col];
                }
                if ( row+col == input.length-1 && row != col){
                    secondary += input[row][col];
                }
            }
        }
        System.out.println(primary);
        System.out.println(secondary);



         return primary + secondary ;


    }
}
