package dp.onedimension.batchII;

public class CheckIfThereIsValidPartitionForTheArray {
    public static void main(String[] args) {
        int[] nums = {4, 4, 4, 5, 6};
//        int[] nums = {1, 1, 1, 2};
        System.out.println(validPartition(nums));
    }

    public static boolean validPartition(int[] nums) {
//        return bruteForce(0, nums);
//        return memoization(0, nums, new Boolean[nums.length + 1]);
        return dp(nums);
    }


    private static boolean bruteForce(int index, int[] nums) {
        if (index >= nums.length) {
            return true;
        }

        // check if there are two elements to check
        if (nums.length - index < 2) {
            return false;
        }

        boolean twoEqualElements = nums[index] == nums[index + 1] && bruteForce(index + 2, nums);

        // check if there are three elements to check
        if (nums.length - index < 3) {
            return twoEqualElements;
        }

        boolean threeEqualElements = nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2];
        boolean consecutiveIncreasingElements = nums[index + 1] - nums[index] == 1 && nums[index + 2] - nums[index + 1] == 1;
        boolean threeElements = (threeEqualElements || consecutiveIncreasingElements) && bruteForce(index + 3, nums);
        return twoEqualElements || threeElements;

    }

    private static boolean memoization(int index, int[] nums, Boolean[] cache) {
        if (index >= nums.length) {
            return true;
        }

        if (cache[index] != null) {
            return cache[index];
        }

        // check if there are two elements to check
        if (nums.length - index < 2) {
            return false;
        }

        boolean twoEqualElements = nums[index] == nums[index + 1] && memoization(index + 2, nums, cache);

        // check if there are three elements to check
        if (nums.length - index < 3) {
            return cache[index] = twoEqualElements;
        }

        boolean threeEqualElements = nums[index] == nums[index + 1] && nums[index + 1] == nums[index + 2];
        boolean consecutiveIncreasingElements = nums[index + 1] - nums[index] == 1 && nums[index + 2] - nums[index + 1] == 1;
        boolean threeElementsValidation = (threeEqualElements || consecutiveIncreasingElements) && memoization(index + 3, nums, cache);
        return cache[index] = twoEqualElements || threeElementsValidation;
    }


    private static boolean dp(int[] nums) {

        if (nums.length == 1) {
            return false;
        }

        boolean[] dp = new boolean[3];
        dp[0] = true; // of empty string
        dp[1] = false; // a single element cannot form a sub array
        dp[2] = nums[0] == nums[1];


        for (int i = 2; i < nums.length; i++) {
            boolean currentDp = false;
            if (nums[i] == nums[i - 1] && dp[1]) {
                currentDp = true;
            } else if (nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && dp[0]) {
                currentDp = true;
            } else if (nums[i] - nums[i - 1] == 1 && nums[i - 1] - nums[i - 2] == 1 && dp[0]) {
                currentDp = true;
            }

            dp[0] = dp[1];
            dp[1] = dp[2];
            dp[2] = currentDp;
        }

        return dp[2];
    }
}
