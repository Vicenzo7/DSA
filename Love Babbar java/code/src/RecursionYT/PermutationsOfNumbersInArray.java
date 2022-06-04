package RecursionYT;

import java.util.ArrayList;
import java.util.List;

public class PermutationsOfNumbersInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, 0, ans);
        return ans;
    }

    public static void solve(int[] nums, int index, List<List<Integer>> ans) {
        //base case
        if (index == nums.length) {
            ans.add(convert(nums));
            return;
        }


        for (int i = index; i < nums.length; i++) {
            swap(nums, i, index);
            solve(nums, index + 1, ans);
            //backtracking
            swap(nums, i, index);

        }
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    public static List<Integer> convert(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int x : nums) {
            list.add(x);
        }
        return list;
    }
}
