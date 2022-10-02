package com.backtracking;

import java.util.ArrayList;
import java.util.List;

public class SumOfAllSubsetXORTotals {
    public static void main(String[] args) {
        int[] nums = {5,1,6};
        System.out.println(subsetXORSum(nums));
    }

    // Finding all subset and adding the XOR

//    public static int subsetXORSum(int[] nums) {
//        List<List<Integer>> ans = new ArrayList<>();
//        ArrayList<Integer> temp = new ArrayList<>();
//        solve(nums,0,ans,temp);
//
//        int sum =0;
//
//        for(List<Integer> list : ans){
//            int sum2 =0;
//
//            if(list.size() == 0){
//                continue;
//            }
//            for(int n:list){
//                sum2 = sum2^n;
//            }
//            sum = sum+ sum2;
//        }
//        return sum;
//    }
//
//
//    public static void solve(int[] nums,int index,List<List<Integer>> ans ,ArrayList<Integer> temp)
//    {
//        //base case
//        if(index == nums.length)
//        {
//            ans.add(temp);
//            return;
//        }
//
//        //include
//        int val = nums[index];
//        temp.add(val);
//        solve(nums,index+1,ans,new ArrayList<>(temp));
//
//        temp.remove(temp.size()-1);
//
//        //exclude
//        solve(nums,index+1,ans,new ArrayList<>(temp));
//    }


    // After each subset is found the sum is processed there itself
    public static int subsetXORSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        solve(nums,0,ans,temp);
        return sum;
    }

    static int sum =0;

    public static void solve(int[] nums,int index,List<List<Integer>> ans ,ArrayList<Integer> temp)
    {
        //base case
        if(index == nums.length)
        {
            ans.add(temp);
            int tempSum =0;
            if(temp.size() == 0){
                return;
            }
            for(int n:temp){
                tempSum = tempSum^n;
            }

            sum = sum+tempSum;


            return;
        }

        //exclude
        solve(nums,index+1,ans,new ArrayList<>(temp));

        //include
        int val = nums[index];
        temp.add(val);
        solve(nums,index+1,ans,new ArrayList<>(temp));
    }
}
