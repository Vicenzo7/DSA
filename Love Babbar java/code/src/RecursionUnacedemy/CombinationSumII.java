package RecursionUnacedemy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/combination-sum-ii/
public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates,target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        //sorted Array because outputs are also sorted
        Arrays.sort(candidates);
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

        for(int i=index;i<candidates.length;i++)
        {
            //skipping duplicates
            if(i> index && candidates[i] == candidates[i-1])
                continue;
            //early stop
            if(candidates[i] > target)
                break;

            temp.add(candidates[i]);
            solve(candidates, target-candidates[i], ans, new ArrayList<>(temp), i+1);
            temp.remove(temp.size()-1);
        }
    }
}
