package RecursionYT;

import java.util.ArrayList;
import java.util.Arrays;

public class PermutationsOfAString {
    public static void main(String[] args) {
        String str = "abc";
        System.out.println(generatePermutations(str));
    }

    public static ArrayList<String> generatePermutations(String str) {
        // Write your code here
        ArrayList<String> ans = new ArrayList<>();
        char[] ch = str.toCharArray();
        solve(ch,0,ans);

        return ans;
    }

    public static  void solve(char[] ch, int index, ArrayList<String> ans)
    {
        //base case
        if(index == ch.length)
        {
            String st = String.valueOf(ch);
            ans.add(st);
            return;
        }


        for(int i=index;i<ch.length;i++)
        {
            swap(ch,i,index);
            solve(ch,index+1,ans);
            //backtracking
            swap(ch,i,index);

        }
    }

    public  static void swap(char[] ch, int i, int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;

    }
}
