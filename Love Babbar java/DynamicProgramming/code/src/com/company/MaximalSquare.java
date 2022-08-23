package com.company;
//https://leetcode.com/problems/maximal-square/
import java.util.Arrays;

public class MaximalSquare {
    public static void main(String[] args) {
        char[][] matrix = {
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}};

        maximalSquare(matrix);
    }


    static int maxi = 0;

    public static void maximalSquare(char[][] matrix) {
        //solve(matrix, 0,0);
        //return maxi*maxi;

        int[][] dp = new int[matrix.length][matrix[0].length];


        for (int[] row : dp)
            Arrays.fill(row, -1);


        //solveMem(matrix, 0,0,dp);

        solveTab(matrix, matrix.length, matrix[0].length);
        System.out.println(maxi * maxi);
    }


    static int solve(char[][] matrix, int i, int j) {

        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }


        int bottom = solve(matrix, i + 1, j);
        int diagonal = solve(matrix, i + 1, j + 1);
        int right = solve(matrix, i, j + 1);

        if (matrix[i][j] == '1') {
            int side = Math.min(bottom, Math.min(diagonal, right)) + 1;
            maxi = Math.max(side, maxi);
            return side;
        } else {
            return 0;
        }
    }


    static int solveMem(char[][] matrix, int i, int j, int[][] dp) {

        if (i >= matrix.length || j >= matrix[0].length) {
            return 0;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int bottom = solveMem(matrix, i + 1, j, dp);
        int diagonal = solveMem(matrix, i + 1, j + 1, dp);
        int right = solveMem(matrix, i, j + 1, dp);

        if (matrix[i][j] == '1') {
            int side = Math.min(bottom, Math.min(diagonal, right)) + 1;
            maxi = Math.max(side, maxi);
            dp[i][j] = side;
        } else {
            dp[i][j] = 0;
        }

        return dp[i][j];
    }


    static void solveTab(char[][] matrix, int row, int col) {

        int[][] dp = new int[matrix.length + 1][matrix[0].length + 1];


        for (int[] r : dp)
            Arrays.fill(r, 0);


        for (int i = row - 1; i >= 0; i--) {
            for (int j = col - 1; j >= 0; j--) {
                int bottom = dp[i + 1][j];
                int diagonal = dp[i + 1][j + 1];
                int right = dp[i][j + 1];

                if (matrix[i][j] == '1') {
                    int side = Math.min(bottom, Math.min(diagonal, right)) + 1;
                    maxi = Math.max(side, maxi);
                    dp[i][j] = side;
                } else {
                    dp[i][j] = 0;
                }
            }
        }

    }
}
