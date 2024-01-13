package backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        System.out.println(combinationSum(candidates, target));
        System.out.println(combinationSum2(candidates, target));
    }

    // TC = O(2^n)
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombination(0, candidates, target, combination, result);
        return result;
    }

    public static void generateCombination(int index, int[] nums, int target, List<Integer> combination,
                                           List<List<Integer>> result) {

        if (index == nums.length) {
            if (target == 0) {
                result.add(new ArrayList<>(combination));
            }
            return;
        }

        if (target < 0) {
            return;
        }

        // include
        combination.add(nums[index]);
        generateCombination(index, nums, target - nums[index], combination, result);

        // exclude
        combination.remove(combination.size() - 1);
        generateCombination(index + 1, nums, target, combination, result);
    }


    /*
        The code uses a recursive approach to generate all possible combinations of candidates that sum up to the target.
        In the worst case, each candidate can be included or excluded, resulting in a branching factor of 2 at each level of recursion.
        Therefore, the time complexity is exponential, O(2^n), where n is the number of candidates.
    */
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> combination = new ArrayList<>();
        generateCombination2(0, candidates, target, combination, result);
        return result;
    }

    private static void generateCombination2(int index, int[] candidates, int target, List<Integer> combination, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(combination));
            return;
        }
        if (target < 0) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            combination.add(candidates[i]);
            generateCombination2(i, candidates, target - candidates[i], combination, result);
            combination.remove(combination.size() - 1);
        }
    }

}
