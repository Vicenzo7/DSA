package basic.recursion;

public class PalindromeString {
    public static void main(String[] args) {
            String str = "moon";
        System.out.println(isPalindrome(str,0,str.length()-1));
    }

    public static boolean isPalindrome(String s, int start, int end) {
        if (start > end) {
            return true;
        }

        if (s.charAt(start) != s.charAt(end)) return false;

        return isPalindrome(s, start+1, end-1);
    }
}
