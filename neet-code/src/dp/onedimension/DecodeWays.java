package dp.onedimension;

import java.util.HashMap;
import java.util.Map;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "";
        System.out.println(numDecodings(s));
    }


    public static int numDecodings(String s) {
        System.out.println(dp(s));

        Map<Integer, Integer> cache = new HashMap<>();
        cache.put(s.length(), 1);
        return memoization(0, s, cache);
    }


    // TC = O(n) SC = O(1)
    private static int dp(String s) {
        int twoBack = 1; // emptyString
        int oneBack = s.charAt(0) == '0' ? 0 : 1; // if 0 no count
        int current = oneBack;
        for (int i = 2; i < s.length() + 1; i++) {
            current = 0;
            // check if previous char was not '0' so we can consider it as one digit
            if (s.charAt(i - 1) != '0') {
                current += oneBack;
            }

            if ((s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))) {
                current += twoBack;
            }

            twoBack = oneBack;
            oneBack = current;
        }

        return current;
    }

    // TC = O(n) SC = O(n)

    public static int memoization(int i, String s, Map<Integer, Integer> cache) {
        if (cache.containsKey(i)) {
            return cache.get(i);
        }

        // if anything starts with '0' it's not valid
        if (s.charAt(i) == '0') {
            return 0;
        }

        int result = memoization(i + 1, s, cache);

        // check if two digits can be taken
        // if next char in bound and if i == 1 or 2 and if 2 then i+1 is less than 7,
        // then we can count i and i+1 as two digit
        if (i + 1 < s.length() && (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
            result += memoization(i + 2, s, cache);
        }

        cache.put(i, result);
        return result;
    }
}
