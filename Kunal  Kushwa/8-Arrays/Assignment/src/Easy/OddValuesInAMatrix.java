//Cells with Odd Values in a Matrix
package Easy;
import java.util.Arrays;

public class OddValuesInAMatrix {
    public static void main(String[] args) {
        int m=2,n=3;
        int[][] indices = {
                {0,1},
                {1,1}
        };
        int results = oddCells(m,n,indices);
        System.out.println(results);
    }

    private static int oddCells(int m, int n, int[][] indices) {
        int[] rows = new int[m];
        int[] col = new int[n];
        Arrays.fill(rows,0);

        Arrays.fill(col,0);



        for (int i = 0; i < indices.length ; i++) {
           rows[indices[i][0]]++;
            col[indices[i][1]]++;
        }
        int count =0;
        for (int i = 0; i < m ; i++) {
            for (int j = 0; j < n; j++) {
                if((rows[i]+col[j])%2 !=0){
                    count++;
                }
            }
        }
        return count;
    }

}
