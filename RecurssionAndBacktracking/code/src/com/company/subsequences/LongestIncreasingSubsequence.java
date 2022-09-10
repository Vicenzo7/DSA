package com.company.subsequences;
//https://leetcode.com/problems/longest-increasing-subsequence/
public class LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(lengthOfLIS(nums));
    }


    public static int lengthOfLIS(int[] num) {
        int cur =0;
        int prev =-1;

        int ans = solve(num,cur,prev);
        return ans;
    }


    static int solve(int[] num ,int cur,int prev){
        // base case
        if(cur == num.length)
            return 0;


        // include
        int pick =0;
        if(prev ==-1 || num[cur]>num[prev])
            pick = 1+ solve(num,cur+1,cur);

        int notPick =0+solve(num,cur+1,prev);

        return Math.max(pick,notPick);
    }
}
