package trie.implementation;

import java.util.HashMap;
import java.util.Map;

public class TrieNode {
    public Map<Character, TrieNode> children;
    public boolean isWordEnd;

    public TrieNode() {
        this.children = new HashMap<>();
    }
}
