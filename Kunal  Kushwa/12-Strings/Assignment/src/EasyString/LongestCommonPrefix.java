package EasyString;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs ={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        String ans = strs[0];

        System.out.println("flow".indexOf(""));
        for(int i=1;i<strs.length;i++)
        {
            while(strs[i].indexOf(ans)!=0){
                System.out.println(strs[i].indexOf(ans));
                ans = ans.substring(0,ans.length()-1);
            }
        }
        return ans;
    }
}
