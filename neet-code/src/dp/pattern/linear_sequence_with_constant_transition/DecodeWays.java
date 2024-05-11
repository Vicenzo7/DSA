package dp.pattern.linear_sequence_with_constant_transition;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        System.out.println(numDecodings(s));
    }

    private static int numDecodings(String s) {
        Map<Integer, Integer> cache = new HashMap<>();
        //cache.put(s.length(), 1);
        System.out.println(memoization(0, s, cache));
        System.out.println(dp(s));
        return dpOptimized(s);
    }

    private static int memoization(int index, String s, Map<Integer, Integer> cache) {
        if (index == s.length()) {
            return 1;
        }
        if (cache.containsKey(index)) {
            return cache.get(index);
        }

        if (s.charAt(index) == '0') {
            return 0;
        }

        // used the single digit, check if next is a single digit
        int result = memoization(index + 1, s, cache);

        // check if double-digit can be used
        if (index + 1 < s.length() && (s.charAt(index) == '1' ||
                (s.charAt(index) == '2' && s.charAt(index + 1) < '7'))) {

            // used double-digit number
            result += memoization(index + 2, s, cache);
        }

        cache.put(index, result);
        return result;
    }

    private static int dp(String s) {
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;

        for (int i = 2; i < s.length() + 1; i++) {
            int combinationCount = 0;
            // check if previous character was not zero, so we can consider it was a single digit
            if (s.charAt(i - 1) != '0') {
                combinationCount = dp[i - 1];
            }

            // check can we form a double-digit combination with previous 2 digit
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '7')) {
                combinationCount += dp[i - 2];
            }

            dp[i] = combinationCount;
        }

        return dp[s.length()];
    }

    private static int dpOptimized(String s) {
        int twoBack = 1;
        int oneBack = s.charAt(0) == '0' ? 0 : 1;
        int combinationCount = oneBack;
        for (int i = 2; i < s.length() + 1; i++) {
            combinationCount = 0;
            // check if previous character was not zero, so we can consider it was a single digit
            if (s.charAt(i - 1) != '0') {
                combinationCount += oneBack;
            }

            // check can we form a double-digit combination with previous 2 digit
            if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) <= '7')) {
                combinationCount += twoBack;
            }

            twoBack = oneBack;
            oneBack = combinationCount;
        }

        return combinationCount;
    }
}
