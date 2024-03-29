package arrayhashing;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelf2(nums)));
    }

//    public static int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        for (int i = 0; i < nums.length; i++) {
//            int product = 1;
//            for (int j = 0; j < nums.length; j++) {
//                if (i == j) continue;
//                product *= nums[j];
//            }
//            result[i] = product;
//        }
//        return result;
//    }

//    public static int[] productExceptSelf(int[] nums) {
//        int[] result = new int[nums.length];
//        int product = 1;
//        for (int num : nums) {
//            product *= num;
//        }
//
//        for (int i = 0; i < nums.length; i++) {
//            nums[i] = product / nums[i];
//        }
//        return nums;
//    }


    public static int[] productExceptSelf2(int[] nums) {
        int[] result = new int[nums.length];
        int[] prefixArray = new int[nums.length];
        int[] postfixArray = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixArray[i] = nums[i];
            } else {
                prefixArray[i] = nums[i] * prefixArray[i - 1];
            }
        }

        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                postfixArray[i] = nums[i];
            } else {
                postfixArray[i] = nums[i] * postfixArray[i + 1];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int prefix = (i > 0) ? prefixArray[i - 1] : 1;
            int postfix = (i < nums.length - 1) ? postfixArray[i + 1] : 1;
            result[i] = prefix * postfix;
        }

        return result;
    }

    /* Prefix Postfix Method*/
    public static int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        Arrays.fill(result, 1);

        int prefix = 1;
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }


        int postfix = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }


}
