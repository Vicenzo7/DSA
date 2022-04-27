//Lucky Numbers in a Matrix
package Easy;
import java.util.ArrayList;
import java.util.List;

public class LuckyNumbersinaMatrix {
    public static void main(String[] args) {
        int[][] input = {
                {3,7,8},
                {9,11,13},
                {15,16,17}
        };

        List<Integer> result = new ArrayList<>();
        result =luckyNumbers(input);

        System.out.println(result);

    }

    public static List<Integer> luckyNumbers (int[][] matrix){
        List<Integer> minR = new ArrayList<>();
        List<Integer> maxC = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        int m=matrix.length;
        int n= matrix[0].length;

        int min,max;
        for (int i = 0; i < m ; i++) {
            min=matrix[i][0];
            for (int j = 0; j < n ; j++) {
                if(min>matrix[i][j])
                {
                    min=matrix[i][j];

                }
            }
            minR.add(min);
        }
        System.out.println(minR);
        for (int i = 0; i < n ; i++) {
            max=matrix[0][i];
            for (int j = 0; j < m ; j++) {
                if(max<matrix[j][i])
                {
                    max= matrix[j][i];
                }

            }
            maxC.add(max);
        }
        System.out.println(maxC);

        for (int i = 0; i <minR.size() ; i++) {
            if(maxC.contains(minR.get(i)))
            {
                result.add(minR.get(i));
            }
        }

        return result;
    }
}
