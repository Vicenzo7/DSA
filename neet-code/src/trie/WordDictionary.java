package trie;

import trie.implementation.TrieNode;

public class WordDictionary {
    //https://leetcode.com/problems/design-add-and-search-words-data-structure/

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                curr.children.put(c, new TrieNode());
            }
            curr = curr.children.get(c);
        }
        curr.isWordEnd = true;
    }

    public boolean search(String word) {
        //return searchHelper(this.root, word, 0);
        return searchHelper(this.root, word);
    }


    private boolean searchHelper(TrieNode root, String word, int index) {
        TrieNode curr = root;
        for (int i = index; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch == '.') { // // if . then search for all children if the word can be formed
                for (TrieNode child : curr.children.values()) {
                    if (searchHelper(child, word, i + 1)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (!curr.children.containsKey(ch)) {
                    return false;
                }
                curr = curr.children.get(ch);
            }
        }
        return curr.isWordEnd;
    }

    private boolean searchHelper(TrieNode root, String word) {
        TrieNode curr = root;
        if (word.isEmpty()) {
            return curr.isWordEnd;
        }
        char ch = word.charAt(0);
        if (ch == '.') {
            // If the current character is '.', iterate through all children nodes
            for (TrieNode child : curr.children.values()) {
                if (searchHelper(child, word.substring(1))) {
                    return true;  // Return true if the word is found in any of the children
                }
            }
            return false;  // Return false if the word is not found in any of the children
        }

        if (!curr.children.containsKey(ch)) {
            return false;
        }
        curr = curr.children.get(ch);
        return searchHelper(curr, word.substring(1));
    }


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");

        System.out.println(wordDictionary.search("b.."));
        System.out.println(wordDictionary.search(".ad"));
    }
}
