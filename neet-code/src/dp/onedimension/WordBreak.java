package dp.onedimension;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    }

    private static boolean memoization(String s, List<String> wordDict, Map<String, Boolean> cache) {
        if (cache.containsKey(s)) {
            return cache.get(s);
        }

        if (s.isEmpty()) {
            return true;
        }

        for (String word : wordDict) {
            if (s.startsWith(word)) {
                // use the word
                if (memoization(s.substring(word.length()), wordDict, cache)) {
                    cache.put(s, true);
                    return true;
                }
            }
        }
        cache.put(s, false);
        return false;
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
