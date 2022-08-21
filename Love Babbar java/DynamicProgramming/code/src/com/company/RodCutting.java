package com.company;
//https://www.geeksforgeeks.org/maximise-number-of-cuts-in-a-rod-if-it-can-be-cut-only-in-given-3-sizes/
import java.util.Arrays;

public class RodCutting {
    public static void main(String[] args) {
        int n=17;
        int a= 10;
        int b = 11;
        int c = 3;

       int ans= solve(n,a,b,c);
       if(ans<0){
           ans =0;
       }
        System.out.println("Max cuts are "+ans);


       // dp way
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);

        System.out.println("Max cuts are "+solveMem(n,a,b,c,dp));

        System.out.println("Max cuts are "+solveTab(n,a,b,c));

    }

    private static int solve(int n, int a, int b, int c) {
        if(n==0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE;
        }

        int first = solve(n-a,a,b,c);
        int second = solve(n-b,a,b,c);
        int third = solve(n-c,a,b,c);

        return 1+Math.max(first,Math.max(second,third));
    }


    private static int solveMem(int n, int a, int b, int c, int[]dp) {
        if(n==0){
            return 0;
        }

        if(n < 0){
            return Integer.MIN_VALUE;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int first = solveMem(n-a,a,b,c,dp);
        int second = solveMem(n-b,a,b,c,dp);
        int third = solveMem(n-c,a,b,c,dp);

        return dp[n]= 1+Math.max(first,Math.max(second,third));
    }



    private static int solveTab(int n, int a, int b, int c) {
        // create dp array
        int[] dp = new int[n+1];
        Arrays.fill(dp,0);

        dp[0]=0;

        for (int i = 1; i <= n; i++) {
            int first = dp[n-a];
            int second = dp[n-b];
            int third = dp[n-c];

            dp[i]= 1+Math.max(first,Math.max(second,third));
        }


        System.out.println(Arrays.toString(dp));
        return dp[n] ;
    }
}
