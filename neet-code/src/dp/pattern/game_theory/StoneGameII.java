package dp.pattern.game_theory;

import java.util.HashMap;
import java.util.Map;

public class StoneGameII {

    public static void main(String[] args) {
        int[] piles = {2, 7, 9, 4, 4};
        System.out.println(stoneGameII(piles));
    }

    static
    public int stoneGameII(int[] piles) {
        return dfs(true, 0, 1, piles, new Integer[2][piles.length][piles.length + 1]);
    }

    // function always return alice score
    static
    public int dfs(boolean aliceTurn, int i, int M, int[] piles, Integer[][][] cache) {
        if (i >= piles.length) {
            return 0;
        }

        int turnIndex = aliceTurn ? 0 : 1;

        String key = aliceTurn + "-" + i + "-" + M;
        if (cache[turnIndex][i][M] != null) {
            return cache[turnIndex][i][M];
        }

        int result = aliceTurn ? 0 : Integer.MAX_VALUE;
        int total = 0;
        for (int X = 1; X <= 2 * M; X++) {
            if (i + X > piles.length) {
                break;
            }
            total += piles[i + X - 1];
            if (aliceTurn) {
                // max because alice is making the choice and he will choose max
                result = Math.max(result, total + dfs(false, i + X, Math.max(M, X), piles, cache));
            } else {
                // minimum because bob is making the choice, so he is going to choose max and we
                // will get minimum
                result = Math.min(result, dfs(true, i + X, Math.max(M, X), piles, cache));
            }
        }

        cache[turnIndex][i][M] = result;
        return result;
    }

}
