package dp.pattern.warmup;

import java.util.HashMap;
import java.util.Map;

public class ClimbingStairs {
    // this problem is similar to fibonacci series
    public static void main(String[] args) {
        int n = 5;
        System.out.println(climbStairsBruteForce(n));
        System.out.println(climbStairs(n, new HashMap<>()));
        System.out.println(dp(n));
        System.out.println(dpOptimised(n));
    }

    public static int climbStairsBruteForce(int n) {
        // Each time you can either climb 1 or 2 steps.
        // In how many distinct ways can you climb to the top?

        if (n == 1 || n == 2) {
            return n;
        }

        return climbStairsBruteForce(n - 1) + climbStairsBruteForce(n - 2);
    }

    public static int climbStairs(int n, Map<Integer, Integer> cache) {
        // Each time you can either climb 1 or 2 steps.
        // In how many distinct ways can you climb to the top?

        if (n == 1 || n == 2) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int v = climbStairs(n - 1, cache) + climbStairs(n - 2, cache);
        cache.put(n, v);
        return v;
    }


    public static int dp(int n) {
        if (n <= 2) {
            return n;
        }
        int[] ways = new int[n + 1];
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i <= n; i++) {
            ways[i] = ways[i - 1] + ways[i - 2];
        }

        return ways[n];
    }

    public static int dpOptimised(int n) {
        int first = 1;
        int second = 2;
        int next = 0;

        for (int i = 2; i < n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }
}
