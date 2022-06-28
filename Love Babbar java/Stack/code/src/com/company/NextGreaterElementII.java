package com.company;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElementII {
    public static void main(String[] args) {

        int[] nums = {2,10,12,1,11};
        int[] ans = nextGreaterElements(nums);
        System.out.println(Arrays.toString(ans));
    }

    public static int[] nextGreaterElements(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        int n =nums.length;
        //traverse till 2n-1 because we want to traverse circular
        for(int i=2*n-1;i >=0;i--)
        {
            while(!stack.empty() &&  stack.peek() <= nums[i%n]){
                stack.pop();
            }

            if(i<n)
            {
                if(!stack.empty())
                    nge[i] = stack.peek();
                else
                    nge[i] = -1;
            }

            stack.push(nums[i%n]);
        }

        return nge;
    }
}
