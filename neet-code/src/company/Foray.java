package company;

public class Foray {


    /*

    Given a string str, the task is to find the longest substring which is a palindrome.

    Input: str = “forgeeksskeegfor”
    Output: “geeksskeeg”
    Explanation: There are several possible palindromic substrings
    like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest among all.


    */
    public static void main(String[] args) {
        String s = "forgeeksskeegfor";
        System.out.println(solve(s));
    }

    public static String solve(String s) {

        String ans = "";

        for (int i = 0; i < s.toCharArray().length; i++) {
            // for odd case
            int left = i;
            int right = i;

            ans = helper(left, right, s, ans);


            // for even case
            right = i + 1;
            ans = helper(left, right, s, ans);
        }

        return ans;
    }

    private static String helper(int left, int right, String s, String ans) {
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
