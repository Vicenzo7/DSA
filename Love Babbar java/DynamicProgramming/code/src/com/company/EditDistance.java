package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/edit-distance/
public class EditDistance {
    public static void main(String[] args) {
        String word1 = "horse", word2 = "ros";
        minDistance(word1,word2);
    }

    public static void minDistance(String word1, String word2) {
        System.out.println(solve(word1,word2,0,0));
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }

        System.out.println(solveMem(word1,word2,0,0,dp));

        System.out.println(solveTab(word1,word2));
    }


    static int solve(String a, String b, int i,int j){
        // base case
        if(i == a.length()){
            return b.length()-j;
        }

        if(j == b.length()){
            return a.length()-i;
        }

        int ans =0;
        // if match go ahead
        if(a.charAt(i) == b.charAt(j)){

            ans = solve(a,b,i+1,j+1);
        }else{
            // if not match do operation

            int insertAns = solve(a,b,i,j+1);
            int replaceAns = solve(a,b,i+1,j+1);
            int deleteAns = solve(a,b,i+1,j);


            ans = Math.min(insertAns, Math.min(replaceAns,deleteAns)) +1;
            // adding plus 1 because after performing and action we are going ahead
        }

        return ans;
    }

    static int solveMem(String a, String b, int i,int j ,int[][] dp ){
        // base case
        if(i == a.length()){
            return b.length()-j;
        }

        if(j == b.length()){
            return a.length()-i;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }


        int ans =0;
        // if match go ahead
        if(a.charAt(i) == b.charAt(j)){

            ans = solveMem(a,b,i+1,j+1,dp);
        }else{
            // if not match do operation

            int insertAns = solveMem(a,b,i,j+1,dp);
            int replaceAns = solveMem(a,b,i+1,j+1,dp);
            int deleteAns = solveMem(a,b,i+1,j,dp);


            ans = Math.min(insertAns, Math.min(replaceAns,deleteAns)) +1;
            // adding plus 1 because after performing and action we are going ahead
        }

        return dp[i][j] = ans;
    }



    static int solveTab(String a,String b){
        int[][] dp = new int[a.length()+1][b.length()+1];
        for(int[] row : dp){
            Arrays.fill(row,0);
        }

        for(int j=0;j<b.length();j++){
            dp[a.length()][j] = b.length()-j;
        }

        for(int i=0;i<a.length();i++){
            dp[i][b.length()] = a.length()-i;
        }

        for(int i = a.length() - 1;i>=0;i--){
            for(int j = b.length()-1;j>=0;j--){
                int ans =0;
                // if match go ahead
                if(a.charAt(i) == b.charAt(j)){

                    ans = dp[i+1][j+1];
                }
                else {
                    // if not match do operation

                    int insertAns = dp[i][j+1];
                    int replaceAns = dp[i+1][j+1];
                    int deleteAns = dp[i+1][j];


                    ans = Math.min(insertAns, Math.min(replaceAns,deleteAns)) +1;
                    // adding plus 1 because after performing and action we are going ahead
                }


                dp[i][j] = ans;
            }
        }
        return dp[0][0];
    }
}
