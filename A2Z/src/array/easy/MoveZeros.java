package array.easy;
//https://leetcode.com/problems/move-zeroes/description/
import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
//        moveZeroes(nums);
        moveZeroesOptimal(nums);
    }

    public static void moveZeroes(int[] nums) {
        int[] temp = new int[nums.length];
        int i = 0;
        for (int num : nums) {
            if (num != 0) {
                temp[i++] = num;
            }
        }
        i = 0;
        for (int num : temp) {
            nums[i++] = num;
        }
        System.out.println(Arrays.toString(temp));
    }


    // optimal solution
    /*
    Algorithm:
        Start traversing from the first occurrence index of Zero
        Tak 2 variables (i,j), i will be at the first occurrence of zero and j is at i+1
         If element at j index is not zero then swap elements at i,j and increment i,j
        If the element at j index is zero then only increment j.
        TC -> O(n)
        SC -> o(1)
    * */

    public static void moveZeroesOptimal(int[] nums) {
        // finding first occurrence of zero
        int i = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                break;
            }
            i++;
        }
        int j = i + 1;
        while (i < nums.length && j < nums.length) {
            if (nums[j] != 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
            }
            j++;

        }

        System.out.println(Arrays.toString(nums));
    }
}
