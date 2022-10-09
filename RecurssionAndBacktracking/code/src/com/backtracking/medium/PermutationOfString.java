package com.backtracking.medium;

import java.util.ArrayList;

public class PermutationOfString {
    public static void main(String[] args) {
        String str = "abcd";
        System.out.println(generatePermutations(str));
    }

    private static ArrayList<String> generatePermutations(String str) {
        ArrayList<String> ans = new ArrayList<>();
        char[] ch = str.toCharArray();
        solve(ch,0,ans);

        return ans;
    }

    private static void solve(char[] ch, int index, ArrayList<String> ans) {
        // base case;
        if(index == ch.length){
            String s = String.valueOf(ch);
            ans.add(s);
            return;
        }


        for (int i = index; i <ch.length ; i++) {
            swap(ch,i,index);
            solve(ch,index+1,ans);
            swap(ch,i,index);
        }
    }

    private static void swap(char[] ch, int i, int j) {
        char temp = ch[i];
        ch[i]= ch[j];
        ch[j]= temp;
    }
}
