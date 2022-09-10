package com.company.subsequences;
//https://leetcode.com/problems/is-subsequence/
public class IsSubsequence {


    public static void main(String[] args) {
        String s = "abc", t = "ahbgdc";
        System.out.println(isSubsequence(s,t));
    }


    // without recursion

//    public boolean isSubsequence(String s, String t) {
//
//        if(s.length()==0 )
//            return true;
//
//        int j=0;
//        for(int i=0;i<t.length();i++)
//        {
//            if(s.charAt(j)==t.charAt(i))
//            {
//                j++;
//            }
//
//            if(j==s.length())
//            {
//                return true;
//            }
//        }
//        return false;
//
//
//    }


    // using recursion
    public static boolean isSubsequence(String s, String t) {
        if(s.length()==0)
            return true;

        return solve(0,0,s,t);
    }

    static boolean  solve(int i,int j,String s, String t){

        if(i == t.length()){
            return false;
        }


        if(s.charAt(j) == t.charAt(i)){
            j=j+1;
            i=i+1;
            if(j == s.length())
                return true;

            return solve(i,j,s,t);
        }else{
            return  solve(i+1,j,s,t);
        }


    }
}
