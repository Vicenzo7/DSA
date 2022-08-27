package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/guess-number-higher-or-lower-ii/
public class GuessNumberHigherOrLowerII {
    public static void main(String[] args) {
        int n= 10;
        getMoneyAmount(n);
    }


    public static void getMoneyAmount(int n) {
        System.out.println(solve(1, n));


        int[][] dp = new int[n + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

        System.out.println(solveMem(1, n, dp));

        System.out.println(solveTab(n));
    }


    static int solve(int start, int end) {
        // base case

        if (start >= end)
            return 0;


        int mini = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {

            mini = Math.min(mini, i + Math.max(solve(start, i - 1), solve(i + 1, end)));

        }

        return mini;
    }


    static int solveMem(int start, int end, int[][] dp) {
        // base case

        if (start >= end)
            return 0;

        if (dp[start][end] != -1)
            return dp[start][end];

        int mini = Integer.MAX_VALUE;

        for (int i = start; i <= end; i++) {

            mini = Math.min(mini, i + Math.max(solveMem(start, i - 1, dp), solveMem(i + 1, end, dp)));

        }

        return dp[start][end] = mini;
    }

    static int solveTab(int n) {
        int[][] dp = new int[n + 2][n + 2];
        // for(int[] row :dp){
        //     Arrays.fill(row,0);
        // }

        for (int start = n; start >= 1; start--) {
            for (int end = start + 1; end <= n; end++) {

                int mini = Integer.MAX_VALUE;

                for (int i = start; i <= end; i++) {

                    mini = Math.min(mini, i + Math.max(dp[start][i - 1], dp[i + 1][end]));

                }
                dp[start][end] = mini;

            }
        }

        return dp[1][n];
    }
}
