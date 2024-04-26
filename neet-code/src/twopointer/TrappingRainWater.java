package twopointer;

public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(height));
    }


    /*

    Important Equation = to finding how many block of water can be stored at current index
    min(max height at left after i,max height at right after i) - height[i]
     */

    // Solution 1:
//    public static int trap(int[] height) {
//        // TC = O(n)  SC = O(n)
//
//        int n = height.length;
//        int[] maxLeftHeight = new int[n];
//        int[] maxRightHeight = new int[n];
//
//        int maxLeft = 0;
//        for (int i = 0; i < n; i++) {
//            maxLeftHeight[i] = maxLeft;
//            maxLeft = Math.max(maxLeft, height[i]);
//        }
//
//        int maxRight = 0;
//        for (int i = n - 1; i >= 0; i--) {
//            maxRightHeight[i] = maxRight;
//            maxRight = Math.max(maxRight, height[i]);
//        }
//
//        int totalUnitOfWaterStored = 0;
//        for (int i = 0; i < height.length; i++) {
//            int waterStored = Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
//            if (waterStored > 0) {
//                totalUnitOfWaterStored += waterStored;
//            }
//        }
//
//        return totalUnitOfWaterStored;
//    }


    // Solution 1:
    public static int trap(int[] height) {
        // TC = O(n)  SC = O(1)
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int result = 0;

        while (left < right) {
            // In the formula we need min of maxLeft and maxRight so
            if (maxLeft < maxRight) {
                // updating the one which is less
                left += 1;
                // update maxLeft
                maxLeft = Math.max(maxLeft, height[left]);
                result += maxLeft - height[left]; // not checking if > 0 because it will always be greater than 0
                // until the current step is done before the above step
            } else {
                right -= 1;
                maxRight = Math.max(maxRight, height[right]);
                result += maxRight - height[right];
            }
        }

        return result;
    }
}
