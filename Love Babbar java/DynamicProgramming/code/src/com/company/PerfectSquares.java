package com.company;

import java.util.Arrays;

public class PerfectSquares {
    public static void main(String[] args) {

        int n = 12;

        numSquares(12);

    }

    public static void numSquares(int n) {
        System.out.println(solve(n));

        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println(solveMem(n,dp));

        System.out.println(solveTab(n));
    }


    public static int solve(int n){
        // base case
        if(n==0){
            return 0;
        }
        int ans=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){
            ans = Math.min(ans,1+solve(n-i*i));
        }

        return ans;
    }


    public static int solveMem(int n,int[] dp){
        // base case
        if(n==0){
            return 0;
        }

        if(dp[n]!=-1){
            return dp[n];
        }
        int ans=Integer.MAX_VALUE;

        for(int i=1;i*i<=n;i++){
            ans = Math.min(ans,1+solveMem(n-i*i,dp));
        }

        return dp[n] = ans;
    }


    public static int solveTab(int N){

        int[] dp = new int[N+1];
        Arrays.fill(dp,0);

        dp[0] = 0;

        for(int n=1; n<=N;n++){
            int ans=Integer.MAX_VALUE;

            for(int i=1;i*i<=n;i++){
                ans = Math.min(ans,1+dp[n-i*i]);
            }
            dp[n] = ans;
        }



        return dp[N];
    }
}
