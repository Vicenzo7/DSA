package sorting;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        bubbleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void bubbleSort(int[] nums) {
        // traverse the array till the length -1
        for (int i = 0; i < nums.length-1; i++) {
            boolean swapped = false;
            // after each iteration max element will come at last index
            for (int j = 1; j <= nums.length-1-i; j++) {
                if (nums[j] < nums[j-1]) {
                    int temp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1]= temp;
                    swapped = true;
                }
            }
            // is swapping doesn't take place that means the array is sorted, and we can break instead of running the loop
            if (!swapped) break;
        }
    }
}
