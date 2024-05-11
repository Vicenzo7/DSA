package dp.pattern.dual_sequence;

import java.util.HashMap;
import java.util.Map;

public class MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        String s1 = "sea", s2 = "eat";
        System.out.println(minimumDeleteSum(s1, s2));
    }

    public static int minimumDeleteSum(String s1, String s2) {
        System.out.println(bruteForce(0, 0, s1, s2));
        System.out.println(memoization(0, 0, s1, s2, new HashMap<>()));
        return dp(s1, s2);
    }


    private static int bruteForce(int i, int j, String s1, String s2) {

        if (i == s1.length() || j == s2.length()) {
            // if both the strings are fully traversed return 0
            if (i == s1.length() && j == s2.length()) {
                return 0;
            }

            // return the sum of the ascii characters of the string which is not fully traversed
            if (i == s1.length()) {
                return s2.substring(j).chars().sum();
            } else {
                return s1.substring(i).chars().sum();
            }
        }

        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = bruteForce(i + 1, j + 1, s1, s2);
        } else {
            int option1 = s2.charAt(j) + bruteForce(i, j + 1, s1, s2); // here we are deleting char at j
            int option2 = s1.charAt(i) + bruteForce(i + 1, j, s1, s2); // here we are deleting char at i
            ans = Math.min(option1, option2);
        }

        return ans;
    }

    private static int memoization(int i, int j, String s1, String s2, Map<String, Integer> cache) {

        if (i == s1.length() || j == s2.length()) {
            // if both the strings are fully traversed return 0
            if (i == s1.length() && j == s2.length()) {
                return 0;
            }
            // return the sum of the ascii characters of the string which is not fully traversed
            if (i == s1.length()) {
                return s2.substring(j).chars().sum();
            }
            return s1.substring(i).chars().sum();

        }

        if (cache.containsKey(i + ":" + j)) {
            return cache.get(i + ":" + j);
        }

        int ans;
        if (s1.charAt(i) == s2.charAt(j)) {
            ans = memoization(i + 1, j + 1, s1, s2, cache);
        } else {
            int option1 = s2.charAt(j) + memoization(i, j + 1, s1, s2, cache); // here we are deleting char at j
            int option2 = s1.charAt(i) + memoization(i + 1, j, s1, s2, cache); // here we are deleting char at i
            ans = Math.min(option1, option2);
        }

        cache.put(i + ":" + j, ans);
        return ans;
    }

    public static int dp(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            dp[i + 1][0] = dp[i][0] + s1.charAt(i);
        }

        for (int i = 0; i < n; i++) {
            dp[0][i + 1] = dp[0][i] + s2.charAt(i);
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
                    int a = s1.charAt(i) + dp[i][j + 1]; // in dp at j + 1, jth character is stored, so we here are deleting ith char
                    int b = s2.charAt(j) + dp[i + 1][j]; // in dp at i + 1, ith character is stored, so we here are deleting jth char
                    dp[i + 1][j + 1] = Math.min(a, b);
                }
            }
        }

        return dp[m][n];
    }
}
