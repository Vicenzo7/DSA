package sorting;

import java.util.Arrays;

public class CycleSort {
    //  1 2 3 4 5 6
    //    0 1 2 3 4 5

    // cycle sort is only for elements from 1 to K
    public static void main(String[] args) {
        int[] nums = {5,4,6,2,1,3};
        cycleSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void cycleSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            // correctIndex of nums[i]
            int correctIndex = nums[i] - 1;
            // check if nums[i] is at its correct index if not swap it to its correct Index , now we will get a new element at nums[i] check if that is ar correctIndex and repeat the step
            // if its at it correct index move i ahead
            if (nums[i] != nums[correctIndex]) {
                int temp = nums[i];
                nums[i] = nums[correctIndex];
                nums[correctIndex] = temp;
            } else {
                i++;
            }
        }
    }
}
