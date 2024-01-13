package backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(permute(nums));
    }

    /*

        The code uses recursion to generate all possible permutations of the given array.
        The generatePermutation function is called recursively for each index in the array, resulting in a total of n! recursive calls.
        Within each recursive call, a loop iterates over the permutations list, which can have a maximum size of n! as well.
        Inside the loop, a new ArrayList is created and elements are added at different positions, resulting in a time complexity of O(n) for each iteration.
        Therefore, the overall time complexity is O(n * n!) or simply O(n!).

    */

    public static List<List<Integer>> permute(int[] nums) {
        return generatePermutation(0, nums);
    }

    public static List<List<Integer>> generatePermutation(int index, int[] nums) {
        if (index == nums.length) {
            List<List<Integer>> result = new ArrayList<>();
            result.add(new ArrayList<>());
            return result;
        }

        List<List<Integer>> allPermutation = new ArrayList<>();
        List<List<Integer>> permutations = generatePermutation(index + 1, nums);

        for (List<Integer> permutation : permutations) {
            for (int i = 0; i < permutation.size() + 1; i++) {
                List<Integer> premCopy = new ArrayList<>(permutation);
                premCopy.add(i, nums[index]);
                allPermutation.add(premCopy);
            }
        }

        return allPermutation;
    }
}
