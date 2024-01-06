package trie.implementation;

public class Trie {

     TrieNode root;

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
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
        TrieNode curr = this.root;
        for (char c : word.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return curr.isWordEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = this.root;
        for (char c : prefix.toCharArray()) {
            if (!curr.children.containsKey(c)) {
                return false;
            }
            curr = curr.children.get(c);
        }
        return true;
    }
}
