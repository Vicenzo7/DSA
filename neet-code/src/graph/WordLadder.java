package graph;

import java.util.*;

public class WordLadder {
    public static void main(String[] args) {
        String beginWord = "hit", endWord = "cog";
        List<String> wordList = new ArrayList<>(List.of("hot", "dot", "dog", "lot", "log", "cog"));
        System.out.println(ladderLength(beginWord, endWord, wordList));
    }


    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) { // check if destination is there in graph
            return 0;
        }

        // add beingWord in wordList
        wordList.add(beginWord);

        // creating adjacency list
        Map<String, List<String>> patternToStringList = new HashMap<>();
        for (String word : wordList) { // n
            for (int i = 0; i < word.length(); i++) { // m
                String pattern = word.substring(0, i) + "*" + word.substring(i + 1);
                patternToStringList.computeIfAbsent(pattern, k -> new ArrayList<>()).add(word);
                // eg one pattern of hot is =   * o t -> map to [hot,dot,lot]
            }
        }

        // now run bfs
        Deque<String> deque = new ArrayDeque<>();
        Set<String> visit = new HashSet<>();

        deque.add(beginWord);
        visit.add(beginWord);

        int shortLength = 1;

        while (!deque.isEmpty()) {
            int size = deque.size();
            for (int i = 0; i < size; i++) {
                String word = deque.removeFirst();
                if (word.equals(endWord)) { // word is equal to endWOrd
                    return shortLength;
                }

                for (int j = 0; j < word.length(); j++) { // create word pattern anc get it's all neighbors
                    String pattern = word.substring(0, j) + "*" + word.substring(j + 1);
                    List<String> patternMatchingWords = patternToStringList.get(pattern);
                    for (String patternMatchingWord : patternMatchingWords) {
                        if (visit.contains(patternMatchingWord)) {
                            continue;
                        }
                        deque.add(patternMatchingWord);
                        visit.add(patternMatchingWord);
                    }
                }
            }
            shortLength++;
        }
        return 0;
    }
}
