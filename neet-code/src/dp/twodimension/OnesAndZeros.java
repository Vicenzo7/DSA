package dp.twodimension;

import java.util.HashMap;
import java.util.Map;

public class OnesAndZeros {
    public static void main(String[] args) {
        String[] strs = {"10", "0001", "111001", "1", "0"};
        int m = 5, n = 3;

//        strs = new String[]{"10", "0", "1"};
//        strs = new String[]{"00", "000"};
        m = 1;
        n = 1;

        strs = new String[]{"111", "1000", "1000", "1000"};
        m = 9;
        n = 3;
        System.out.println(findMaxForm(strs, m, n));
    }


    public static int findMaxForm(String[] strs, int m, int n) {
        Map<String, Map<Character, Integer>> countsMap = new HashMap<>();

        for (String str : strs) {
            Map<Character, Integer> map = new HashMap<>();
            map.put('0', 0);
            map.put('1', 0);
            for (char c : str.toCharArray()) {
                map.put(c, map.get(c) + 1);
            }
            countsMap.put(str, map);
        }

//        return bruteForce(0, strs, m, n, countsMap);
//        return memoization(0, strs, m, n, countsMap, new HashMap<>());

//        return memoizationDp(0, strs, m, n, countsMap, new int[strs.length][m + 1][n + 1]);
        return dp(strs, m, n);
    }

    private static int bruteForce(int index, String[] strs, int m, int n, Map<String, Map<Character, Integer>> countsMap) {
        if (index == strs.length) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 0;
        }

        // include the key at strs[index]
        Map<Character, Integer> characterIntegerMap = countsMap.get(strs[index]);
        Integer zeroCount = characterIntegerMap.get('0');
        Integer oneCount = characterIntegerMap.get('1');
        int option1 = 0;
        if (m - zeroCount >= 0 && n - oneCount >= 0) {
            option1 = 1 + bruteForce(index + 1, strs, m - zeroCount, n - oneCount, countsMap);
        }

        // exclude the str[index]
        int option2 = bruteForce(index + 1, strs, m, n, countsMap);

        return Math.max(option1, option2);
    }

    private static int memoization(int index, String[] strs, int m, int n, Map<String, Map<Character, Integer>> countsMap,
                                   Map<String, Integer> cache) {
        if (index == strs.length) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 0;
        }

        if (cache.containsKey(index + ":" + m + ":" + n)) {
            return cache.get(index + ":" + m + ":" + n);
        }

        // include the key at strs[index]
        Map<Character, Integer> characterIntegerMap = countsMap.get(strs[index]);
        Integer zeroCount = characterIntegerMap.get('0');
        Integer oneCount = characterIntegerMap.get('1');
        int option1 = 0;
        if (m - zeroCount >= 0 && n - oneCount >= 0) {
            option1 = 1 + memoization(index + 1, strs, m - zeroCount, n - oneCount, countsMap, cache);
        }

        // exclude the str[index]
        int option2 = memoization(index + 1, strs, m, n, countsMap, cache);
        cache.put(index + ":" + m + ":" + n, Math.max(option1, option2));
        return cache.get(index + ":" + m + ":" + n);
    }


    private static int memoizationDp(int index, String[] strs, int m, int n, Map<String, Map<Character, Integer>> countsMap,
                                     int[][][] cache) {
        if (index == strs.length) {
            return 0;
        }

        if (m == 0 && n == 0) {
            return 0;
        }

        if (cache[index][m][n] != 0) {
            return cache[index][m][n];
        }

        // include the key at strs[index]
        Map<Character, Integer> characterIntegerMap = countsMap.get(strs[index]);
        Integer zeroCount = characterIntegerMap.get('0');
        Integer oneCount = characterIntegerMap.get('1');
        int option1 = 0;
        if (m - zeroCount >= 0 && n - oneCount >= 0) {
            option1 = 1 + memoizationDp(index + 1, strs, m - zeroCount, n - oneCount, countsMap, cache);
        }

        // exclude the str[index]
        int option2 = memoizationDp(index + 1, strs, m, n, countsMap, cache);
        cache[index][m][n] = Math.max(option1, option2);
        return cache[index][m][n];
    }

    public static int dp(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (String str : strs) {
            // count no of 0's and 1's in the string
            int zeros = 0, ones = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    zeros++;
                else
                    ones++;
            }

            // now using the zeros and ones count compute the dp
            for (int i = m; i >= zeros; i--) {
                for (int j = n; j >= ones; j--) {
                    dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
                }
            }
        }

        return dp[m][n];
    }
}
