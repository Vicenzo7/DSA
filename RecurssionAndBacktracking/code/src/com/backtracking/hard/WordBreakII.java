package com.backtracking.hard;

import java.util.*;

//https://leetcode.com/problems/word-break/
public class WordBreakII {


    public static void main(String[] args) {

        String s = "pineapplepenapple";
        String[] dict = {"apple","pen","applepen","pine","pineapple"};
        //  ["pine apple pen apple","pineapple pen apple","pine applepen apple"]
        List<String> wordDict = Arrays.asList(dict);

        System.out.println(wordBreak(s, wordDict));
    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        HashSet<String> set = new HashSet<>(wordDict);

        List<String> ans = new ArrayList<>();
        StringBuilder temp = new StringBuilder();
        solve(0,s,set,ans,temp);
        return ans;
    }

    private static void solve(int index ,String s, HashSet<String> set, List<String> ans,StringBuilder temp) {

        if(index == s.length()){
            ans.add(temp.toString().trim());
            return ;
        }
        StringBuilder word = new StringBuilder();
        for (int i = index; i <s.length() ; i++) {
            word.append(s.charAt(i));
            if (set.contains(word.toString())) {
                int length = temp.length();
                solve(i + 1, s,set,ans,temp.append(word).append(" "));
                temp.setLength(length);
            }
        }
    }
}
