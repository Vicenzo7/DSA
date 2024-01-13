package backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum2 {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target));
        System.out.println(combinationSum2Optimal(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> allCombination = new ArrayList<>();
        generateCombinationSum2(0, candidates, target, currentCombination, allCombination);
        return allCombination;
    }

    public static void generateCombinationSum2(int index, int[] candidate, int target, List<Integer> currentCombination,
                                               List<List<Integer>> allCombination) {
        if (index == candidate.length) {
            if (target == 0) {
                allCombination.add(new ArrayList<>(currentCombination));
            }
            return;
        }

        if (target < 0) {
            return;
        }


        // include
        currentCombination.add(candidate[index]);
        generateCombinationSum2(index + 1, candidate, target - candidate[index], currentCombination, allCombination);

        while (index + 1 < candidate.length && candidate[index] == candidate[index + 1]) {
            index += 1;
        }

        // exclude
        currentCombination.remove(currentCombination.size() - 1);
        generateCombinationSum2(index + 1, candidate, target, currentCombination, allCombination);
    }

    public static List<List<Integer>> combinationSum2Optimal(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> currentCombination = new ArrayList<>();
        List<List<Integer>> allCombination = new ArrayList<>();
        generateCombinationSum2Optimal(0, candidates, target, currentCombination, allCombination);
        return allCombination;
    }

    public static void generateCombinationSum2Optimal(int index, int[] candidates, int target, List<Integer> currentCombination,
                                                      List<List<Integer>> allCombination) {
        if (target == 0) {
            allCombination.add(new ArrayList<>(currentCombination));
            return;
        }

        if (target < 0) {
            return;
        }


        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1])
                continue;
            if (candidates[i] > target) {
                break;
            }
            currentCombination.add(candidates[i]);
            generateCombinationSum2Optimal(i + 1, candidates, target - candidates[i], currentCombination, allCombination);
            currentCombination.remove(currentCombination.size() - 1);
        }

    }
}
