package com.company.medium;

//https://leetcode.com/problems/wildcard-matching/

// Dp Question

public class WildcardMatching {
    public static void main(String[] args) {
        String s = "aa", p = "*";
        System.out.println(isMatch(s,p));

    }

    public static boolean isMatch(String s, String p) {
        return solve(s,p,s.length(),p.length());
    }



    public static boolean solve(String a,String b,int i, int j){
        // base case

        if(i==0 && j == 0)
            return true;
        // patern got over
        if(i>0 && j==0)
            return false;

        // string got over
        if(i==0 && j>0){
            // if * than good else return false
            for(int k=j-1; k>0;k--){
                if(b.charAt(k) != '*')
                    return false;
            }

            return true;
        }

        // if char at i and j match or the pattern has '?' procced
        if(a.charAt(i-1) == b.charAt(j-1)  || b.charAt(j-1) == '?'){
            return solve(a,b,i-1,j-1);

        }
        else if(b.charAt(j-1) == '*'){

            return solve(a,b,i,j-1) || solve(a,b,i-1,j) ;
        }
        else{
            return false;
        }


    }
}
