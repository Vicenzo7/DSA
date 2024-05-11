package dp.onedimension;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {2, 3, -2, 4};

        System.out.println(maxProduct(nums));
        System.out.println(maxProductOptimised(nums));
    }

    private static int maxProductOptimised(int[] nums) {
        int maxLeftProduct = Integer.MIN_VALUE;
        int maxRightProduct = Integer.MIN_VALUE;
        int product = 1;
        boolean isZeroPresent = false;

        for (int num : nums) {
            product *= num;
            if (num == 0) {
                isZeroPresent = true;
                product = 1;
                continue;
            }
            maxLeftProduct = Math.max(maxLeftProduct, product);
        }

        product = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            int num = nums[i];
            product *= num;
            if (num == 0) {
                isZeroPresent = true;
                product = 1;
                continue;
            }
            maxRightProduct = Math.max(maxRightProduct, product);
        }
        return isZeroPresent ? Math.max(0, Math.max(maxLeftProduct, maxRightProduct)) :
                Math.max(maxLeftProduct, maxRightProduct);
    }


    public static int maxProduct(int[] nums) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int product = 1;
            for (int j = i; j < nums.length; j++) {
                product *= nums[j];
                maxProduct = Math.max(maxProduct, product);
            }
        }
        return maxProduct;
    }
}
