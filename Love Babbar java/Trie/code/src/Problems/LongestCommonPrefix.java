package Problems;
class Trie{
    TrieNode root;

    public Trie(){
        root = new TrieNode('\0');
    }


    class TrieNode {
        char data;
        TrieNode[] children = new TrieNode[26];
        boolean isTerminal;

        public TrieNode(char data){
            this.data = data;
            isTerminal = false;
            for(int i=0;i<26;i++){
                children[i] = null;
            }
        }
    }



    void insert(String word){
        insertRec(root,word);
    }

    void insertRec(TrieNode root,String str){
        if(str.length()==0){
            root.isTerminal = true;
            return;
        }

        char ch = str.charAt(0);
        int index = ch-'a';
        TrieNode child;
        if(root.children[index] != null){
            child = root.children[index];
        }else{
            child = new TrieNode(ch);
            root.children[index] = child;

        }

        insertRec(child,str.substring(1));
    }


    int getChildCount(TrieNode temp)  {
        int count = 0;

        for(int i=0; i<26; i++) {
            if(temp.children[i] != null)
                count++;
        }
        return count;
    }

    void longestCommonPrefix(String input, StringBuilder sb){
        TrieNode temp = root;

        for(int i=0;i<input.length();i++){

            char ch = input.charAt(i);

            if(getChildCount(temp) == 1){
                sb.append(ch);
                int index = ch-'a';
                temp = temp.children[index];
            }else{
                break;
            }

            if(temp.isTerminal){
                break;
            }
        }
    }
}
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));


    }

    public static String longestCommonPrefix(String[] strs) {
//        String ans = strs[0];
//
//        System.out.println("flow".indexOf(""));
//        for(int i=1;i<strs.length;i++)
//        {
//            while(strs[i].indexOf(ans)!=0){
//                System.out.println(strs[i].indexOf(ans));
//                ans = ans.substring(0,ans.length()-1);
//            }
//        }
//        return ans;

        Trie trie = new Trie();
        for(String s :strs){
            if(s.length() == 0)
                return s;
            trie.insert(s);
        }

        StringBuilder sb = new StringBuilder();
        trie.longestCommonPrefix(strs[0],sb);
        return sb.toString();
    }




}
