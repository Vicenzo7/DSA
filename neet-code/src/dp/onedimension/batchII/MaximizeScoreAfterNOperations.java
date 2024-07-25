package dp.onedimension.batchII;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class MaximizeScoreAfterNOperations {
    public static void main(String[] args) {
//        int[] nums = {1, 2};
//        int[] nums = {3, 4, 6, 8};
        int[] nums = {1, 2, 3, 4, 5, 6};
        System.out.println(maxScore(nums));
    }


    static
    public int maxScore(int[] nums) {
        return dfs(0, 1, nums, new Integer[(int) Math.pow(2, nums.length + 1)]);
    }

    /*
        Intuition:

        1.  Use a mask to keep a track of which index value are used
        2.  Run two for loops to pick two index.
        3. Check if those index are used, if used skip it
            Logic to check if index is used
            // check if value at ith and jth index is used
            int ithIndexValueUsed = (1 << i) & mask;
            int jthIndexValueUsed = (1 << j) & mask;
            // if values are used then the value of above operation is greater than 0, if
            // not used it is 0
            if (ithIndexValueUsed > 0 || jthIndexValueUsed > 0) {
                 continue;
            }
        4. If not used create a new mask stating them as used
         // create a new mask representing ithIndex and jthIndex value is used
         int newMask = mask | (1 << i) | (1 << j);
       5. Calculate currentScore
       6. Make recursive call of sub-problem and get its score
       7. Add current Score and sub-problem score and update them.

       TC = O(2^n * n^2)
       The code uses a recursive depth-first search (DFS) approach to iterate through all possible combinations of pairs
       of elements in the input array. The nested loops iterate through all pairs of elements, resulting in O(n^2) iterations.
       Within each iteration, the code checks if the values at the ith and jth index are used, which takes O(1) time.
       The recursive calls to the DFS function create a binary tree with a branching factor of 2 (representing whether
       to include or exclude each pair of elements), resulting in a total of 2^n recursive calls. Additionally, the
       code calculates the greatest common divisor (gcd) of two elements using BigInteger, which has a time complexity
       of O(log(min(x, y))). Overall, the time complexity of the code is O(2^n * n^2).
    */

    static
    public int dfs(int mask, int operation, int[] nums, Integer[] cache) {
        if (cache[mask] != null) {
            return cache[mask];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                // check if value at ith and jth index is used
                int ithIndexValueUsed = (1 << i) & mask;
                int jthIndexValueUsed = (1 << j) & mask;
                // if values are used then the value of above operation is greater than 0, if
                // not used it is 0
                if (ithIndexValueUsed > 0 || jthIndexValueUsed > 0) {
                    continue;
                }

                // create a new mask representing ithIndex and jthIndex value is used
                int newMask = mask | (1 << i) | (1 << j);
                BigInteger x = BigInteger.valueOf(nums[i]);
                BigInteger y = BigInteger.valueOf(nums[j]);
                int currentScore = operation * x.gcd(y).intValue();
                int previousScoreOfMask = cache[mask] != null ? cache[mask] : 0;
                int score = Math.max(previousScoreOfMask, currentScore + dfs(newMask, operation + 1, nums, cache));
                cache[mask] = score;
            }
        }

        return cache[mask] != null ? cache[mask] : 0;
    }
}
