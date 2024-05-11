package dp.pattern.linear_sequence_with_constant_transition;

import java.util.HashMap;
import java.util.Map;

public class SolvingQuestionWithBrainPower {
    public static void main(String[] args) {
        int[][] questions = {{1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}};
        System.out.println(mostPoints(questions));

    }

    public static long mostPoints(int[][] questions) {
        int[] ans = new int[1];
        ans[0] = Integer.MIN_VALUE;
        bruteForce(0, 0, questions, ans);
        System.out.println(ans[0]);
        System.out.println(memoization(0, questions, new HashMap<>()));
        return dp(questions);
    }


    private static void bruteForce(int index, int points, int[][] questions, int[] ans) {
        if (index >= questions.length) {
            ans[0] = Math.max(ans[0], points);
            return;
        }


        // solve question
        int currentIndexPoints = questions[index][0];
        int nextIndex = questions[index][1];

        bruteForce(index + nextIndex + 1, currentIndexPoints + points, questions, ans);

        // skip the question
        bruteForce(index + 1, points, questions, ans);
    }

    private static long memoization(int index, int[][] questions, Map<Integer, Long> cache) {
        if (index >= questions.length) {
            return 0;
        }

        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        // solve question
        int currentIndexPoints = questions[index][0];
        int nextIndex = questions[index][1];

        long option1 = currentIndexPoints + memoization(index + nextIndex + 1, questions, cache);

        // skip the question
        long option2 = memoization(index + 1, questions, cache);
        long result = Math.max(option1, option2);
        cache.put(index, result);
        return result;
    }

    private static long dp(int[][] questions) {
        long[] dp = new long[questions.length + 1];
        // if we solve each problem
        for (int i = 0; i < questions.length; i++) {
            dp[i] = questions[i][0];
        }

        // if we skip some problems
        for (int i = questions.length - 1; i >= 0; i--) {
            int indexAfterSkipped = questions[i][1] + i + 1;
            if (indexAfterSkipped < questions.length) {
                dp[i] += dp[indexAfterSkipped];
            }
            dp[i] = Math.max(dp[i], dp[i + 1]);
        }
        return dp[0];
    }
}
