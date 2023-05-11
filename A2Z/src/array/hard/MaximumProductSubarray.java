package array.hard;

public class MaximumProductSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 2, -7, -8, 9, -2};
        System.out.println(maxProduct(nums));
        System.out.println(maxProductOptimal1(nums));
        System.out.println(maxProductOptimal2(nums));
    }


    /*
        Brute Force Approach
        Find the product of every sub-array and keep tracking the maximum product

        TC = O(n^2)
        SC = O(1)
    */

    public static int maxProduct(int[] nums) {
        int maxProduct = 0;
        for (int i = 0; i < nums.length; i++) {
            int currentProduct = 1;
            for (int j = i; j < nums.length; j++) {
                currentProduct *= nums[j];
                maxProduct = Math.max(maxProduct, currentProduct);
            }
        }
        return maxProduct;
    }

    /*
    Solution: Two Traversals

    Approach:

    Idea is to find the maximum product from both sides,
    i.e, once in a forwarding direction and another in the backward direction.

    Following are the steps for the approach:

    Step1: Iteration from left to right once to get maximum product for forward direction.
    Step2: If zero is encountered, we set all variables again to initial value.
    Step3: Iteration from right to left once again to get maximum product for backward direction.
    Step4: If zero is encountered, we set all variables again to zero to find a new sub-array with maximum product.
    Step5: Once both iterations are completed, the overall result for the maximum product sub-array of the given array
           is the maximum product obtained from both the iterations.

    Time Complexity: O(N)
    Reason: O(N) iteration two times for computing maximum product.

    Space Complexity: O(1)
    Reason: No extra data structures are used for computation.

    */
    public static int maxProductOptimal1(int[] nums) {
        int maxProductFromLeft = nums[0];
        int maxProductFromRight = nums[0];

        boolean isZeroPresent = false;

        int product = 1;

        // traverse from the front and calculate the left product.
        for (int num : nums) {
            product *= num;
            if (product == 0) {
                isZeroPresent = true;
                product = 1;
                continue;
            }
            maxProductFromLeft = Math.max(maxProductFromLeft, product);
        }

        product = 1;
        // now traverse from the back and calculate the product
        for (int i = nums.length - 1; i >= 0; i--) {
            product *= nums[i];
            if (nums[i] == 0) {
                isZeroPresent = true;
                product = 1;
                continue;
            }
            maxProductFromRight = Math.max(maxProductFromRight, product);
        }

        if (isZeroPresent) {
            return Math.max(Math.max(maxProductFromLeft, maxProductFromRight), 0);
        }
        return Math.max(maxProductFromLeft, maxProductFromRight);
    }

  /*  Solution: Kadane’s Algorithm
    The pick point for this problem is that we can get the maximum product from the product of two negative numbers too.

    Following are the steps for the approach:

    Initially store 0th index value in prod1, prod2 and result.
    Traverse the array from 1st index.
    For each element, update prod1 and prod2.
    Prod1 is maximum of current element, product of current element and prod1, product of current element and prod2
    Prod2 is minimum of current element, product of current element and prod1, product of current element and prod2
    Return maximum of result and prod1

    TC = O(n) -> single traversal

    */

    public static int maxProductOptimal2(int[] nums) {
        int prod1 = nums[0], prod2 = nums[0], maxProduct = nums[0];

        for (int num : nums) {
            int temp = Math.max(num, Math.max(prod1 * num, prod2 * num));
            prod2 = Math.min(num, Math.min(prod1 * num, prod2 * num));
            prod1 = temp;

            maxProduct = Math.max(maxProduct, prod1);
        }
        return maxProduct;
    }
}
