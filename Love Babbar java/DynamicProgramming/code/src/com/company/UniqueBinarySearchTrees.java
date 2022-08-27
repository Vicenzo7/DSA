package com.company;

//https://leetcode.com/problems/unique-binary-search-trees/
import java.util.Arrays;

public class UniqueBinarySearchTrees {

    public static void main(String[] args) {
        int n = 3;
        numTrees(n);
    }

    public static void numTrees(int n) {
        System.out.println(solve(n));

         int[] dp = new int[n+1];
         Arrays.fill(dp,-1);

        System.out.println(solveMem(n,dp));

        System.out.println(solveTab(n));


        //   2nCn/(n+1)  =  (2*n)! / ((n+1)! * n!)
        // Catalan formula

        // Calculate value of 2nCn
        long c =  binomialCoeff(2*n,n);

        // return 2nCn/(n+1)
        int ans = (int) (c/(n+1));
        System.out.println(ans);
    }


    static int solve(int n){
        // base case

        if(n==0 || n==1)
            return 1;

        if(n==2)
            return 2;

        int ans =0;

        for(int i=1;i<=n;i++){
            ans += solve(i-1)*solve(n-i);
        }

        return ans;
    }

    static int solveMem(int n,int[] dp){
        // base case

        if(n==0 || n==1)
            return 1;

        if(n==2)
            return 2;

        if(dp[n] != -1)
            return dp[n];

        int ans =0;

        for(int i=1;i<=n;i++){
            ans += solveMem(i-1,dp)*solveMem(n-i,dp);
        }

        return dp[n]=ans;
    }


    static int solveTab(int N){
        int[] dp = new int[N+1];
        Arrays.fill(dp,0);

        dp[0] = 1;

        dp[1] = 1;

        // cant use this if n = 1
        // dp[2] = 2;

        for(int n= 2;n<=N;n++){

            int ans =0;

            for(int i=1;i<=n;i++){
                ans += dp[i-1]*dp[n-i];
            }

            dp[n]=ans;
        }

        return dp[N];

    }


    static long binomialCoeff( int n, int k)
    {
        long res = 1;

        // Since C(n, k) = C(n, n-k)
        if (k > n - k)
            k = n - k;

        // Calculate value of [n*(n-1)*---*(n-k+1)] / [k*(k-1)*---*1]
        for (int i = 0; i < k; ++i)
        {
            res *= (n - i);
            res /= (i + 1);
        }

        return res;
    }
}
