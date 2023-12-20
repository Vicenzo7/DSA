package slidingwindow.variableSize;

public class MinimumSizeSubArraySum {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(target, nums));
    }

    public static int minSubArrayLen(int target, int[] nums) {
        int sum = 0;
        int minimumLength = Integer.MAX_VALUE, left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];
            while (sum >= target) {
                minimumLength = Math.min(minimumLength, right - left + 1);
                sum -= nums[left];
                left += 1;
            }


        }

        return minimumLength == Integer.MAX_VALUE ? 0 : minimumLength;
    }
}
