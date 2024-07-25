package dp.onedimension.batchII;

import java.util.*;

public class ConcatenatedWords {
    public static void main(String[] args) {
//        String[] words = {"cat", "dog", "catdog"};
        String[] words = {"cat", "cats", "catsdogcats", "dog", "dogcatsdog", "hippopotamuses", "rat", "ratcatdogcat"};
        System.out.println(findAllConcatenatedWordsInADict(words));
    }

    static
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        // sorting words from small length to big
        Arrays.sort(words, Comparator.comparingInt(String::length));

        List<String> result = new ArrayList<>();
        Set<String> preWords = new HashSet<>();

        // check if each word is a concatenated word
        for (String word : words) {
            if (dfs(word, 0, preWords, new Boolean[word.length()])) {
                result.add(word);
            }
            preWords.add(word);
        }

        return result;
    }

    static
    public boolean dfs(String word, int start, Set<String> wordDictionary, Boolean[] cache) {
        // if wordDictionary is empty word cannot be formed
        if (wordDictionary.isEmpty()) {
            return false;
        }

        if (start == word.length()) {
            return true;
        }

        if (cache[start] != null) {
            return cache[start];
        }

        // Iterating the word and checking if its substring exist in wordDictionary
        for (int end = start + 1; end <= word.length(); end++) {
            // if substring existing making further call is further word exists
            if (wordDictionary.contains(word.substring(start, end)) &&
                    dfs(word, end, wordDictionary, cache)) {
                return cache[start] = true;
            }
        }

        return cache[start] = false;
    }
}
