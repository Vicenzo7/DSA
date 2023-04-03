package array.medium;

public class MaximumSubarraySumInAnArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
        System.out.println(maxSubArrayOptimal(nums));
    }

    /*
     * Brute force
     * TC O(n^2)*/
    public static int maxSubArray(int[] nums) {
        int[] subArrayIndex = new int[2];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > max) {
                    max = sum;
                    subArrayIndex[0] = i;
                    subArrayIndex[1] = j;
                }
            }
        }
        for (int i = subArrayIndex[0]; i <= subArrayIndex[1]; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return max;
    }

    /*Kadane's Algorithm
     * TC O(n)
     * To print the subarray we will use 3 variables
     * ie start, end and s =0
     * whenever we find a new max ie sum > max we will update the max and also start and end
     * ie start = 0 and end = i
     * But if we find sum < 0 we update the sum to 0 and our new starting point will be s = i+1;
     * */

    public static int maxSubArrayOptimal(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        int startingPoint = 0, start = 0, end = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
                start = startingPoint;
                end = i;
            }
            if (sum < 0) {
                sum = 0;
                startingPoint = i + 1;
            }
        }
        for (int i = start; i <= end; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
        return max;
    }
}
