package dp.pattern.interval_dp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
    }


    /*
        Approach
        s = "bbbab"


        option 1:
        if first and last char are equal then our sub problem becomes
            -> 2 + lps(i+1,j-1) == 2 + lps(bba)
        else
        option 2: if we exclude first character
            lps(i+1,j) = lps(bbab)

        option 3: if we exclude last character
            lps(i,j-1) = lps(bbba)
    */
    public static int longestPalindromeSubseq(String s) {
        System.out.println(bruteForce(0, s.length() - 1, s));
        System.out.println(memoization(0, s.length() - 1, s, new HashMap<>()));

        int[][] cache = new int[s.length()][s.length()];
        return memoizationWithArray(0, s.length() - 1, s, cache);
    }


    private static int bruteForce(int left, int right, String s) {
        if (left > right) {
            return 0;
        }

        int ans;
        if (s.charAt(left) == s.charAt(right)) {
            if (left == right) {
                ans = 1 + bruteForce(left + 1, right - 1, s);
            } else {
                ans = 2 + bruteForce(left + 1, right - 1, s);
            }
        } else {
            // exclude first character
            int option1 = bruteForce(left + 1, right, s);

            // exclude last character
            int option2 = bruteForce(left, right - 1, s);

            ans = Math.max(option1, option2);
        }
        return ans;
    }

    private static int memoization(int left, int right, String s, Map<String, Integer> cache) {
        if (left > right) {
            return 0;
        }

        if (cache.containsKey(left + ":" + right)) {
            return cache.get(left + ":" + right);
        }

        int ans;
        if (s.charAt(left) == s.charAt(right)) {
            if (left == right) {
                ans = 1 + memoization(left + 1, right - 1, s, cache);
            } else {
                ans = 2 + memoization(left + 1, right - 1, s, cache);
            }
        } else {
            // exclude first character
            int option1 = memoization(left + 1, right, s, cache);

            // exclude last character
            int option2 = memoization(left, right - 1, s, cache);

            ans = Math.max(option1, option2);
        }
        cache.put(left + ":" + right, ans);
        return ans;
    }

    private static int memoizationWithArray(int left, int right, String s, int[][] cache) {
        if (left > right) {
            return 0;
        }

        if (cache[left][right] > 0) {
            return cache[left][right];
        }

        int ans;
        if (s.charAt(left) == s.charAt(right)) {
            if (left == right) {
                ans = 1 + memoizationWithArray(left + 1, right - 1, s, cache);
            } else {
                ans = 2 + memoizationWithArray(left + 1, right - 1, s, cache);
            }
        } else {
            // exclude first character
            int option1 = memoizationWithArray(left + 1, right, s, cache);

            // exclude last character
            int option2 = memoizationWithArray(left, right - 1, s, cache);

            ans = Math.max(option1, option2);
        }
        cache[left][right] = ans;
        return ans;
    }
}
