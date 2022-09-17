package com.company.medium;

import java.util.Arrays;

public class PaintingFence {
    public static void main(String[] args) {
        int n=5;
        int k=3;

        System.out.println(countWays(n,k));
    }


    static long countWays(int n,int k)
    {
        long[] dp = new long[n+1];
        Arrays.fill(dp,-1);

        return solve(n,k,dp)%1000000007;
    }



    static long solve(int n, int k,long[] dp) {

        if (n == 1)
            return k;

        if (n == 2)
            return k * k;

        if(dp[n] != -1)
            return dp[n];


        long same = solve(n - 2, k,dp)%1000000007 * (k - 1);
        long diff = solve(n - 1, k,dp)%1000000007 * (k - 1);

        long ans = same + diff;
        return dp[n] = ans;

    }
}
