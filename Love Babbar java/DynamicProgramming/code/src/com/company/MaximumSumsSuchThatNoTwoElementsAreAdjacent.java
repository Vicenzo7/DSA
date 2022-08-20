package com.company;

import java.util.Arrays;

public class MaximumSumsSuchThatNoTwoElementsAreAdjacent {
    public static void main(String[] args) {
        int[] arr = {2, 1, 4, 9};
        System.out.println(solve(arr, 0));
        int[] dp = new int[arr.length + 1];
        Arrays.fill(dp, -1);

        System.out.println(solveMem(arr, 0, dp));
        System.out.println(solveTab(arr));
        System.out.println(solveTabSpaceOptimization(arr));
    }

    private static int solve(int[] arr, int index) {
        //base case

        if (index >= arr.length) {
            return 0;
        }

        // include
        int incl = arr[index] + solve(arr, index + 2);
        int excl = 0 + solve(arr, index + 1);

        return Math.max(incl, excl);
    }


    private static int solveMem(int[] arr, int index, int[] dp) {
        //base case

        if (index >= arr.length) {
            return 0;
        }

        if (dp[index] != -1) {
            return dp[index];
        }

        // include
        int incl = arr[index] + solveMem(arr, index + 2, dp);
        int excl = 0 + solveMem(arr, index + 1, dp);

        return dp[index] = Math.max(incl, excl);
    }

    private static int solveTab(int[] arr) {

        int[] dp = new int[arr.length + 2];
        Arrays.fill(dp, 0);

        int n = arr.length;
        for (int index = n - 1; index >= 0; index--) {
            int incl = arr[index] + dp[index + 2];
            int excl = dp[index + 1];
            dp[index] = Math.max(incl, excl);
        }

        return dp[0];

    }


    private static int solveTabSpaceOptimization(int[] arr) {

        int next2 = 0;
        int next1 = 0;
        int cur = arr.length-1;
        int n = arr.length;
        for (int index = n - 1; index >= 0; index--) {
            int incl = arr[index] + next2;
            int excl = next1;
            cur = Math.max(incl, excl);

            next2 = next1;
            next1 = cur;

        }

        return cur;

    }
}
