package dp.twodimension;

public class RegularMatchingExpression {

    public static void main(String[] args) {
        String s = "a", p = "ab*";
//        String s = "aa", p = "a*";
//        String s = "ab", p = ".*"0;
//        String s = "aab", p = "c*a*b";
//        String s = "mississippi", p = "mis*is*p*.";
//        String s = "ab", p = ".*c";
        System.out.println(isMatch(s, p));
    }

    public static boolean isMatch(String s, String p) {

//        return bruteForce(0, 0, s, p);
        return memoization(0, 0, s, p, new Boolean[s.length() + 1][p.length() + 1]);

    }

    private static boolean bruteForce(int i, int j, String s, String p) {
        // Base case: If both strings are exhausted, return true
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // Base case: If pattern is exhausted but string is not, return false
        if (j >= p.length()) {
            return false;
        }

        // If next character in pattern is followed by '*'
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // If current characters match or pattern has '.'
            if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
                // Try matching 0, 1, or more occurrences of current character
                return bruteForce(i, j + 2, s, p) || bruteForce(i + 1, j, s, p) || bruteForce(i + 1, j + 2, s, p);
            } else {
                // Skip current character and '*' in pattern
                return bruteForce(i, j + 2, s, p);
            }
        }

        // If current characters match or pattern has '.'
        if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')) {
            return bruteForce(i + 1, j + 1, s, p);
        }

        // Characters don't match
        return false;
    }


    private static boolean memoization(int i, int j, String s, String p, Boolean[][] cache) {
        // Base case: If both strings are exhausted, return true
        if (i >= s.length() && j >= p.length()) {
            return true;
        }

        // Base case: If pattern is exhausted but string is not, return false
        if (j >= p.length()) {
            return false;
        }

        if (cache[i][j] != null) {
            return cache[i][j];
        }


        // If next character in pattern is followed by '*'
        boolean matchFirstCharacter = i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
        if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
            // If current characters match or pattern has '.'
            if (matchFirstCharacter) {
                // Try matching 0, 1, or more occurrences of current character
                    // don't use star                           use the * once
                return cache[i][j] = memoization(i, j + 2, s, p, cache)  || memoization(i + 1, j + 2, s, p, cache)
                        || memoization(i + 1, j, s, p, cache); // use the * many times
            } else {
                // Skip current character and '*' in pattern
                return cache[i][j] = memoization(i, j + 2, s, p, cache);
            }
        }

        // If current characters match or pattern has '.'
        if (matchFirstCharacter) {
            return cache[i][j] = memoization(i + 1, j + 1, s, p, cache);
        }

        // Characters don't match
        return cache[i][j] = false;
    }

}
