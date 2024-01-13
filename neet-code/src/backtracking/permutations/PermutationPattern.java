package backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationPattern {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permutationsRecursive(nums));
    }

    // Time: O(n^2 * n!)
    public static List<List<Integer>> permutationsRecursive(int[] nums) {
        return helper(0, nums);
    }

    public static List<List<Integer>> helper(int i, int[] nums) {
        if (i == nums.length) {
            List<List<Integer>> res = new ArrayList<>();
            res.add(new ArrayList<>());
            return res;
        }

        List<List<Integer>> resPrem = new ArrayList<>();
        List<List<Integer>> pem = helper(i + 1, nums);
        for (List<Integer> p : pem) {
            for (int j = 0; j < p.size() + 1; j++) {
                List<Integer> pCopy = new ArrayList<>(p);
                pCopy.add(j, nums[i]);
                resPrem.add(pCopy);
            }
        }
        return resPrem;
    }
}
