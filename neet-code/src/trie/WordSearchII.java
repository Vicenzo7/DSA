package trie;

import trie.implementation.TrieNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
    // Instead of checking a single word exist, we will check simultaneously if many words
    // can be created from one index

    public static void main(String[] args) {
        char[][] board = {{'o', 'a', 'b', 'n'},
                {'o', 't', 'a', 'e'},
                {'a', 'h', 'k', 'r'}, {'a', 'f', 'l', 'v'}};
        String[] words = {"oa", "oaa"};

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {
        // first add all the words in a Trie
        TrieNode root = new TrieNode();
        for (String word : words) {
            insertWord(root, word);
        }

        int rows = board.length;
        int cols = board[0].length;
        Set<String> result = new HashSet<>();
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                dfs(row, col, rows, cols, board, root, "", result);
            }
        }

        return new ArrayList<>(result);

    }

    private static void dfs(int row, int col, int maxRows, int maxCols, char[][] board, TrieNode root, String word, Set<String> result) {
        // base case, check out of bound and if the char not already visited or that char does not exist in the trie
        if (row < 0 || row == maxRows || col < 0 || col == maxCols ||
                board[row][col] == '#' ||
                !root.children.containsKey(board[row][col])) {
            return;
        }

        // mark visited
        char ch = board[row][col];
        board[row][col] = '#';
        root = root.children.get(ch); // move to that ch in the trie
        word += ch; // add that ch to the word
        if (root.isWordEnd) { // if the ch is the trie is end of the word add to our list
            result.add(word);
        }

        dfs(row, col - 1, maxRows, maxCols, board, root, word, result); // left
        dfs(row, col + 1, maxRows, maxCols, board, root, word, result); // right
        dfs(row - 1, col, maxRows, maxCols, board, root, word, result); // up
        dfs(row + 1, col, maxRows, maxCols, board, root, word, result); // dow

        board[row][col] = ch; // mark unvisited
    }

    public static void insertWord(TrieNode root, String word) {
        TrieNode curr = root;
        for (char ch : word.toCharArray()) {
            if (!curr.children.containsKey(ch)) {
                curr.children.put(ch, new TrieNode());
            }
            curr = curr.children.get(ch);
        }
        curr.isWordEnd = true;
    }
}
