package com.deepraj;


public class Palindrome {
    public static void main(String[] args) {
        String pali = "abcdcba";
        boolean ans=isPalindrome(pali);
        if(ans){
            System.out.println("Palindrome");
        }
        else{
            System.out.println("not palindrome");
        }
//        StringBuilder sb = new StringBuilder(pali);
//        String reverse = String.valueOf(sb.reverse());
//        if(pali.equals(reverse))
//            System.out.println("Palindrome");
//        else
//            System.out.println("not palindrome");

    }

    static  boolean isPalindrome(String str)
    {
        str=str.toLowerCase();
        int n = str.length();
        for (int i = 0; i < str.length()/2 ; i++) {
            if(str.charAt(i) != str.charAt(n-i-1))
            {
                return false;
            }  
        }
        return true;
    }
}
