package dp.onedimension.batchII;

import java.util.HashMap;
import java.util.Map;

public class KnightDialer {
    public static void main(String[] args) {
        int n = 3131;
        System.out.println(knightDialer(n));
    }


    /*

        This approach is easy to remember.

        This is a straight out DP question. We have a recursive function f(n,d)
        where n is the number of digits to dial and d is the current digit dialed.
        The base case is f(0,d) = 1 since there is only one way to not dial a number.
        The recursive relationships are
        f(n,0) = f(n-1,4) + f(n-1,6) since we can only reach 0 from 4 or 6.
        Similarly, f(n,1) = f(n-1,8) + f(n-1,6) and so on.
        Note that if n != 0 then f(n, 5) = 0 since there is no way to reach 5.
        To get the total possible count of telephone numbers we do a summation:
        total = f(n-1,0) + f(n-1,1) + . . . + f(n-1,9)
        Don't forget to memoize and MOD your totals.

    */
    static int MOD = (int) (1e9 + 7);
    static int[][] mapping = {
            /* 0 */ {6, 4},
            /* 1 */{8, 6},
            /* 2 */{7, 9},
            /* 3 */{4, 8},
            /* 4 */{0, 3, 9},
            /*5 */{},
            /* 6 */ {0, 1, 7},
            /* 7 */ {2, 6},
            /* 8 */ {1, 3},
            /* 9 */ {4, 2}

    };

    static public int knightDialer(int n) {
        int[][] cache = new int[5001][10];
        return moreOptimised(n, new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9}, cache);


//        Map<String, Integer> dp = new HashMap<>();
//        int total = 0;
//        for (int i = 0; i < 10; i++) {
//            total = (total + dfs(n - 1, i, dp)) % MOD;
//        }
//        return total;
    }



    static private int dfs(int n, int currentDialed, Map<String, Integer> dp) {
        if (n == 0) { // there are 1 way to create a number of length 0, by not picking
            return 1;
        }
        if (currentDialed == 5) {
            return 0;
        }

        if (dp.containsKey(n + "-" + currentDialed)) {
            return dp.get(n + "-" + currentDialed);
        }

        int[] possibleLanding = mapping[currentDialed];
        int total = 0;
        for (Integer i : possibleLanding) {
            total = (total + dfs(n - 1, i, dp)) % MOD;
        }
        dp.put(n + "-" + currentDialed, total);
        return total;
    }

     /*

        Approach

    Create a 2D array MOVES to represent the possible moves for each digit on the phone pad.
    Use a recursive function knightDialer to calculate the count of distinct phone numbers.
    Use a cache (cache array) to store previously computed results for optimization.
    If remaining is 1, return the length of nextNumbers, indicating that the knight can be placed on any of the
    available numbers.
    Otherwise, iterate through each number in nextNumbers and recursively calculate the count for the remaining moves
    (remaining - 1) using the possible moves for the current number.
    Update the cache with the calculated result and return the total count.

    Complexity

    Time Complexity: O(n * 10) where n is the given input. This is because for each digit, there are at most 10 possible next moves, and the recursion is performed for each remaining move.

    Space Complexity: O(n * 10) for the cache array, as it stores intermediate results for optimization. The recursion stack also contributes to the space complexity.

    */

    private static int moreOptimised(int remaining, int[] nextNumbers, int[][] cache) {
        if (remaining == 1) { // only here 5 is included
            return nextNumbers.length;
        }
        int count = 0;
        for (int nextNumber : nextNumbers) {
            int cur = cache[remaining][nextNumber];
            if (cur == 0) {
                cur = moreOptimised(remaining - 1, mapping[nextNumber], cache);
                cache[remaining][nextNumber] = cur;
            }
            count += cur;
            count = count % MOD;
        }
        return count;
    }
}
