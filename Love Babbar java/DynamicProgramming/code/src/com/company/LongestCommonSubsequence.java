package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/longest-common-subsequence/
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        String text1 = "abcde", text2 = "ace";

        longestCommonSubsequence(text1, text2);
    }

    public static void longestCommonSubsequence(String text1, String text2) {
        System.out.println(solve(text1, text2, 0, 0));

        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }

//         return solveMem(text1,text2,0,0,dp);
        System.out.println(solveMem(text1, text2, 0, 0,dp));
        System.out.println(solveTab(text1, text2));
        System.out.println(solveOpti(text1,text2));
    }


    static int solve(String a, String b, int i, int j) {

        // base case
        if (i == a.length() || j == b.length()) {
            return 0;
        }

        int ans = 0;

        if (a.charAt(i) == b.charAt(j)) {
            // +1 because include the char a and b which is same
            ans = 1 + solve(a, b, i + 1, j + 1);
        } else {
            int option1 = solve(a, b, i + 1, j);
            int option2 = solve(a, b, i, j + 1);

            ans = Math.max(option1, option2);
        }

        return ans;
    }

    // Recursion + Mem

    static int solveMem(String a,String b,int i,int j,int[][] dp){

        // base case
        if(i==a.length() || j==b.length()){
            return 0;
        }

        if(dp[i][j]!=-1){
            return dp[i][j];
        }


        int ans=0;

        if(a.charAt(i) == b.charAt(j)){
            ans = 1 + solveMem(a,b,i+1,j+1,dp);
        }else{
            int option1 = solveMem(a,b,i+1,j,dp);
            int option2 = solveMem(a,b,i,j+1,dp);

            ans = Math.max(option1,option2);
        }

        return dp[i][j] = ans;
    }

    // Recursion + Tab

    // range
    // i -> 0 to a.length()
    // j -> 0 b.length()      just reverse and we will get our range

    static int solveTab(String a, String b) {

        int[][] dp = new int[a.length() + 1][b.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, 0);
        }

        for (int i = a.length() - 1; i >= 0; i--) {
            for (int j = b.length() - 1; j >= 0; j--) {
                int ans = 0;

                if (a.charAt(i) == b.charAt(j)) {
                    ans = 1 + dp[i + 1][j + 1];
                } else {
                    int option1 = dp[i + 1][j];
                    int option2 = dp[i][j + 1];

                    ans = Math.max(option1, option2);
                }

                dp[i][j] = ans;
            }
        }

        System.out.println(Arrays.deepToString(dp));
        return dp[0][0];
    }


    // optimised code in terms of space

    static int solveOpti(String a,String b){

        int[] cur = new int[b.length()+1];
        int[] next = new int[b.length()+1];
        // Arrays.fill(cur,0);
        // Arrays.fill(next,0);

        for(int i = a.length()-1;i>=0;i-- ){
            for(int j=b.length()-1;j>=0;j--){

                int ans=0;

                if(a.charAt(i) == b.charAt(j)){
                    ans = 1 + next[j+1];
                }else{
                    int option1 = next[j];
                    int option2 =cur[j+1];

                    ans = Math.max(option1,option2);
                }

                cur[j]=ans;
            }

            // after each iteration
            next = cur;
        }

        return cur[0];
    }



}
