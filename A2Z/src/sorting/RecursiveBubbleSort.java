package sorting;

import java.util.Arrays;

public class RecursiveBubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        recursiveBubbleSort(nums, 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
    }

    private static void recursiveBubbleSort(int[] nums, int col, int row) {

        if (row < 0)
            return;

        if (col < row) {
            if (nums[col] > nums[col + 1]) {
                int temp = nums[col];
                nums[col] = nums[col + 1];
                nums[col + 1] = temp;
            }
            recursiveBubbleSort(nums, col + 1, row);
        } else {
            recursiveBubbleSort(nums, 0, row - 1);
        }

    }
}
