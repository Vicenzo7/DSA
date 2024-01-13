package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        System.out.println(subsets(nums));
    }
    public static List<List<Integer>> subsets(int[] nums) {
        List<Integer> currentSubset = new ArrayList<>();
        List<List<Integer>> allSubset = new ArrayList<>();
        generateSubset(0, nums, currentSubset, allSubset);
        return allSubset;
    }

    public static void generateSubset(int index, int[] nums, List<Integer> currentSubset,
                               List<List<Integer>> allSubset) {

        // base case
        if(index == nums.length) {
            allSubset.add(new ArrayList<>(currentSubset));
            return;
        }

        // include
        currentSubset.add(nums[index]);
        generateSubset(index+1, nums, currentSubset, allSubset);

        // exclude
        currentSubset.remove(currentSubset.size()-1);
        generateSubset(index+1, nums, currentSubset, allSubset);
    }
}
