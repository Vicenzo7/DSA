package com.company.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/word-break/
public class WordBreak {


    public static void main(String[] args) {
        String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaab";

        String[] dict = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa"};

        List<String> wordDict = Arrays.asList(dict);

        System.out.println(wordBreak(s, wordDict));
    }


    // will give TLE

//    public static boolean wordBreak(String s, List<String> wordDict) {
//
//        HashSet<String> set = new HashSet<>();
//
//        for(String str : wordDict){
//            set.add(str);
//        }
//
//        return solve(0,s,set,s.length());
//
//    }

//    private static boolean solve(int index ,String s, HashSet<String> set, int length) {
//
//        if(index == length)
//            return true;
//
//
//
//        StringBuilder word = new StringBuilder();
//        for (int i = 0; i <s.length() ; i++) {
//
//            word.append(s.charAt(i));
//            if(set.contains(word.toString()) && solve(index+i+1,s.substring(i+1),set,length))
//            {
//                return true;
//            }
//        }
//        return false;
//    }


    public static boolean wordBreak(String s, List<String> wordDict) {
        // for memoization
        HashMap<String, Boolean> map = new HashMap<>();
        return canConstruct(s, wordDict, map);
    }

    public static boolean canConstruct(String target, List<String> words, HashMap<String, Boolean> map) {

        // if answer already cached, return it
        if (map.containsKey(target))
            return map.get(target);

        // if target string is empty
        // it can always be constructed by taking no elements from dictionary
        if (target.isEmpty())
            return true;

        // for all words in the dictionary
        for (String word : words) {
            // if the target starts with the given word
            if (target.startsWith(word)) {
                // and it is possible to construct the rest of the string
                // from the words in the dictionary
                if (canConstruct(target.substring(word.length()), words, map)) {

                    // save and return true
                    map.put(target, true);
                    return true;
                }
            }
        }

        // if it was not possible to construct the target from words from the dictionary
        // save and return false to the previous call
        map.put(target, false);
        return false;
    }

}
