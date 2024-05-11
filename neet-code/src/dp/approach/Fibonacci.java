package dp.approach;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {
    public static void main(String[] args) {
        int n = 16;
        System.out.println(bruteForce(n));
        System.out.println(memoization(n, new HashMap<>()));
        System.out.println(dp(n));
    }


    // TC = O(2^n) -> because n is the height of the tree, and we have two branches
    public static int bruteForce(int n) {
        if (n <= 1) {
            return n;
        }

        return bruteForce(n - 1) + bruteForce(n - 2);
    }

    // TC = O(n) - top down approach
    public static int memoization(int n, Map<Integer, Integer> cache) {
        if (n <= 1) {
            return n;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int v = memoization(n - 1, cache) + memoization(n - 2, cache);
        cache.put(n, v);
        return v;
    }


    // TC =  O(n) -> tabulation  (bottom up approach)
    public static int dp(int n) {
        if (n <= 1) {
            return n;
        }

        int first = 0;
        int second = 1;
        int next = 0;
        for (int i = 2; i <= n; i++) {
            next = first + second;
            first = second;
            second = next;
        }
        return next;
    }
}
