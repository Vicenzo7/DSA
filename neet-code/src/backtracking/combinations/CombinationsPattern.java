package backtracking.combinations;

import java.util.ArrayList;
import java.util.List;

public class CombinationsPattern {
    public static void main(String[] args) {
        int n = 5, k = 2;
        generateCombinations(n, k);
        generateCombinations2(n, k);
    }



    /*
        Q. Given two nums n and k, return all possible combination of size k choosing from values between 1 and n,
         and they should be distinct

         TC = (k.2^n) can we reduce it?
         Yes
        If we have 5 numbers, and we can choose only 2, how many combination exists
        C(n,k) = C(5,2) = 5!/(2! * (5-2)!
        5* 4 * 3 * 2 * 1/ 2 * 3 * 2 * 1
        20/2 = 10

    */

    private static void generateCombinations(int n, int k) {
        List<Integer> currentCombo = new ArrayList<>();
        List<List<Integer>> allCombo = new ArrayList<>();
        helper(1, n, k, currentCombo, allCombo);
        System.out.println(allCombo);
    }


    // TC = O(2^n)
    private static void helper(int num, int n, int k, List<Integer> currentCombo, List<List<Integer>> allCombo) {
        if (currentCombo.size() == k) {
            allCombo.add(new ArrayList<>(currentCombo));
            return;
        }

        if (num > n) {
            return;
        }

        // include
        currentCombo.add(num);
        helper(num + 1, n, k, currentCombo, allCombo);

        // exclude
        currentCombo.remove(currentCombo.size() - 1);
        helper(num + 1, n, k, currentCombo, allCombo);
    }


    /*
        Optimal Time: O(k * C(n, k))
    */
    private static void generateCombinations2(int n, int k) {
        List<Integer> currentCombo = new ArrayList<>();
        List<List<Integer>> allCombo = new ArrayList<>();
        helper2(1, n, k, currentCombo, allCombo);
        System.out.println(allCombo);
    }

    private static void helper2(int num, int n, int k, List<Integer> currentCombo, List<List<Integer>> allCombo) {
        if (currentCombo.size() == k) {
            allCombo.add(new ArrayList<>(currentCombo));
            return;
        }
        if (num > n) {
            return;
        }

        for (int j = num; j <= n; j++) {
            currentCombo.add(j);
            helper2(j + 1, n, k, currentCombo, allCombo);
            currentCombo.remove(currentCombo.size() - 1);
        }
    }

}
