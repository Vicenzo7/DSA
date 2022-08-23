package com.company;

import java.util.Arrays;

public class KnapsackProblem_0_1 {
    public static void main(String[] args) {
//        int N = 3;
//        int W = 4;
//        int[] values = {1, 2, 3};
//        int[] weight = {4, 5, 1};

        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 50;
        int n = val.length;

        knapSack(W,wt,val,n);
    }


    //Function to return max value that can be put in knapsack of capacity W.
    static void knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];


        for (int[] row : dp)
            Arrays.fill(row, -1);

        System.out.println(solve(val, wt, 0, W));

        System.out.println(solveMem(val, wt, 0, W, dp));

        System.out.println(solveTab(val, wt, n, W));
    }


    static int solve(int[] val, int[] wt, int index, int capacity) {

        // base case

        if (index == val.length || capacity == 0) {
            return 0;
        }

        int include = 0;

        if (capacity >= wt[index]) {
            include = val[index] + solve(val, wt, index + 1, capacity - wt[index]);
        }

        int exclude = 0 + solve(val, wt, index + 1, capacity);


        return Math.max(include, exclude);
    }


    static int solveMem(int[] val, int[] wt, int index, int capacity, int[][] dp) {


        // base case

        if (index == val.length || capacity == 0) {
            return 0;
        }

        if (dp[index][capacity] != -1) {
            return dp[index][capacity];
        }

        int include = 0;

        if (capacity >= wt[index]) {
            include = val[index] + solveMem(val, wt, index + 1, capacity - wt[index], dp);
        }

        int exclude = 0 + solveMem(val, wt, index + 1, capacity, dp);


        return dp[index][capacity] = Math.max(include, exclude);
    }


    static int solveTab(int[] val, int[] wt, int n, int C) {


        int[][] dp = new int[n + 1][C + 1];


        for (int[] row : dp)
            Arrays.fill(row, 0);


        for (int index = n - 1; index >= 0; index--) {
            for (int capacity = 0; capacity <= C; capacity++) {

                int include = 0;

                if (capacity >= wt[index]) {
                    include = val[index] + dp[index + 1][capacity - wt[index]];
                }

                int exclude = 0 + dp[index + 1][capacity];


                dp[index][capacity] = Math.max(include, exclude);

            }
        }


        return dp[0][C];
    }
}
