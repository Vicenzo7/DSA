package array.easy;
//https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromSortedArray {
    // Do it without using HashMap and HashSet
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3, 3, 3};
        int distinctElement = removeDuplicates(nums);
        System.out.println(distinctElement);
        System.out.println(Arrays.toString(nums));

//        System.out.println(removeDuplicate(nums));
//        System.out.println(Arrays.toString(nums));
    }
   /* Two pointers

    Intuition: We can think of using two pointers ‘i’ and ‘j’, we move ‘j’ till we don’t get a number arr[j] which is different from arr[i]. As we got a unique number we will increase the i pointer and update its value by arr[j].

    Approach:

    Take a variable i as 0;
    Use a for loop by using a variable ‘j’ from 1 to length of the array.
    If arr[j] != arr[i], increase ‘i’ and update arr[i] == arr[j].
    After completion of the loop return i+1, i.e size of the array of unique elements.*/

    public static int removeDuplicates(int[] nums) {
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                nums[++i] = nums[j];
            }
        }
        return i + 1;
    }

    // using hash set
    public static int removeDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        int i = 0;
        for (int num : set) {
            nums[i++] = num;
        }

        return i;
    }


}
