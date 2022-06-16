package MediumString;

public class SplitTwoStringsToMakePalindrome {
    public static void main(String[] args) {
       String  a = "ulacfd", b = "jizalu";
        System.out.println(checkPalindromeFormation(a,b));
    }


    //brute force
//    public static boolean checkPalindromeFormation(String a, String b) {
//
//        for(int i=0;i<a.length();i++)
//        {                    //prefix of a       //suffix of b                      //prefiix of b    //suffix of a
//            if(isPalindrome(a.substring(0,i) + b.substring(i)) || isPalindrome(b.substring(0,i) + a.substring(i)) )
//                return true;
//        }
//        return false;
//    }
//
//    public static boolean isPalindrome(String str)
//    {
//        int start=0;
//        int end =str.length()-1;
//
//        while(start<end)
//        {
//            if(str.charAt(start)!=str.charAt(end))
//                return false;
//            start++;
//            end--;
//        }
//        return true;
//    }


    //optimised
    public static boolean checkPalindromeFormation(String a, String b) {
        return check(a, b) || check(b, a);
    }

    public static boolean check(String a, String b) {
        int i = 0;
        int j = b.length()-1;
        while (i < j) {
            //check if a and b are palindrome
            if(a.charAt(i) == b.charAt(j)){
                i++;
                j--;
            }
            //when we find that certain elements are palindrome or they arent palindrome we break;
            else{
                break;
            }
        }
        //checking if any of them is palindrome if starting of a and ending elements of b match
        return isPalindrome(a, i, j) || isPalindrome(b, i, j);

    }

    public static boolean isPalindrome(String s, int i , int j ){
        while(i < j){
            if(s.charAt(i) != s.charAt(j)){
                return false;
            }
            i++;
            j--;

        }
        return true;
    }

}
