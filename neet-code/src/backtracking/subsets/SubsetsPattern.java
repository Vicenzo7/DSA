package backtracking.subsets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsPattern {

    // Q. Given a list of distinct numbers, return all possible distinct subset
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> subSets = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        // Q. Given a list of distinct numbers, return all possible distinct subset
        getSubsets(nums, 0, currentSet, subSets);
        System.out.println(subSets);

        // Q. Given a list of numbers that are not necessarily distinct, return all possible distinct subset
        int[] nums2 = {1, 2, 3, 2};
        subsetsWithDuplicates(nums2);
    }


    // TC = O(n*2^n)  SC=O(n)
    private static void getSubsets(int[] nums, int index, List<Integer> currentSet, List<List<Integer>> subSets) {
        if (index == nums.length) {
            subSets.add(new ArrayList<>(currentSet));
            return;
        }
        // include
        currentSet.add(nums[index]);
        getSubsets(nums, index + 1, currentSet, subSets);

        // exclude
        currentSet.remove(currentSet.size() - 1);
        getSubsets(nums, index + 1, currentSet, subSets);
    }

    // Q. Given a list of numbers that are not necessarily distinct, return all possible distinct subset
    private static void subsetsWithDuplicates(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> currentSet = new ArrayList<>();
        Arrays.sort(nums); // makes it easier
        helper2(0, nums, currentSet, subsets);
        System.out.println(subsets);
    }

    private static void helper2(int index, int[] nums, List<Integer> currentSet, List<List<Integer>> subsets) {
        if (index == nums.length) {
            subsets.add(new ArrayList<>(currentSet));
            return;
        }

        // Decision to include nums[index]
        currentSet.add(nums[index]);
        helper2(index + 1, nums, currentSet, subsets);

        // skipping the duplicates to avoid adding duplicates subsets
        while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
            index += 1;
        }

        // Decision to exclude nums[index]
        currentSet.remove(currentSet.size() - 1);
        helper2(index + 1, nums, currentSet, subsets);
    }
}
