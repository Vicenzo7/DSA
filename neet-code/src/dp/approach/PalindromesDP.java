package dp.approach;

public class PalindromesDP {
    public static void main(String[] args) {
        /*
            Given a string s, return the length of the longest
            palindromic substring within s.
        */

        String s = "abaab";
        System.out.println(longestPalindromeSubString(s));
    }



    /*
        Brute force approach TC = O(n^3)

        If we have a letter of n length, then we have (n.(n+1)) / 2 substring
        To create these substring TC = O(n^2), and to check if these string are palindrome,
        by two pointer technique TC = O(n).

     */

    // Optimised way TC = O(n^2)
    private static int longestPalindromeSubString(String s) {
        int length = 0;

        for (int i = 0; i < s.length(); i++) {
            // odd length
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    length = right - left + 1;
                }
                left -= 1;
                right += 1;
            }

            // even length
            left = i;
            right = i + 1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if (right - left + 1 > length) {
                    length = right - left + 1;
                }
                left -= 1;
                right += 1;
            }
        }

        return length;
    }

}
