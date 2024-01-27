package greedy;

public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        // kadane's algorithm
        int maxSum = nums[0];
        int currSum = 0;
        for (int num : nums) {
            currSum = Math.max(currSum, 0);
            currSum += num;
            maxSum = Math.max(maxSum, currSum);
        }
        return maxSum;
    }
}
