package EasyString;

public class ValidPalindrome {
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        System.out.println(isPalindrome(str));
    }

    private static boolean isPalindrome(String str) {

        str= str.toLowerCase();
        str=str.replaceAll("[^A-Za-z0-9]","");

        int start=0,end=str.length()-1;
        while(start<end)
        {
            if(str.charAt(start++) != str.charAt(end--))
                return false;
        }

        return true;
    }
}
