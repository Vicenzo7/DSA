package greedy.a2z;

import java.util.ArrayList;
import java.util.List;

public class MinimumNumberOfCoins {
    public static void main(String[] args) {
        int n = 43;

        System.out.println(minPartition(n));
    }

    public static List<Integer> minPartition(int n) {
        // code here
        int[] coin = {2000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        List<Integer> result = new ArrayList<>();
        int i = 0;
        while (n > 0) {
            if (coin[i] > n) {
                i++;
            } else {
                result.add(coin[i]);
                n -= coin[i];
            }
        }

        return result;
    }
}
