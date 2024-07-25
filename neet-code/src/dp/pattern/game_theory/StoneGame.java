package dp.pattern.game_theory;

public class StoneGame {
    public static void main(String[] args) {
        int[] piles = {5, 3, 4, 5};
        System.out.println(stoneGame(piles));
    }


    public static boolean stoneGame(int[] piles) {
        // we can calculate score of only one player
        int totalScore = 0;
        for (int pile : piles) {
            totalScore += pile;
        }

        int left = 0;
        int right = piles.length - 1;
        int aliceScore = optimalGameTheoryDP(left, right, piles, new int[piles.length][piles.length]);
        int bobScore = totalScore - aliceScore;

        return aliceScore >= bobScore;
    }

    public static int optimalGameTheory(int left, int right, int[] piles) {
        if (left > right) {
            return 0;
        }

        /*
           if player 1 choose to pick left pile then,
            player 2 will then choose the next left pile or right  pile
            if player2 picks next left pile ie left +1 then player 1 will have option from left +2 to right

            if player2 picks the right pile  then player1 will have options from left+1 to right-1

            Now we don't know what player two will pick, but for sure he is going to pick the max because he to want to win,
            so we will get minimum of whatever he picks

        */
        int option1 = piles[left] + Math.min(optimalGameTheory(left + 2, right, piles),
                optimalGameTheory(left + 1, right - 1, piles));

        /*
           if player1 choose to pick right pile then,
            player 2 will then choose the next right pile or the left pile
            if player2 picks next right pile ie right - 1 then player 1 will have option from left to right - 2

            if player2 picks the left pile then player1 will have options from left+1 to right-1

            Now we don't know what player2 will pick, but for sure he is going to pick the max because he to want to win,
            so we will get minimum of whatever he picks

        */

        // player 2 choose to pick right pile
        int option2 = piles[right] + Math.min(optimalGameTheory(left, right - 2, piles),
                optimalGameTheory(left + 1, right - 1, piles));

        return Math.max(option1, option2);
    }

    public static int optimalGameTheoryDP(int left, int right, int[] piles, int[][] cache) {
        // If the left index exceeds the right index, no more piles left to pick, so return 0.
        if (left > right) {
            return 0;
        }

        // If the result for the current range is already computed, return it from the cache.
        if (cache[left][right] > 0) {
            return cache[left][right];
        }

        // Calculate the score if player 1 picks the leftmost pile.
        int option1 = piles[left] + Math.min(
                optimalGameTheoryDP(left + 2, right, piles, cache),    // Player 2 picks next left pile
                optimalGameTheoryDP(left + 1, right - 1, piles, cache) // Player 2 picks right pile
        );

        // Calculate the score if player 1 picks the rightmost pile.
        int option2 = piles[right] + Math.min(
                optimalGameTheoryDP(left, right - 2, piles, cache),    // Player 2 picks next right pile
                optimalGameTheoryDP(left + 1, right - 1, piles, cache) // Player 2 picks left pile
        );

        // Store the maximum score difference between the two options in the cache.
        cache[left][right] = Math.max(option1, option2);

        // Return the maximum score difference for the current range.
        return cache[left][right];
    }
}
