package greedy;

import java.util.Arrays;

public class KadaneAlgorithm {
    public static void main(String[] args) {
        int[] nums = {4, -1, 2, -7, 3, 4};
        System.out.println(kadaneAlgorithm(nums));
        System.out.println(Arrays.toString(kadaneAlgorithmSlidingWindow(nums)));
    }


    // Kadane's Algorithm :O(n)
    public static int kadaneAlgorithm(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }

        return maxSum;
    }

    // Kadane's Algorithm : Sliding window variation
    public static int[] kadaneAlgorithmSlidingWindow(int[] nums) {
        int maxSum = nums[0];
        int currSum = 0;
        int left = 0;
        int maxLeft = 0;
        int maxRight = 0;

        for (int right = 0; right < nums.length; right++) {
            if (currSum < 0) {
                currSum = 0;
                left = right;
            }

            currSum += nums[right];
            if (currSum > maxSum) {
                maxSum = currSum;
                maxLeft = left;
                maxRight = right;
            }
        }
        return new int[]{maxLeft, maxRight};
    }
}
