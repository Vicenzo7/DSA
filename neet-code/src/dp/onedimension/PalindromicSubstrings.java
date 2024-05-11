package dp.onedimension;

public class PalindromicSubstrings {
    public static void main(String[] args) {
        String s = "aaa";
//        Output: 6
//        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
        System.out.println(countSubstrings(s));
    }


    public static int countSubstrings(String s) {
        // Treat ever character as a middle element and expand it from left adn right to
        // check a bigger palindrome substring can be formed
        // once treat the character as a middle element for an odd length string and once
        // treat it for even length string
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i;
            int right = i;
            count = helper(s, left, right, count);

            // even length
            left = i;
            right = i + 1;
            count = helper(s, left, right, count);
        }

        return count;
    }

    public static int helper(String s, int left, int right, int count) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            // means it is a palindrome, because characters are equal
            count++;
            left -= 1;
            right += 1;
        }

        return count;
    }
}
