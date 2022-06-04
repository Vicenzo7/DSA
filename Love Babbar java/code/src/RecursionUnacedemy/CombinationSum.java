package RecursionUnacedemy;
//https://leetcode.com/problems/combination-sum/
import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates ={2,3,6,7};
        int target = 7;

        System.out.println(combinationSum(candidates,target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int index=0;
        List<Integer> temp = new ArrayList<>();

        solve(candidates,target,ans,temp,index);

        return ans;
    }

    private static void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int index) {

        //  base case

        if(target == 0)
        {
            ans.add(temp);
            return;
        }

        if(target< 0  || index >= candidates.length )
            return;

        //exclude
        solve(candidates, target, ans, temp, index+1);

        //include
        temp.add(candidates[index]);
        solve(candidates, target-candidates[index], ans, new ArrayList<>(temp), index);
        temp.remove(temp.size()-1);

    }
}
