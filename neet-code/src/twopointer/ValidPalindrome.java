package twopointer;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(s));
    }

//    public static boolean isPalindrome(String s) {
//        s = s.toLowerCase();
//        s = s.replaceAll("[^a-z0-9]","");
//        int i = 0, j = s.length() - 1;
//        while (i < j) {
//            if (s.charAt(i) != s.charAt(j)) return false;
//            i++;
//            j--;
//        }
//
//        return true;
//    }

    public static boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0, right = s.length() - 1;
        while (left < right) {
            while (left < right && !isAlphanumeric(s.charAt(left))) left++;
            while (right > left && !isAlphanumeric(s.charAt(right))) right--;

            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }

    public static boolean isAlphanumeric(char ch) {
        // Check if the character is a letter (uppercase or lowercase) or a digit
        return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9');
    }
}
