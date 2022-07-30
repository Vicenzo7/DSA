package com.company;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    void insert(String word){
        insertRec(root,word);
        System.out.println("Insert success");
    }

    void insertRec(TrieNode root, String str){
        //base case
        if(str.length() == 0){
            root.isTerminal = true;
            return;
        }
        //current char fetch
        char ch = str.charAt(0);
        //mapping char to an index integer
        int index = ch-'a';
        TrieNode child;

        // 2 cases exist

        // the alphabet is already present
        if(root.children[index]!=null){
            // if present to that the child(alphabet)
            child = root.children[index];
        }else{ // no such alphabet exist
            //create a child and link it
            child = new TrieNode(ch);
            root.children[index] = child;
        }
        //recursion will take care of remaining string
        insertRec(child,str.substring(1));

    }


    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal;

        public TrieNode(char data) {
            this.data = data;
            isTerminal = false;
            for (int i = 0; i <26 ; i++) {
                children[i] =null;
            }
        }
    }

    boolean search(String word){
        return searchRec(root,word);
    }

    private boolean searchRec(TrieNode root, String str) {
        //Base case
        if(str.length()==0){
            return root.isTerminal;
        }
        // fetch current char
        char ch = str.charAt(0);
        //mapping char to an index integer
        int index = ch-'a';

        TrieNode child ;
        // 2 cases exist

        // the alphabet is already present
        if(root.children[index]!=null){
            // if present to that the child(alphabet)
            child = root.children[index];
        }else{ // no such alphabet exist
            return false;
        }

        //recursion
        return searchRec(child,str.substring(1));

    }

    public static void main(String[] args) {
	    Trie trie = new Trie();
        trie.insert("code");
        trie.insert("coding");
        trie.insert("codemonk");
        trie.insert("coder");
        trie.insert("codee");

        System.out.println(trie.search("code"));
        System.out.println(trie.search("coding"));
        System.out.println(trie.search("codemonk"));
        System.out.println(trie.search("coder"));
        System.out.println(trie.search("codee"));
        System.out.println(trie.search("codi"));
        System.out.println(trie.search("cody"));

    }
}
