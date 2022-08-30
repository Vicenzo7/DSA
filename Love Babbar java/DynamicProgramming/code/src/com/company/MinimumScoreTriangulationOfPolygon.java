package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-score-triangulation-of-polygon/
public class MinimumScoreTriangulationOfPolygon {
    public static void main(String[] args) {
        int[] values = {3,7,4,5};
        minScoreTriangulation(values);
    }



    public static void minScoreTriangulation(int[] values) {
        System.out.println(solve(values,0,values.length-1));

         int n = values.length;

         int[][] dp = new int[n][n];
         for(int[] rows:dp){
             Arrays.fill(rows,-1);
         }

        System.out.println(solveMem(values,0,values.length-1,dp));

        System.out.println(solveTab(values));
    }


    static int solve(int[] v,int i,int j){
        // base case
        // need three vertex to make triangle
        // if 2 return 0

        if(i+1==j){
            return 0;
        }

        int mini = Integer.MAX_VALUE;

        for(int k=i+1;k<j;k++){
            mini = Math.min(mini,v[i]*v[j]*v[k] + solve(v,i,k) + solve(v,k,j));
        }

        return mini;

    }


    static int solveMem(int[] v,int i,int j,int[][]dp){
        // base case
        // need three vertex to make triangle
        // if 2 return 0

        if(i+1==j){
            return 0;
        }

        if(dp[i][j] !=-1){
            return dp[i][j];
        }

        int mini = Integer.MAX_VALUE;

        for(int k=i+1;k<j;k++){
            mini = Math.min(mini,v[i]*v[j]*v[k] + solveMem(v,i,k,dp) + solveMem(v,k,j,dp));
        }

        return dp[i][j] = mini;

    }


    static int solveTab(int[] v){
        int n = v.length;

        int[][] dp = new int[n][n];
        for(int[] rows:dp){
            Arrays.fill(rows,0);
        }

        for(int i=n-1;i>=0;i--){
            // staring j from i+2 because of base case
            for(int j= i+2;j<n;j++){
                int mini = Integer.MAX_VALUE;

                for(int k=i+1;k<j;k++){
                    mini = Math.min(mini,v[i]*v[j]*v[k] + dp[i][k] + dp[k][j]);
                }

                dp[i][j] = mini;
            }
        }

        return dp[0][n-1];

    }
}
