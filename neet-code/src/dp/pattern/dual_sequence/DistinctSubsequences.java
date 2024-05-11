package dp.pattern.dual_sequence;

import java.util.HashMap;
import java.util.Map;

public class DistinctSubsequences {
    public static void main(String[] args) {
        String s = "rabbbit", t = "rabbit";
        s = "babgbag";
        t = "bag";
        System.out.println(numDistinct(s, t));
    }

    public static int numDistinct(String s, String t) {
        System.out.println(bruteForce(0, 0, s, t));
        return memoization(0, 0, s, t, new HashMap<>());

    }

    public static int bruteForce(int i, int j, String s, String t) {
        if (i == s.length()) {
            return 0; // if i goes out of bound
        }

        int ans = 0;
        // if characters are equal
        if (s.charAt(i) == t.charAt(j)) {
            // if j is at last index, means we have found one match, so count that match and
            // check if more matches exist
            if (j == t.length() - 1) {
                ans = 1 + bruteForce(i + 1, j, s, t);
            } else {
                // either match can be formed with including ith character or excluding ith
                // character
                ans = bruteForce(i + 1, j + 1, s, t) + bruteForce(i + 1, j, s, t);
            }
        } else {
            // since ith and jth character dont match we proceed with next character of s to
            // check if the match exist
            ans = bruteForce(i + 1, j, s, t);
        }

        return ans;
    }

    public static int memoization(int i, int j, String s, String t, Map<String, Integer> cache) {
        if (i == s.length()) {
            return 0; // if i goes out of bound
        }

        if (cache.containsKey(i + ":" + j)) {
            return cache.get(i + ":" + j);
        }

        int ans = 0;
        // if characters are equal
        if (s.charAt(i) == t.charAt(j)) {
            // if j is at last index, means we have found one match, so count that match and
            // check if more matches exist
            if (j == t.length() - 1) {
                ans = 1 + memoization(i + 1, j, s, t, cache);
            } else {
                // either match can be formed with including ith character or excluding ith
                // character
                ans = memoization(i + 1, j + 1, s, t, cache) + memoization(i + 1, j, s, t, cache);
            }
        } else {
            // since ith and jth character don't match we proceed with next character of s to
            // check if the match exist
            ans = memoization(i + 1, j, s, t, cache);
        }
        cache.put(i + ":" + j, ans);
        return ans;
    }
}
