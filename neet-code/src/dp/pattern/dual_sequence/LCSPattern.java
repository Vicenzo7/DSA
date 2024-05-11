package dp.pattern.dual_sequence;

import java.util.HashMap;
import java.util.Map;

public class LCSPattern {
    public static void main(String[] args) {
//        String text1 = "abcde", text2 = "ace";
        String text1 = "abac", text2 = "cab";
        System.out.println(longestCommonSubsequence(text1, text2));
    }

    public static int longestCommonSubsequence(String text1, String text2) {
        System.out.println(bruteForce(0, 0, text1, text2));
        Map<String, Integer> cache = new HashMap<>();
        System.out.println(memoization(0, 0, text1, text2, cache));
        System.out.println(dp(text1, text2));
        return dpOptimized(text1, text2);
    }


    // TC = O(2^(m+n)) -> Since we are branching twice and we are branching twice when character is not same.
    // SC = O(m+n) -> Since m+n is the height of the tree.
    private static int bruteForce(int i, int j, String text1, String text2) {
        // if any of the text is out of bound return 0
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + bruteForce(i + 1, j + 1, text1, text2);
        } else {
            int option1 = bruteForce(i + 1, j, text1, text2);
            int option2 = bruteForce(i, j + 1, text1, text2);
            ans = Math.max(option1, option2);
        }
        return ans;
    }


    // TC = O(m.n)
    // SC = O(m+n) -> Since m+n is the height of the tree.
    private static int memoization(int i, int j, String text1, String text2, Map<String, Integer> cache) {
        // if any of the text is out of bound return 0
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }

        if (cache.containsKey(i + ":" + j)) {
            return cache.get(i + ":" + j);
        }

        int ans;
        if (text1.charAt(i) == text2.charAt(j)) {
            ans = 1 + memoization(i + 1, j + 1, text1, text2, cache);
        } else {
            int option1 = memoization(i + 1, j, text1, text2, cache);
            int option2 = memoization(i, j + 1, text1, text2, cache);
            ans = Math.max(option1, option2);
        }

        cache.put(i + ":" + j, ans);
        return ans;
    }

//    We have extra dimension to handle the edge case,
//    so we don't go out of bound

//    Also note our string index start from 0,
//    but since we have extra dimension we will
//    be doing i+1 and j+1.
//    Which states in dp array letters are represented from
//    1 index

    // TC = O(m.n) SC = (m.n)
    public static int dp(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        return dp[m][n];
    }

    // TC = O(m.n) SC = (m) where m is size of smaller string

    public static int dpOptimized(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    currRow[j + 1] = 1 + dp[j];
                } else {
                    currRow[j + 1] = Math.max(dp[j + 1], currRow[j]);
                }
            }
            dp = currRow;
        }
        return dp[n];
    }
}
