package Problems;

import java.util.ArrayList;
import java.util.List;

public class ReplaceWords {

    public static void main(String[] args) {
        List<String> dictionary =  new ArrayList<>();
        dictionary.add("cat");
        dictionary.add("bat");
        dictionary.add("rat");
        String sentence = "the cattle was rattled by the battery";
        ReplaceWords obj = new ReplaceWords();
        System.out.println(obj.replaceWords(dictionary,sentence));

    }
    public    String replaceWords(List<String> dictionary, String sentence) {
        Trie trie = new Trie();
        for(String s:dictionary){
            trie.insert(s);
        }

        String[] words = sentence.split(" ");

        for(int i=0;i<words.length;i++){
            words[i] = trie.replace(words[i]);
        }

        StringBuilder sb = new StringBuilder(words[0]);
        for(int i=1;i<words.length;i++){
            sb.append(" ");
            sb.append(words[i]);
        }
        return sb.toString();
    }


    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode('\0');
        }


        // insert
        void insert(String word){
            insertRec(root,word);

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
        public String replace(String word){
            TrieNode prev = root;

            if (prev.children[word.charAt(0) - 'a'] == null)
                return word;

            StringBuilder sb = new StringBuilder();
            for(int i=0;i<word.length();i++){
                if((prev.children[word.charAt(i) - 'a']) != null){
                    prev = prev.children[word.charAt(i) - 'a'];
                    sb.append(word.charAt(i));
                }else{
                    return word;
                }

                if(prev.isTerminal){
                    return sb.toString();
                }
            }
            return word;
        }

    }


}
