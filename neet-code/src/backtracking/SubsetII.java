package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetII {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        System.out.println(subsetsWithDup(nums));
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> currentSubset = new ArrayList<>();
        List<List<Integer>> allSubset = new ArrayList<>();
        generateSubset(0, nums, currentSubset, allSubset);
        return allSubset;
    }

    private static void generateSubset(int index, int[] nums, List<Integer> currentSubset, List<List<Integer>> allSubset) {
        if (index == nums.length) {
            allSubset.add(new ArrayList<>(currentSubset));
            return;
        }

        // include
        currentSubset.add(nums[index]);
        generateSubset(index + 1, nums, currentSubset, allSubset);

        // remove duplicate
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }

        // exclude
        currentSubset.remove(currentSubset.size() - 1);
        generateSubset(index + 1, nums, currentSubset, allSubset);
    }

}
