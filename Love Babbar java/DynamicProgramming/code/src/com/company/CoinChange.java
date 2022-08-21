package com.company;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int amount = 11;
        coinChange(coins,amount);
    }

    public static void coinChange(int[] coins, int amount) {

        int ans = solve(coins,amount);
        if(ans == Integer.MAX_VALUE)
            ans=-1;
        System.out.println("Min number of coins "+ans);


        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);


        int ansMem = solveMem(coins,amount,dp);
        if(ansMem == Integer.MAX_VALUE)
            ansMem=-1;
        System.out.println("Min number of coins "+ansMem);
        int ansTab = solveTab(coins,amount);

        if(ansTab == Integer.MAX_VALUE)
            ansTab=-1;
        System.out.println("Min number of coins "+ansTab);


    }

    public  static int solve(int[] coins, int target){
        if(target == 0)
            return 0;

        if(target<0)
            return Integer.MAX_VALUE;



        int mini = Integer.MAX_VALUE;


        for(int i=0;i<coins.length;i++){
            int ans = solve(coins,target-coins[i]);
            if( ans != Integer.MAX_VALUE){
                mini = Math.min(mini,1+ans);
            }
        }

        return  mini;
    }

    public  static int solveMem(int[] coins, int target,int[] dp){
        if(target == 0)
            return 0;

        if(target<0)
            return Integer.MAX_VALUE;

        if(dp[target] !=-1){
            return dp[target];
        }

        int mini = Integer.MAX_VALUE;


        for(int i=0;i<coins.length;i++){
            int ans = solveMem(coins,target-coins[i],dp);
            if( ans != Integer.MAX_VALUE){
                mini = Math.min(mini,1+ans);
            }
        }

        return dp[target] = mini;
    }



    public static int solveTab(int[] coins, int t){

        int[] dp = new int[t+1];
        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;

        for(int target = 1;target<=t; target++){
            int mini = Integer.MAX_VALUE;

            for(int i=0;i<coins.length;i++){
                if(target-coins[i] >=0){
                    int ans = dp[target-coins[i]];
                    if( ans != Integer.MAX_VALUE){
                        mini = Math.min(mini,1+ans);
                    }
                }
            }
            dp[target] = mini;
        }

        return dp[t];
    }
}
