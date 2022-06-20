package RecursionUnacedemy;

import java.util.ArrayList;

//https://leetcode.com/problems/permutation-sequence/
public class PermutationSequence {

    public static void main(String[] args) {
        int n = 3;
        int k = 5;

        System.out.println(getPermutation(n,k));
    }
    public static String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        for(int i=1; i<=n;i++)
        {
            sb.append(i);
        }

        char[] ch = sb.toString().toCharArray();

        ArrayList<String> ans = new ArrayList<>();
        solve(ch,0,ans);

        System.out.println(ans);

        return ans.get(k-1);


    }

    public static void solve(char[] ch, int index,ArrayList<String> ans)
    {
        if(index == ch.length)
        {
            String str = String.valueOf(ch);
            ans.add(str);
            return;
        }


        for(int i=index;i<ch.length;i++)
        {
            swap(ch,i,index);
            solve(ch,index+1,ans);
            swap(ch,i,index);
        }
    }

    public static void swap(char[] ch,int i,int j)
    {
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
    }
}
