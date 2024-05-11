package dp.pattern.dual_sequence;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        System.out.println(minDistance(word1, word2));
    }


    /*
        figuring out base cases

        if a = "" and b ="" -> Min operations required to convert a to b is 0
        if a = "abc" and b ="abc" -> Min operations required to convert a to b is 0
        if a = "" and b = "abc" -> Min operations required to convert a to b is 3, ie length of b
        if a = "abc" and b = "" -> Min operations required to convert a to b is 3, ie length of a
    */

    public static int minDistance(String word1, String word2) {

        System.out.println(bruteForce(0, 0, word1, word2));
        System.out.println(memoization(0, 0, word1, word2, new HashMap<>()));
        return dp(word1, word2);
    }

    private static int bruteForce(int i, int j, String word1, String word2) {
        if (i == word1.length() && j == word2.length()) {
            return 0;
        }

        // if word1 is exhausted, operation required to convert word1 to word2 is word2.length-j
        if (i == word1.length()) {
            return word2.length() - j;
        }
        // if word2 is exhausted, operation required to convert word1 to word2 is word1.length-1
        if (j == word2.length()) {
            return word1.length() - i;
        }

        int ans;

        // if char are same move ahead
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = bruteForce(i + 1, j + 1, word1, word2);
        } else { // perform three operation
            int insert = bruteForce(i, j + 1, word1, word2);
            int delete = bruteForce(i + 1, j, word1, word2);
            int replace = bruteForce(i + 1, j + 1, word1, word2);

            ans = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        return ans;
    }

    private static int memoization(int i, int j, String word1, String word2, Map<String, Integer> cache) {
        if (i == word1.length() && j == word2.length()) {
            return 0;
        }

        // if word1 is exhausted, operation required to convert word1 to word2 is word2.length-j
        if (i == word1.length()) {
            return word2.length() - j;
        }
        // if word2 is exhausted, operation required to convert word1 to word2 is word1.length-1
        if (j == word2.length()) {
            return word1.length() - i;
        }

        if (cache.containsKey(i + ":" + j)) {
            return cache.get(i + ":" + j);
        }

        int ans;
        // if char are same move ahead
        if (word1.charAt(i) == word2.charAt(j)) {
            ans = memoization(i + 1, j + 1, word1, word2, cache);
        } else { // perform three operation
            int insert = memoization(i, j + 1, word1, word2, cache);
            int delete = memoization(i + 1, j, word1, word2, cache);
            int replace = memoization(i + 1, j + 1, word1, word2, cache);

            ans = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        cache.put(i + ":" + j, ans);
        return ans;
    }

    public static int dp(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // calculate bases cases
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < n; i++) {
            dp[m][i] = word2.length() - i;
        }

        for (int i = 0; i < m; i++) {
            dp[i][n] = word1.length() - i;
        }

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) {
                    dp[i][j] = dp[i + 1][j + 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i + 1][j + 1], Math.min(dp[i + 1][j], dp[i][j + 1]));
                }
            }
        }

        return dp[0][0];
    }
}
