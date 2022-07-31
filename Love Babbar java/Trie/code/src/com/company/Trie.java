package com.company;

public class Trie {
    TrieNode root;

    public Trie() {
        root = new TrieNode('\0');
    }

    
    // insert
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
            // if present go to that the child(alphabet)
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

    //search
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
            // if present go to that the child(alphabet)
            child = root.children[index];
        }else{ // no such alphabet exist
            return false;
        }

        //recursion
        return searchRec(child,str.substring(1));

    }
    
    
    
    void delete(String word){
        deleteRec(root,word);
    }

    private TrieNode deleteRec(TrieNode root, String str) {
        // if trie is empty
        if(root == null)
            return null;

        //check if last character
        if(str.length()==0){
            //check if this is terminal,if yes mark it false as it's no longer terminal
            if(root.isTerminal){
                root.isTerminal=false;
            }

            //check if it has children
            if(getChildCount(root) == 0){
                root = null;
            }

            return root;
        }

        // if not a last character traverse till the last character
        char ch = str.charAt(0);
        int index = ch-'a';
        root.children[index] = deleteRec(root.children[index],str.substring(1));

        // If root does not have any child (its only child got
        // deleted), and it is not end of another word.
        if (getChildCount(root) == 0 && root.isTerminal == false){
            root = null;
        }

        return root;


    }
    int getChildCount(TrieNode temp)  {
        int count = 0;

        for(int i=0; i<26; i++) {
            if(temp.children[i] != null)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
	    Trie trie = new Trie();
        trie.insert("code");
        trie.insert("coding");
        trie.insert("codemonk");
        trie.insert("coder");
        trie.insert("codee");

//        System.out.println(trie.search("code"));
//        System.out.println(trie.search("coding"));
//        System.out.println(trie.search("codemonk"));
//        System.out.println(trie.search("coder"));
//        System.out.println(trie.search("codee"));
//        System.out.println(trie.search("codi"));
//        System.out.println(trie.search("cody"));
//
        trie.delete("codemonk");
        trie.delete("coding");
        trie.delete("coder");
        trie.delete("codee");

        System.out.println(trie.search("code"));
        System.out.println(trie.search("codemonk"));
        System.out.println(trie.search("coding"));
        System.out.println(trie.search("coder"));
        System.out.println(trie.search("codee"));

    }
}
