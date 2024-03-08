package RecursionYT;

import java.util.ArrayList;
import java.util.List;

public class SubsetsPowersetOfArray {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }

    public static List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(nums,0,ans,temp);
        return ans;
    }


    public static void solve(int[] nums,int index,List<List<Integer>> ans ,ArrayList<Integer> temp)
    {
        //base case
        if(index == nums.length)
        {
            ans.add(temp);
            return;
        }

        //exclude
        //took new ArrayList<>(temp) because we want a new arraylist for each new ans we find
        solve(nums,index+1,ans,new ArrayList<>(temp));

        //include
        int val = nums[index];
        temp.add(val);
        solve(nums,index+1,ans,temp);
    }
}
