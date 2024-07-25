package dp.onedimension;

public class LongestPalindromicSubstring {
    public static void main(String[] args) {
        // Treat ever character as a middle element and expand it from left and right to
        // check a bigger palindrome substring can be formed
        // once treat the character as a middle element for a odd length string and once
        // treat it for even length string
        String s = "babad";
        System.out.println(longestPalindrome(s));
    }
    public static String longestPalindrome(String s) {
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i;
            int right = i;
            ans = helper(s, left, right, ans);

            // even length
            left = i;
            right = i + 1;
            ans = helper(s, left, right, ans);
        }

        return ans;
    }

    public static String helper(String s, int left, int right, String ans) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            if (right - left + 1 > ans.length()) {
                ans = s.substring(left, right + 1);
            }
            left -= 1;
            right += 1;
        }

        return ans;
    }

}
