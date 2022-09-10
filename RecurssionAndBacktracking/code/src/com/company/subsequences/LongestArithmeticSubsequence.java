package com.company.subsequences;
//https://leetcode.com/problems/longest-arithmetic-subsequence/
public class LongestArithmeticSubsequence {
    public static void main(String[] args) {
        int[] nums = {3,6,9,12};
        System.out.println(longestArithSeqLength(nums));
    }

    public static int longestArithSeqLength(int[] nums) {
        int ans = 0;

        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){

                int difference = nums[j]-nums[i];
                // 2 + because 2 numbers added - imaginary
                ans = Math.max(ans,2+solve(nums,i,difference));
            }
        }
        return ans;
    }

    // for backward check
    static int solve(int[] nums, int i, int difference)
    {
        if(i < 0)
            return 0;

        int ans =0;
        // backward check
        for(int k = i-1;k>=0;k--){
            if(nums[i] - nums[k] == difference){
                ans = Math.max(ans,1+solve(nums,k,difference));
            }
        }

        return ans;
    }

}
