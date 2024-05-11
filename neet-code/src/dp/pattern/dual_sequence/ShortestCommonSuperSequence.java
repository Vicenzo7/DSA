package dp.pattern.dual_sequence;

public class ShortestCommonSuperSequence {
    public static void main(String[] args) {
        String str1 = "abac", str2 = "cab";
        System.out.println(shortestCommonSupersequence(str1, str2));
    }


    public static String shortestCommonSupersequence(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        // Create a DP table to store the length of the shortest common super sequence
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        // traverse from back to find the lcs string
        StringBuilder sb = new StringBuilder();
        int i = m;
        int j = n;
        while (i > 0 && j > 0) {
            // if the characters are equal they are part of lcs
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.insert(0, str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                //If dp[i-1][j] is greater, it means that excluding the character at index i-1 in str1 leads to a longer
                // common subsequence, so we insert that character into the result string and move up (i--).
                sb.insert(0, str1.charAt(i - 1));
                i--;
            } else {
//                    If dp[i][j-1] is greater, it means that excluding the character at index j-1 in str2 leads to a longer
//                    common subsequence,so we insert that character into the result string and move left (j--).
                sb.insert(0, str2.charAt(j - 1));
                j--;
            }
        }

        if (i >= 0) {
            sb.insert(0, str1.substring(0, i));
        }
        if (j >= 0) {
            sb.insert(0, str2.substring(0, j));

        }

        return sb.toString();
    }

}