package com.company.math;

public class PredictTheWinner {
    public static void main(String[] args) {
        int[] nums = {20,30,2,2,2,10};
        System.out.println(predictTheWinner(nums));
    }

    public static boolean predictTheWinner(int[] nums) {
        int sum = 0;

        for(int k=0;k<nums.length;k++)
        {
            sum += nums[k];
        }
        System.out.println(sum);
        int i=0;
        int j= nums.length-1;
        int myScore = optimalGameStratergy(nums,i,j);
        System.out.println( myScore);


        int oppScore = sum-myScore;
        System.out.println(oppScore);
        return myScore>oppScore;
    }

    public static int optimalGameStratergy(int[] nums,int i,int j){

        if(i>j)
            return 0;

        int choice1 = nums[i] + Math.min(optimalGameStratergy(nums,i+2,j),optimalGameStratergy(nums,i+1,j-1));

        int choice2 = nums[j] + Math.min(optimalGameStratergy(nums,i+1,j-1),optimalGameStratergy(nums,i,j-2));

        return Math.max(choice1,choice2);
    }
}
