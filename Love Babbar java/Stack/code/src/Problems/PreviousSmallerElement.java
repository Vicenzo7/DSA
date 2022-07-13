package Problems;

import java.util.Arrays;
import java.util.Stack;

public class PreviousSmallerElement {
    public static void main(String[] args) {
        int[] nums = {3, 8, 5, 2, 25};

        System.out.println(Arrays.toString(prevSmaller(nums, nums.length)));
    }

    public static int[] prevSmaller(int nums[], int n) {
        int[] pse = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        //traversing from last
        for (int i = 0; i < n; i++) {
            // removing elements from stack that are greater
            while (!stack.empty() && stack.peek() >= nums[i]) {
                stack.pop();
            }


            if (!stack.empty())
                pse[i] = stack.peek();
            else
                pse[i] = -1;

            stack.push(nums[i]);
        }

        return pse;
    }
}
