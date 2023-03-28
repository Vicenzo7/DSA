package array.easy;

import java.util.Arrays;

public class MissingNumber1toN {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        // Your code goes her
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return 0;
    }
}
