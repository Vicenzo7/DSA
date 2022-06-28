package com.company;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElement1 {
    public static void main(String[] args) {
        int[] nums1 ={4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1,nums2)));
    }

    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {

        // BRUTE FORCE APPROACH

//        int[] res = new int[nums1.length];
//        int temp = 0;
//
//        for(int i=0;i<nums1.length;i++)
//        {
//            // imagine us at index = 0 -> value is 4
//
//            int index = -1;
//
//            for(int j=0;j<nums2.length;j++)
//            {
//                // now we have to find the index of it in our nums2 array
//                if(nums1[i] == nums2[j])
//                {
//                    index = j;
//                }
//            }
//
//            // now from this index value till the length, we will traverse to find the first greater element
//
//            int max = nums2[index];
//            boolean check = false;
//
//            for(int k=index;k<nums2.length;k++)
//            {
//
//                if(nums2[k] > max)
//                {
//                    max = nums2[k];
//                    check = true;
//                    break;
//                }
//            }
//
//            // let's store this max value in our new array
//            if(check == true)
//                res[temp] = max;
//            else
//                res[temp] = -1;
//
//            temp++;
//        }
//
//        return res;



        // OPTIMISED APPROACH
        HashMap<Integer , Integer> greater = new HashMap();
        Stack<Integer> stack = new Stack();

        for(int num : nums2)
        {
            while(!stack.empty() && stack.peek() < num){
                greater.put(stack.pop(),num);
            }
            stack.push(num);
        }

        for(int i=0;i<nums1.length;i++)
        {
            nums1[i] = greater.getOrDefault(nums1[i] , -1);
        }

        return nums1;
    }
}
