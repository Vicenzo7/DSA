package Problems;

import java.util.Stack;

//https://practice.geeksforgeeks.org/problems/max-rectangle/1/#
public class MaxRectangle {

    public static int maxArea(int M[][], int n, int m) {
        //compute area for the first row
        int area = largestArea(M[0]);

        for(int i =1;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                //row update : by adding previous row value
                //update row only if base is not 0
                if(M[i][j] !=0)
                {
                    M[i][j] = M[i][j] + M[i-1][j];
                }
                else
                {
                    M[i][j] = 0;
                }

            }

            //entire row is updated now
            //check largest area for updated row
            int newArea =largestArea(M[i]);
            area = Math.max(area, newArea);
        }

        return area;

    }

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

        //traversing from first
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



        int maxArea = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int length = nums[i];
            int breadth = next[i] - prev[i] -1;
            int newArea = length * breadth;

            maxArea= Math.max(newArea,maxArea);
        }


        return maxArea;
    }

    public static void main(String[] args) {
        int[][] M = {{0,1,1,0},
                {1,1,1,1},
                {1,1,1,1},
                {1,1,0,0}};

        int n = 4;
        int m = 4;

        System.out.println(maxArea(M,n,m));
    }
}
