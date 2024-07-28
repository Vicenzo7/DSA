package dp.pattern.warmup;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PerfectSquare {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(numSquares(n));
    }

    public static int numSquares(int n) {
        System.out.println(bruteForce(n, n));
        System.out.println(memoization(n, n, new HashMap<>()));
        return dp(n);
    }


    private static int bruteForce(int n, int target) {
        if (target == 0) {
            return 0;
        }

        if (target < 0) {
            return -1;
        }
        int minCount = -1;
        for (int i = 1; i <= n; i++) {
            int count = bruteForce(n, target - i * i);
            if (count >= 0) {
                minCount = minCount < 0 ? count : Math.min(count, minCount);
            }
        }

        minCount = minCount < 0 ? -1 : minCount + 1;

        return minCount;
    }

    private static int memoization(int n, int target, Map<Integer, Integer> cache) {
        if (target == 0) {
            return 0;
        }

        if (target < 0) {
            return -1;
        }

        if (cache.containsKey(target)) {
            return cache.get(target);
        }

        int minCount = -1;
        for (int i = 1; i * i <= n; i++) {
            int square = i * i;
            if (target - square < 0) {
                continue;
            }
            int count = memoization(n, target - square, cache);
            if (count >= 0) {
                minCount = minCount < 0 ? count : Math.min(count, minCount);
            }
        }

        minCount = minCount < 0 ? -1 : minCount + 1;
        cache.put(target, minCount);
        return minCount;
    }

    public static int dp(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        int count = 1;
        while (count * count <= n) {
            int square = count * count;
            // calculate how many square are required to form the i
            for (int i = square; i < n + 1; i++) {
                dp[i] = Math.min(dp[i - square] + 1, dp[i]);
            }
            count++;
        }


        return dp[n];
    }
}
