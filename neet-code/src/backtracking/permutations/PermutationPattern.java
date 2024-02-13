package backtracking.permutations;

import java.util.ArrayList;
import java.util.List;

public class PermutationPattern {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permutationsRecursive(nums));
        System.out.println(permutations("abc"));
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

    public static List<String> permutations(String str) {
        return helper(str);
    }

    private static List<String> helper(String str) {
        if (str.isEmpty()) {
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        char initial = str.charAt(0); // first character
        String remaining = str.substring(1);
        List<String> allPermutation = new ArrayList<>();
        List<String> permutation = helper(remaining);
        for (String p : permutation) {
            for (int i = 0; i < p.length() + 1; i++) {
                allPermutation.add(charInsert(p, i, initial));
            }
        }

        return allPermutation;
    }

    private static String charInsert(String s, int index, char initial) {
        // add initial at position index

        String first = s.substring(0, index);
        String last = s.substring(index);
        return first + initial + last;
    }
}
