package com.company;

import java.util.Arrays;

//https://leetcode.com/problems/minimum-sideway-jumps/
public class MinimumSidewayJumps {

    public static void main(String[] args) {
        int[] obstacles = {0,1,2,3,0};
        minSideJumps(obstacles);
    }


    public static void minSideJumps(int[] obstacles) {

        int curlane =2;
        int curpos = 0;

        System.out.println(solve(obstacles,curlane,curpos));
         int n = obstacles.length;
         int[][] dp = new int[4][n];
         for(int[] rows:dp){
             Arrays.fill(rows,-1);
         }

        System.out.println(solveMem(obstacles,curlane,curpos,dp));

        System.out.println(solveTab(obstacles));
    }


    static int solve(int[] obs,int curlane,int curpos){
        // base case
        // if frog reached last index/position
        int lastpos =obs.length-1;
        if(curpos == lastpos){
            return 0;
        }

        // straigt movement
        // no obstacle in same lane at next position
        int jump=0;
        if(obs[curpos+1] != curlane){
            jump = solve(obs,curlane,curpos+1);
        }
        else{
            // obstacle present so
            // sideways jump

            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(i != curlane && obs[curpos]!= i){
                    ans = Math.min(ans,1+ solve(obs,i,curpos));
                }
            }
            jump = ans;
        }

        return jump;
    }


    static int solveMem(int[] obs,int curlane,int curpos,int[][]dp){
        // base case
        // if frog reached last index/position
        int lastpos =obs.length-1;
        if(curpos == lastpos){
            return 0;
        }

        if(dp[curlane][curpos] !=-1){
            return dp[curlane][curpos];
        }

        // straigt movement
        // no obstacle in same lane at next position
        int jump =0;
        if(obs[curpos+1] != curlane){
            jump = solveMem(obs,curlane,curpos+1,dp);
        }
        else{
            // obstacle present so
            // sideways jump

            int ans = Integer.MAX_VALUE;
            for(int i=1;i<=3;i++){
                if(i != curlane && obs[curpos]!= i){

                    // 1+ because we did a jump and then went forward

                    ans = Math.min(ans,1+ solveMem(obs,i,curpos,dp));
                }
            }
            jump=ans;
        }

        return dp[curlane][curpos] = jump;
    }


    static int solveTab(int[] obs){
        int n = obs.length-1;

        int[][] dp = new int[4][n+1];
        for(int[] rows:dp){
            Arrays.fill(rows,Integer.MAX_VALUE);
        }

        dp[0][n] = 0;
        dp[1][n] = 0;
        dp[2][n] = 0;
        dp[3][n] = 0;

        for(int currpos = n-1; currpos>=0; currpos--) {
            for(int currlane =1; currlane<=3; currlane++) {
                int finalAns = 0;
                if(obs[currpos+1] != currlane) {
                    finalAns =  dp[currlane][currpos+1];
                }
                else {
                    //sideways movement
                    int ans = Integer.MAX_VALUE;
                    for(int i =1; i<=3; i++ ){
                        if(i != currlane && obs[currpos] != i) {
                            ans = Math.min(ans, 1 + dp[i][currpos + 1] );
                        }
                    }
                    finalAns =  ans;
                }
                dp[currlane][currpos] = finalAns;
            }
        }

        return Math.min(dp[2][0], 1 + Math.min(dp[1][0], dp[3][0]) );
    }
}
