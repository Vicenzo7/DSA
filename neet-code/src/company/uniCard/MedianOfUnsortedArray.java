package company.uniCard;

import java.util.Arrays;

public class MedianOfUnsortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 33, 2, 4, 5, 12, 11, 18, 3, 14};
        System.out.println(median(nums));
    }


    public static double median(int[] nums) {
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int length = nums.length;
        int middle = length / 2;

        if (length % 2 == 0) { // if even
            return nums[middle - 1] / 2.0 + nums[middle] / 2.0;
        } else {
            return nums[middle];
        }
    }
}
