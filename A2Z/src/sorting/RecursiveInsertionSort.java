package sorting;

import java.util.Arrays;

public class RecursiveInsertionSort {
    public static void main(String[] args) {
//        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        int[] nums = {2};
        // start from 1 because a single element is always sorted
        recursiveInsertionSort(nums, 1, nums.length - 1);
        System.out.println(Arrays.toString(nums));
    }

    private static void recursiveInsertionSort(int[] nums, int i, int n) {
        int value = nums[i]; // this value we are going to put in right position
        int j = i;

        while (j > 0 && nums[j - 1] > value) {
            // if nums[j-1] > then the value we want to put in right position we put num[j-1] to its position and check if there are any greater element then the value
            nums[j] = nums[j - 1];
            j--;
        }
        // At this point there are no element greater than value, so we insert the value at this position
        nums[j] = value;
        if (i + 1 <= n) {
            recursiveInsertionSort(nums, i + 1, n);
        }

    }
}
