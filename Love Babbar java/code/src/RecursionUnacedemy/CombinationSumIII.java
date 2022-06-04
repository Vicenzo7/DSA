package RecursionUnacedemy;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumIII {
    public static void main(String[] args) {
       int  k = 3;
       int n = 9;
        System.out.println(combinationSum3(k,n));
    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> output = new ArrayList<>();
        int num =1;

        solve(k,n,output,ans,num);

        return ans;
    }

    public static void solve(int k,int n,ArrayList<Integer> output,List<List<Integer>> ans,int num)
    {
        //base case
        if(k==0 && n==0)
        {
            ans.add(new ArrayList<>(output));
            return;
        }


        for(int i=num;i<10;i++)
        {
            output.add(i);
            solve(k-1,n-i,output,ans,i+1);
            output.remove(output.size()-1);
        }
    }
}
