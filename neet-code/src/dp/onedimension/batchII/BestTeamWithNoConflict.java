package dp.onedimension.batchII;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class BestTeamWithNoConflict {


    public static void main(String[] args) {
        int[] scores = {1, 3, 5, 10, 15}, ages = {1, 2, 3, 4, 5};
//        int[] scores = {4, 5, 6, 5}, ages = {2, 1, 2, 1};
//        int[] scores = {1, 2, 3, 5}, ages = {8, 9, 10, 1};
//        int[] scores = {1, 3, 7, 3, 2, 4, 10, 7, 5}, ages = {4, 5, 2, 1, 1, 2, 4, 1, 4};

        System.out.println(bestTeamScore(scores, ages));
    }

    public static int bestTeamScore(int[] scores, int[] ages) {
        int[][] ageScores = new int[scores.length][2];
        for (int i = 0; i < ageScores.length; i++) {
            ageScores[i][0] = ages[i];
            ageScores[i][1] = scores[i];
        }

//        ageScores.sort(
//                (a, b) -> {
//                    int ageComparison = Integer.compare(a[0], b[0]);
//                    return ageComparison != 0 ? ageComparison : Integer.compare(a[1], b[1]);
//                });


        // sorting based on score and pair in ascending order
        Arrays.sort(ageScores, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

//        return bruteForce(0, -1, ageScores);
        int[][] cache = new int[scores.length][scores.length + 1];
        for (int[] row : cache) {
            Arrays.fill(row, -1);
        }
        return memoization(0, -1, ageScores, cache);

//        return dp(scores, ages);
    }


    private static int bruteForce(int index, int prevIndex, List<int[]> ageScores) {
        if (index >= ageScores.size()) {
            return 0;
        }

        // include
        int[] currentAgeScore = ageScores.get(index);
        int option1 = 0;
        if (prevIndex == -1 || currentAgeScore[1] >= ageScores.get(prevIndex)[1]) {
            option1 = currentAgeScore[1] + bruteForce(index + 1, index, ageScores);
        }

        // exclude
        int option2 = bruteForce(index + 1, prevIndex, ageScores);

        return Math.max(option1, option2);
    }

    private static int memoization(int index, int prevIndex, int[][] ageScores, int[][] cache) {
        if (index >= ageScores.length) {
            return 0;
        }

        if (cache[index][prevIndex + 1] != -1) {
            return cache[index][prevIndex + 1];
        }

        // include
        int[] currentAgeScore = ageScores[index];
        int option1 = 0;
        if (prevIndex == -1 || currentAgeScore[1] >= ageScores[prevIndex][1]) {
            option1 = currentAgeScore[1] + memoization(index + 1, index, ageScores, cache);
        }

        // exclude
        int option2 = memoization(index + 1, prevIndex, ageScores, cache);

        return cache[index][prevIndex + 1] = Math.max(option1, option2);
    }

    private static int dp(int[] scores, int[] ages) {
        // creating pairs of score and age
        int[][] scoreAges = new int[scores.length][2];
        for (int i = 0; i < scoreAges.length; i++) {
            scoreAges[i][0] = scores[i];
            scoreAges[i][1] = ages[i];
        }

        // sorting based on score and pair in ascending order
        Arrays.sort(scoreAges, Comparator.comparingInt((int[] a) -> a[0]).thenComparingInt(a -> a[1]));

        // constructing a dp array with initial value of score
        int[] dp = new int[scores.length];
        for (int i = 0; i < scoreAges.length; i++) {
            dp[i] = scoreAges[i][0];
        }

        for (int i = 0; i < scoreAges.length; i++) {
            // considering score at i as maxScore
            int mScore = scoreAges[i][0];
            int mAge = scoreAges[i][1];
            // checking from o to i which that score can be added is the maxAge is greater than the current age
            for (int j = 0; j < i; j++) {
                int score = scoreAges[j][0];
                int age = scoreAges[j][1];

                if (mAge >= age) {
                    dp[i] = Math.max(dp[i], mScore + dp[j]);
                }
            }
        }

        return Arrays.stream(dp).max().orElse(0);
    }
}
