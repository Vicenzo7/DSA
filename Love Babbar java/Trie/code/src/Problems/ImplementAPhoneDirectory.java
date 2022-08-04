package Problems;
import java.util.ArrayList;

public class ImplementAPhoneDirectory {
class TrieClass {
    TrieNode root;

    public TrieClass() {
        root = new TrieNode('\0');
    }


    // insert
    void insert(String word) {
        insertRec(root, word);

    }

    void insertRec(TrieNode root, String str) {
        //base case
        if (str.length() == 0) {
            root.isTerminal = true;
            return;
        }
        //current char fetch
        char ch = str.charAt(0);
        //mapping char to an index integer
        int index = ch - 'a';
        TrieNode child;

        // 2 cases exist

        // the alphabet is already present
        if (root.children[index] != null) {
            // if present go to that the child(alphabet)
            child = root.children[index];
        } else { // no such alphabet exist
            //create a child and link it
            child = new TrieNode(ch);
            root.children[index] = child;
        }
        //recursion will take care of remaining string
        insertRec(child, str.substring(1));

    }


    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal;

        public TrieNode(char data) {
            this.data = data;
            isTerminal = false;
            for (int i = 0; i < 26; i++) {
                children[i] = null;
            }
        }
    }

    ArrayList<ArrayList<String>> getAns(String word) {
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        TrieNode prev = root;
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            char lastChar = word.charAt(i);
            prefix.append(lastChar);

            TrieNode cur = prev.children[lastChar - 'a'];
            if (cur == null) {
                break;
            } else {
                ArrayList<String> tempAns = new ArrayList<>();
                getNames(cur, prefix, tempAns);
                ans.add(tempAns);
                prev = cur;

            }
        }
        return ans;
    }


    void getNames(TrieNode cur, StringBuilder prefix, ArrayList<String> tempAns) {

        if (cur.isTerminal) {
            tempAns.add(prefix.toString());
        }

        for (char ch = 'a'; ch <= 'z'; ch++) {
            TrieNode next = cur.children[ch - 'a'];
            if (next != null) {
                prefix.append(ch);
                getNames(next, prefix, tempAns);
                prefix.deleteCharAt(prefix.length() - 1);

            }
        }
    }

}


    public static void main(String[] args) {

        ArrayList<String> contactList = new ArrayList<>();
        contactList.add("deepak");
        contactList.add("dipu");
        contactList.add("dipa");
        contactList.add("dipsha");
        contactList.add("didi");
        contactList.add("disha");
        contactList.add("dipuka");

        String query = "dipi";
        ImplementAPhoneDirectory obj = new ImplementAPhoneDirectory();
        ArrayList<ArrayList<String>> ans = obj.phoneDirectory(contactList, query);
        System.out.println(ans);


    }

    public  ArrayList<ArrayList<String>> phoneDirectory(ArrayList<String> contactList, String queryStr) {
        TrieClass trie = new TrieClass();
        for (String s : contactList) {
            trie.insert(s);
        }

        return trie.getAns(queryStr);
    }
}