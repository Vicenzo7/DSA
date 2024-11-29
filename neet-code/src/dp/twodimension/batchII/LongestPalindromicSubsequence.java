package dp.twodimension.batchII;

public class LongestPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "bbbab";
        System.out.println(longestPalindromeSubseq(s));
    }

    static
    public int longestPalindromeSubseq(String s) {
        return dfs(0, s.length() - 1, s, new Integer[s.length()][s.length()]);
    }

    static
    private int dfs(int start, int end, String s, Integer[][] cache) {
        if (start > end) {
            return 0;
        }

        if (cache[start][end] != null) {
            return cache[start][end];
        }

        int ans = 0;

        // if characters are equal
        if (s.charAt(start) == s.charAt(end)) {
            // if index are on the same point
            if (start == end) {
                ans = 1 + dfs(start + 1, end - 1, s, cache);
            } else {
                ans = 2 + dfs(start + 1, end - 1, s, cache);
            }
        } else {
            // exclude start
            int option1 = dfs(start + 1, end, s, cache);
            // exclude end
            int option2 = dfs(start, end - 1, s, cache);
            ans = Math.max(option1, option2);
        }

        return cache[start][end] = ans;
    }
}
