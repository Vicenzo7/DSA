package dp.onedimension.batchII;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LongestStringChain {
    public static void main(String[] args) {
        String[] words = {"a", "b", "ba", "bca", "bda", "bdca"};
        System.out.println(longestStrChain(words));
    }

    /*

        1.Instead of inserting character, trying removing character and check predecessor
        2.Start from the largest word, sort the array for that
        3. Use hash map to store word to index
        4. And for each word try to check longest string chain
        5. Start with the longest word and remove it character one by one and check if
        predecessor can be formed, if predecessor can be formed, start dfs from that index.
        6. cache your result

        TC = O(n * l)
        dfs function is going to run n times, and we are iterating each word so average length of word consider l

        SC = O(n)

    */

    public static int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> Integer.compare(b.length(), a.length()));

        Map<String, Integer> wordIndexMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordIndexMap.put(words[i], i);
        }

        Integer[] dp = new Integer[words.length];
        for (int i = 0; i < words.length; i++) {
            dfs(i, words, wordIndexMap, dp);
        }

        return Arrays.stream(dp).max(Integer::compare).orElse(0);
    }

    private static int dfs(int index, String[] words, Map<String, Integer> wordIndexMap, Integer[] dp) {
        if (dp[index] != null) {
            return dp[index];
        }

        int result = 1; // each word itself is lsc
        String word = words[index];
        for (int i = 0; i < word.length(); i++) {
            // removing the ith char to form a predecessor
            String predecessor = word.substring(0, i) + word.substring(i + 1);
            if (wordIndexMap.containsKey(predecessor)) {
                Integer predecessorIndex = wordIndexMap.get(predecessor);
                result = Math.max(result, 1 + dfs(predecessorIndex, words, wordIndexMap, dp));
            }
        }
        return dp[index] = result;
    }
}
