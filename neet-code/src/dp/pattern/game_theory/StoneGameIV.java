package dp.pattern.game_theory;

public class StoneGameIV {
    public static void main(String[] args) {
        int n = 7;
        System.out.println(winnerSquareGame(n));
    }

    static
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];

        dp[0] = false; // No stone means current player losses;

        for (int i = 1; i <= n; i++) {
            // different ways to pick i stones.
            // if removing k^2 stones leaves a losing position for the opponent, mark current as winning
            for (int k = 1; k * k <= i; k++) {
                if (!dp[i - k * k]) {
                    // it means i-k*k somehow lead to dp[0], no stones to pick so opponent loses
                    dp[i] = true;
                    break;// no need to check further we have found the winning move
                }
            }
        }

        return dp[n];
    }
}
