package array.medium;

import java.util.Arrays;

public class SortAnArrayOf0s1sAnd2s {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};
//        sortColors(nums);
        sortColorsOptimal(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
     * TC -> O(n)
     * */
    public static void sortColors(int[] nums) {
        int zeroCount = 0;
        int onesCount = 0;
        int twosCount = 0;
        for (int num : nums) {
            if (num == 0)
                zeroCount++;
            else if (num == 1)
                onesCount++;
            else
                twosCount++;
        }
        System.out.println(zeroCount + "-" + onesCount + "-" + twosCount);
        int index = 0;
        for (int i = 0; i < zeroCount; i++) {
            nums[i] = 0;
        }
        for (int i = zeroCount; i < zeroCount + onesCount; i++) {
            nums[i] = 1;
        }
        for (int i = zeroCount + onesCount; i < nums.length; i++) {
            nums[i] = 2;
        }
    }

    /*
    * Optimal Approach
    * Algo Name-> Dutch National Flag Algorithm
    * Approach:
    * This algorithm contains 3 pointers i.e. low, mid, and high, and 3 main rules.  The rules are the following:
           arr[0….low-1] contains 0. [Extreme left part]
           arr[low….mid-1] contains 1.
           arr[high+1….n-1] contains 2. [Extreme right part], n = size of the array

    Note: Here in this tutorial we will work based on the value of the mid-pointer.

    The steps will be the following:

    First, we will run a loop that will continue until mid <= high.
    There can be three different values of mid-pointer i.e. arr[mid]
    If arr[mid] == 0, we will swap arr[low] and arr[mid] and will increment both low and mid. Now the subArray from index 0 to (low-1) only contains 0.
    If arr[mid] == 1, we will just increment the mid-pointer and then the index (mid-1) will point to 1 as it should according to the rules.
    If arr[mid] == 2, we will swap arr[mid] and arr[high] and will decrement high. Now the subArray from index high+1 to (n-1) only contains 2.
    In this step, we will do nothing to the mid-pointer as even after swapping, the subArray from mid to high(after decrementing high) might be unsorted. So, we will check the value of mid again in the next iteration.
    Finally, our array should be sorted.*/

    public static void sortColorsOptimal(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while (mid <= high) {
            if (nums[mid] == 0) {
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                low++;
                mid++;
            } else if (nums[mid] == 1) {
                mid++;
            } else {
                int temp = nums[high];
                nums[high] = nums[mid];
                nums[mid] = temp;
                high--;
            }
        }
    }


}
