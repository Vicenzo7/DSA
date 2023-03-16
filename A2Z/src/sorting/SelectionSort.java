package sorting;

import java.util.Arrays;

public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));

    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int lastIndex = nums.length - 1 - i;
            int maxIndex = getIndexWithMaxElement(nums, lastIndex);
            int temp = nums[maxIndex];
            nums[maxIndex] = nums[lastIndex];
            nums[lastIndex] = temp;
        }
    }

    private static int getIndexWithMaxElement(int[] nums, int end) {
        int maxIndex = 0;
        for (int i = 0; i <= end; i++) {
            if (nums[i] > nums[maxIndex]) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
}
