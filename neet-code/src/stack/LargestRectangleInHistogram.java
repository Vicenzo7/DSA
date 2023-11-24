package stack;

import java.util.Arrays;
import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] heights = {2, 1, 5, 6, 2, 3};

        System.out.println("Next Greater    " + Arrays.toString(nextGreater(heights)));
        System.out.println("Previous Greater" + Arrays.toString(prevGreater(heights)));
        System.out.println("Next Smaller    " + Arrays.toString(nextSmaller(heights)));
        System.out.println("Previous Smaller" + Arrays.toString(prevSmaller(heights)));
        System.out.println(largestRectangleArea(heights));
    }

    static class Pair {
        private int index;
        private int height;

        public Pair(int index, int height) {
            this.index = index;
            this.height = height;
        }

        public int getIndex() {
            return index;
        }

        public int getHeight() {
            return height;
        }
    }

    // optimal solution
    // TC = O(n)  SC = O(n)
    public static int largestRectangleArea(int[] heights) {
        Stack<Pair> stack = new Stack<>();

        int maxRectangle = Integer.MIN_VALUE;
        for (int i = 0; i < heights.length; i++) {
            int start = i;
            while (!stack.isEmpty() && stack.peek().getHeight() >= heights[i]) {
                // this means we have reached bounder conditions for the top element of the stack
                Pair pair = stack.pop();
                start = pair.index; // doing this because the current height can be extended towards left
                maxRectangle = Math.max(maxRectangle, pair.getHeight() * (i - start));
            }
            stack.push(new Pair(start, heights[i]));
        }

        while (!stack.empty()) {
            // this means whatever elements are in the stack, those can be stretched till the end of the array
            Pair pair = stack.pop();
            maxRectangle = Math.max(maxRectangle, pair.getHeight() * (heights.length - pair.getIndex()));
        }

        return maxRectangle;
    }


//    public static int largestRectangleArea(int[] heights) {
//        int[] nse = nextSmaller(heights);
//        int[] pse = prevSmaller(heights);
//
//        int maxRectangle = Integer.MIN_VALUE;
//        for (int i = 0; i < heights.length; i++) {
//            int length = heights[i];
//            int breadth = nse[i] - pse[i]-1;
//            maxRectangle = Math.max(maxRectangle, length * breadth);
//        }
//
//        return maxRectangle;
//    }



    /*

        Next Smaller And Previous Smaller -> Stack Values are monotonically increasing order
        Next Greater And Previous Greater -> Stack Values are monotonically decreasing order

        To find next greater or next smaller -> traverse from backward
        To find previous greater or previous smaller -> traverse from forward



    */


    public static int[] nextSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] nse = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                nse[i] = stack.peek();
            } else {
                nse[i] = nums.length; // last index
            }

            stack.push(i);
        }
        return nse;
    }

    public static int[] prevSmaller(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        int[] pse = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                pse[i] = stack.peek();
            } else {
                pse[i] = -1; // last index from left
            }

            stack.push(i);
        }
        return pse;
    }


    public static int[] nextGreater(int[] nums) {
        int[] nge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if (!stack.empty()) {
                nge[i] = stack.peek();
            } else {
                nge[i] = -1;
            }

            stack.add(nums[i]);
        }

        return nge;
    }

    public static int[] prevGreater(int[] nums) {
        int[] pge = new int[nums.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }

            if (!stack.empty()) {
                pge[i] = stack.peek();
            } else {
                pge[i] = -1;
            }

            stack.add(nums[i]);
        }

        return pge;
    }

}
