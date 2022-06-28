package com.company;

import java.util.Arrays;
import java.util.Stack;

public class NextSmallerElement {
    public static void main(String[] args) {
        int[] nums = {3, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmaller(nums, nums.length)));
    }

    public static int[] nextSmaller(int nums[], int n) {
        int[] nse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //traversing from last
        for (int i = n - 1; i >= 0; i--) {
            // removing elements from stack that are greater
            while (!stack.empty() && stack.peek() >= nums[i]) {
                stack.pop();
            }


            if (!stack.empty())
                nse[i] = stack.peek();
            else
                nse[i] = -1;

            stack.push(nums[i]);
        }

        return nse;
    }
}
