package dp.twodimension;

import java.util.HashMap;
import java.util.Map;

public class InterleavingStrings {
    public static void main(String[] args) {
        String s1 = "aabcc", s2 = "dbbca", s3 = "aadbbcbcac";
        System.out.println(isInterleave(s1, s2, s3));

    }

    public static boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

//        return bruteForce(s1, s2, s3);
//        return memoization(s1, s2, s3, new HashMap<>());
        return dp(0, 0, s1, s2, s3, new Boolean[s1.length() + 1][s2.length() + 1]);
    }


    private static boolean bruteForce(String s1, String s2, String s3) {

        if (s3.isEmpty()) {
            return true;
        }

        if (!s1.isEmpty() && !s2.isEmpty() && s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            return bruteForce(s1.substring(1), s2, s3.substring(1))
                    || bruteForce(s1, s2.substring(1), s3.substring(1));

        } else if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
            return bruteForce(s1.substring(1), s2, s3.substring(1));
        } else if (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
            return bruteForce(s1, s2.substring(1), s3.substring(1));
        } else {
            return false;
        }

    }


    // TC = O(m.n) m = len(s1) n = len(s2)

    private static boolean memoization(String s1, String s2, String s3, Map<String, Boolean> cache) {

        if (s3.isEmpty()) {
            return true;
        }

        if (cache.containsKey(s1 + "-" + s2)) {
            return cache.get(s1 + "-" + s2);
        }

        boolean ans;

        if (!s1.isEmpty() && !s2.isEmpty() && s1.charAt(0) == s3.charAt(0) && s2.charAt(0) == s3.charAt(0)) {
            ans = memoization(s1.substring(1), s2, s3.substring(1), cache)
                    || memoization(s1, s2.substring(1), s3.substring(1), cache);

        } else if (!s1.isEmpty() && s1.charAt(0) == s3.charAt(0)) {
            ans = memoization(s1.substring(1), s2, s3.substring(1), cache);
        } else if (!s2.isEmpty() && s2.charAt(0) == s3.charAt(0)) {
            ans = memoization(s1, s2.substring(1), s3.substring(1), cache);
        } else {
            ans = false;
        }

        cache.put(s1 + "-" + s2, ans);
        return ans;
    }


    private static boolean dp(int i, int j, String s1, String s2, String s3, Boolean[][] cache) {

        if (i + j == s3.length()) {
            return true;
        }


        if (cache[i][j] != null) {
            return cache[i][j];
        }

        boolean ans;

        if (i < s1.length() && j < s2.length() && s1.charAt(i) == s3.charAt(i + j) && s2.charAt(j) == s3.charAt(i + j)) {
            ans = dp(i + 1, j, s1, s2, s3, cache) || dp(i, j + 1, s1, s2, s3, cache);

        } else if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
            ans = dp(i + 1, j, s1, s2, s3, cache);
        } else if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
            ans = dp(i, j + 1, s1, s2, s3, cache);
        } else {
            ans = false;
        }

        cache[i][j] = ans;
        return ans;
    }
}
