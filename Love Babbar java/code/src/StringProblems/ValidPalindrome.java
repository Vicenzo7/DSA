package StringProblems;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        str = str.replaceAll("[^a-z0-9]", "");

        int left = 0; int right = str.length()-1;
        while(left < right){
            if(str.charAt(left++) != str.charAt(right--))
                return false;
        }
        return true;
    }

}
