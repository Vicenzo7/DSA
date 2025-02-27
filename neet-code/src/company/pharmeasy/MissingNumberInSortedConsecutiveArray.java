package company.pharmeasy;

import java.util.Arrays;

public class MissingNumberInSortedConsecutiveArray {
    /*

        Find missing element in a sorted array of consecutive numbers

    */

    public static void main(String[] args) {
//        int[] nums = {-9, -8, -7, -5, -4, -3, -2, -1, 0};
        int[] nums = {4, 3, 5, 6};
        System.out.println(findMissingInSortedArray(nums));
        System.out.println(findMissingInUnsortedArray(nums));
    }


    private static int findMissingInSortedArray(int[] nums) {
        int n = nums.length;

        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // check if middle element is inconsistent
            if (nums[mid] - mid == nums[0]) {
                // no inconsistency till mid, check if next of mid is inconsistent
                if (nums[mid + 1] - nums[mid] > 1) {
                    return nums[mid] + 1;
                } else {
                    start = mid + 1;
                }
            } else {
                // there is an inconsistency, check if previous of mid is inconsistent
                if (nums[mid] - nums[mid - 1] > 1) {
                    return nums[mid] - 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    private static int findMissingInUnsortedArray(int[] nums) {
        int min = Arrays.stream(nums).min().getAsInt();
        int max = Arrays.stream(nums).max().getAsInt();
        int sum = Arrays.stream(nums).sum();

        // calculate expected sum from min to max
        int expectedSum = ((max * (max + 1)) / 2) - ((min * (min - 1)) / 2);

        int ans = expectedSum - sum;
        return ans != 0 ? ans : max + 1;
    }

}
