package dp.onedimension;

import java.util.*;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        List<String> wordDict = List.of("leet", "code");

        s = "applepenapple";
        wordDict = List.of("apple", "pen");

        s = "catsandog";
        wordDict = List.of("cats", "dog", "sand", "and", "cat");

        s = "cars";
        wordDict = List.of("car", "ca", "rs");
        System.out.println(wordBreak(s, wordDict));
    }

    public static boolean wordBreak(String s, List<String> wordDict) {
//        return bruteForce(s, wordDict);
        return memoization(s, wordDict, new HashMap<>());
//        return memoization(s, 0, new HashSet<>(wordDict), new Boolean[s.length()]);
    }


    private static boolean memoization(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            // use the word
            if (s.startsWith(word) && memoization(s.substring(word.length()), wordDict, cache)) {
                cache.put(s, true);
                return true;
            }
        }
        cache.put(s, false);
        return false;
    }



    // can use for word concatenation

    private static boolean memoization(String word, int start, Set<String> wordDict, Boolean[] cache) {

        if (start == word.length()) {
            return true;
        }

        if (cache[start] != null) {
            return cache[start];
        }

        for (int end = start + 1; end <= word.length(); end++) {
            if (wordDict.contains(word.substring(start, end))
                    && memoization(word, end, wordDict, cache)) {
                return cache[start] = true;
            }
        }

        return cache[start] = false;
    }

    private static boolean bruteForce(String s, List<String> wordDict) {
        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                // use the word
                if (bruteForce(s.substring(word.length()), wordDict)) {
                    return true;
                }
            }
        }

        return false;
    }
}
