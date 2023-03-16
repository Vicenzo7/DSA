package sorting;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        insertionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void insertionSort(int[] nums) {
        /*
            traverse the array , for each element  put it in its right position
            Basic idea take subarray in increasing order and sort that array
         */
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j > 0 ; j--) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j]= nums[j-1];
                    nums[j-1] = temp;
                } else {
                    break;
                }
            }
        }
    }
}
