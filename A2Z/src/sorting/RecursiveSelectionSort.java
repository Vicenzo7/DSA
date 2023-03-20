package sorting;

import java.util.Arrays;

public class RecursiveSelectionSort {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        recursiveSelectionSort(nums, nums.length, 0, 0);
        System.out.println(Arrays.toString(nums));
    }

    private static void recursiveSelectionSort(int[] nums, int row, int col, int maxIndex) {

        if (row == 0)
            return;

        if (col < row) {
            // find the maxElementIndex
            if (nums[maxIndex] < nums[col]) {
                recursiveSelectionSort(nums, row,col+1, col);
            } else {
                recursiveSelectionSort(nums, row,col+1,maxIndex);
            }
        } else {
            // after maxElementIndex is found put that max element in the last index
            int temp = nums[row - 1];
            nums[row - 1] = nums[maxIndex];
            nums[maxIndex] = temp;
            recursiveSelectionSort(nums, row-1,0, 0);
        }

    }
}
