package Problems;

import java.util.Arrays;
import java.util.Stack;

public class PreviousGreaterElement {
    public static void main(String[] args) {
        int[] nums = {100,80,60,70,60,75,85};

        System.out.println(Arrays.toString(prevSmaller(nums, nums.length)));
    }

    public static int[] prevSmaller(int nums[], int n) {
        int[] pge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //traversing from last
        for (int i = 0; i < n; i++) {
            // removing elements from stack that are smaller
            while (!stack.empty() && stack.peek() <= nums[i]) {
                stack.pop();
            }


            if (!stack.empty())
                pge[i] = stack.peek();
            else
                pge[i] = -1;

            stack.push(nums[i]);
        }

        return pge;
    }
}
