package dp.pattern.warmup;

import java.util.HashMap;
import java.util.Map;

public class NthTribonacciNumber {
    /*
    The Tribonacci sequence Tn is defined as follows:

    T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.

    Given n, return the value of Tn.
    */
    public static void main(String[] args) {
        int n = 25;
        System.out.println(tribonacci(n));
    }

    public static int tribonacci(int n) {
        System.out.println(bruteForce(n));
        System.out.println(memoization(n, new HashMap<>()));
        System.out.println(dp(n));
        return dpOptimized(n);
    }

    public static int bruteForce(int n) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        return bruteForce(n - 1) + bruteForce(n - 2) + bruteForce(n - 3);
    }

    public static int memoization(int n, Map<Integer, Integer> cache) {
        if (n == 0) {
            return 0;
        }
        if (n <= 2) {
            return 1;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int value = memoization(n - 1, cache) + memoization(n - 2, cache) + memoization(n - 3, cache);
        cache.put(n, value);
        return value;
    }

    public static int dp(int n) {
        int[] series = new int[n + 1];
        series[0] = 0;
        series[1] = 1;
        series[2] = 1;

        for (int i = 3; i <= n; i++) {
            series[i] = series[i - 1] + series[i - 2] + series[i - 3];
        }


        return series[n];
    }

    public static int dpOptimized(int n) {
        int first= 0;
        int second = 1;
        int third = 1;

        int next = 0;
        for (int i = 3; i <= n; i++) {
             next = first + second + third;
             first = second;
             second = third;
             third = next;
        }
        return next;
    }
}
