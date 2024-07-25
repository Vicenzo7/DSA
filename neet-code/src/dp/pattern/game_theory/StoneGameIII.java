package dp.pattern.game_theory;

import java.util.Arrays;

public class StoneGameIII {
    public static void main(String[] args) {
        int[] stoneValue = {1, 2, 3, 7};
//        int[] stoneValue = {1, 2, 3, -9};
//        int[] stoneValue = {1, 2, 3, 6};
//        int[] stoneValue = {-1, -2, -3};
        System.out.println(stoneGameIII(stoneValue));
    }


    static
    public String stoneGameIII(int[] stoneValue) {
        int n = stoneValue.length;
        int total = Arrays.stream(stoneValue).sum();
        int aliceScore = memoization(true, 0, stoneValue, new Integer[2][n]);
        int bobScore = total - aliceScore;

        if (aliceScore > bobScore) {
            return "Alice";
        } else if (aliceScore < bobScore) {
            return "Bob";
        }
        return "Tie";
    }

    static
    private int memoization(boolean aliceTurn, int i, int[] stoneValue, Integer[][] cache) {
        if (i >= stoneValue.length) {
            return 0;
        }
        int turnIndex = aliceTurn ? 0 : 1;
        if (cache[turnIndex][i] != null) {
            return cache[turnIndex][i];
        }

        int result = aliceTurn ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int total = 0;
        for (int j = i; j < i + 3; j++) {

            if (j >= stoneValue.length) {
                break;
            }
            total += stoneValue[j];
            if (aliceTurn) {
                result = Math.max(result, total + memoization(false, j + 1, stoneValue, cache));
            } else {
                result = Math.min(result, memoization(true, j + 1, stoneValue, cache));
            }
        }

        return cache[turnIndex][i] = result;
    }

}
