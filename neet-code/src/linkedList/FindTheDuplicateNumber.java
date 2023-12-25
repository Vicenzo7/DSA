package linkedList;

public class FindTheDuplicateNumber {

    /*
        Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.

        There is only one repeated number in nums, return this repeated number.

        You must solve the problem without modifying the array nums and uses only constant extra space.
    */
    public static void main(String[] args) {
        // can do this problem is many ways
        /*
            1. Brute force
            2. HashSet
            3. Index Sort -> [1,n]
            4. Fast and Slow pointer
        */

        int[] nums = {1, 3, 4, 2, 2};
        System.out.println(findDuplicate_IndexSort(nums));
        System.out.println(findDuplicate_FastAndSlowPointer(nums));
    }

    public static int findDuplicate_IndexSort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) { // means nums[i] = 1 and i+1 = 1, checking if its at correct index, if yes increment i,else put element at right position
                int correctIndex = nums[i] - 1;
                if (nums[i] != nums[correctIndex]) { // if current number is not present at its desired index,put the element at desired index
                    int temp = nums[i];
                    nums[i] = nums[correctIndex];
                    nums[correctIndex] = temp;
                } else { // means the at correctIndex there is already nums[i], and there is another same value at i, so it's the duplicate
                    return nums[i];
                }
            } else {
                i++;
            }
        }
        return -1;
    }

    public static int findDuplicate_FastAndSlowPointer(int[] nums) {
        int fast = 0;
        int slow = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];

        } while (slow != fast);

        int slow2 = 0;
        while (slow2 != slow) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }

        return slow;
    }
}
