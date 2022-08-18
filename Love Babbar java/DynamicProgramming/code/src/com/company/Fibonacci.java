package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Fibonacci {
    public static void main(String[] args) {
        int n  = 6;
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        int ans =solve(n);
        System.out.println(ans);
        System.out.println(solveMem(n,dp));
        System.out.println(solveTab(n));
        System.out.println(solveTabSpaceOptimization(n));


    }

    private static int solve(int n) {
        if(n==0)
            return 0;

        if(n == 1)
            return 1;

        return solve(n-1)+solve(n-2);
    }


    //Recursion + memoization
    // step1: create dp array + pass in function
    // step2: store answer in dp array
    // step3: Just after base case check if dp array already has the answer, if yes, then return

    // TC: O(n)
    // Sc:O(n) + O(n)
    private static int solveMem(int n,int[] dp) {
        if(n==0)
            return 0;

        if(n == 1)
            return 1;

        //step3
        if(dp[n]!=-1)
            return dp[n];


        int ans = solveMem(n-1,dp)+solveMem(n-2,dp);

        // step2
        return dp[n] = ans;
    }


    // Tabulation technique
    //step 1: create dp array
    //step2 base case analyse of Recursion code and update dp array accordingly
    // step3: find the range for the changing variable and copy & paste the logic from recursion code

    // TC: O(n)
    // Sc:O(1)
    static int solveTab(int nthTerm){
        // step1:create dp array
        int[] dp = new int[nthTerm+1];
        Arrays.fill(dp,0);

        //step2: update dp array , basis on recursion base case
        dp[0]=0;
        dp[1]=1;

        //step3 : find range and copy & paste recursion code
        for (int n = 2; n <= nthTerm ; n++) {
            dp[n] = dp[n-1]+dp[n-2];
        }

        return dp[nthTerm];

    }


    static int solveTabSpaceOptimization(int nthTerm){
        // step1: replace dp array with your optimised storage structures and remove dp array
       int prev1=1;
       int prev2=0;
       int curr = 0;

       //step2 : dp values -> replace -> prev1,prev2
        for (int n = 2; n <= nthTerm ; n++) {
            int ans = prev1+prev2;
            curr = ans;

            prev2 = prev1;
            prev1= curr;
        }

        return curr;

    }
}


