package RecursionYT;


public class Palindrome {
    public static void main(String[] args) {

        String str = "BookkooB";
        boolean ans = isPalindrome(str,0);
        if(ans)
            System.out.println("Palindrome");
        else
            System.out.println("not palindrome");

    }

    static  boolean isPalindrome(String str,int i)
    {
        int size=str.length();
        //base case
        if(i>size/2)
            return true;

        if(str.charAt(i) != str.charAt(size-i-1))
        {
            return false;
        }else{
            return isPalindrome(str,++i);
        }

    }
}
