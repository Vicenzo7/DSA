package binarysearch.bsInSearchSpace;

public class FindTheSmallestDivisorGivenAThreshold {
    public static void main(String[] args) {
        int[] nums = {12, 50, 11, 75, 57, 12, 73, 4, 69, 78};
        int threshold = 649;

        System.out.println(smallestDivisor(nums, threshold));
    }

    /*
        Binary Search Space Problem
        Basic find the range,
        range will be from 1int a to maxElement in the array.
        Edge Case. if no of element == threshold, the smallest divisor will be the maxElement by logic

        After range is found calculate the mid anc check if mid can be a smallest divisor,
        if mid is the smallest divisor store it and go towards left because we need minimum
        if not go towards right.

        How to check if mid is the smallest divisor.
        Iterate the array and for each element divide it by mid and get it whole quotient
        eg 1/4 = 0.25, 10/5 = 2
        Now ciel the quotient and add it to the sum.

        At the end check if the sum <= threshold, if true return true else false.

        TC = O(n * log(maxElement))
        Reason n to find the max, where n is length of nums
        log(maxElement) because binarySearch is applied from 0 to  maxElement.

    */

    public static int smallestDivisor(int[] nums, int threshold) {
        int ans = -1;
        int max = Integer.MIN_VALUE;
        // finding search space
        for (int num : nums) {
            max = Math.max(num, max);
        }

        if (nums.length == threshold) return max;
        int low = 1, high = max;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isSmallestDivisor(nums, mid, threshold)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isSmallestDivisor(int[] nums, int mid, int threshold) {
        int sum = 0;
        for (int num : nums) {
            double divisionResult = (double) num / mid;
            int roundedResult = (int) Math.ceil(divisionResult);
            sum += (int) roundedResult;
        }
        return sum <= threshold;
    }
}
