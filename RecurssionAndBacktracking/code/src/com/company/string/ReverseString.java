package com.company.string;

import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {

        String s = "babbar";
//        char[] ch = s.toCharArray();
//        solve(ch,0,s.length()-1);
//        s = new String(ch);
//        System.out.println(s);
        StringBuilder sb = new StringBuilder();
        solve2(0,s,sb);
        System.out.println(sb.toString());

    }

    private static void solve2(int index,String s, StringBuilder sb) {

        if(index == s.length()){
            return ;
        }

        solve2(index+1,s,sb);

        sb.append(s.charAt(index));
    }


    static void solve(char[] s, int i, int j) {

        // base case
        if (i >= j) {
            return;
        }

        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;

        solve(s,i+1,j-1);

    }


}
