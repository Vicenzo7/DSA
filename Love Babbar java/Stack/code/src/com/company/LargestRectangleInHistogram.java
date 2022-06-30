package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {

    public static void main(String[] args) {
        int[] nums = {2,1,5,6,2,3};
//        System.out.println(Arrays.toString(nextSmaller(nums, nums.length)));
//
//        System.out.println(Arrays.toString(prevSmaller(nums, nums.length)));

        int ans = largestArea(nums);
        System.out.println(ans);
    }

    // next smaller element
    public static int[] nextSmaller(int nums[], int n) {
        int[] nse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //traversing from last
        for (int i = n - 1; i >= 0; i--) {
            // removing elements from stack that are greater
            while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }


            if (!stack.empty())
                nse[i] = stack.peek();
            else
                nse[i] = n;

            stack.push(i);
        }

        return nse;
    }



    //previous smaller element
    public static int[] prevSmaller(int nums[], int n) {
        int[] pse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //traversing from last
        for (int i = 0; i < n; i++) {
            // removing elements from stack that are greater
            while (!stack.empty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }


            if (!stack.empty())
                pse[i] = stack.peek();
            else
                pse[i] = -1;

            stack.push(i);
        }

        return pse;
    }


    public static int largestArea(int nums[])
    {
        int[] prev = prevSmaller(nums, nums.length);
        int[] next = nextSmaller(nums, nums.length);

        System.out.println(Arrays.toString(prev));
        System.out.println(Arrays.toString(next));

        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int length = nums[i];
            int breadth = next[i] - prev[i] -1;
            int newArea = length * breadth;

            maxArea= Math.max(newArea,maxArea);
        }


        return maxArea;
    }
}


