package array.medium;
//https://leetcode.com/problems/next-permutation/
import java.util.Arrays;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2};
        nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    /*
     * Brute Force approach find all the permutation and store them
     * Next find the given array in the permutation generated
     * And return the next permutation to it
     *
     *
     *
     *
     * Optimal Approach -> TC = O(N)
     * Algorithm
     * Step 1 - Traverse the array for the backward and find the element such that arr[i] < arr[i+1] and store its index
     * Step 2 - Again traverse from behind and find the first element which is greater than the element at arr[i]
     * Step 3 - Swap the element found at step 1 and step 2
     * Step 4 - Now reverse the array from the index found in step 1.(excluding the index)
     *
     * If No break point found just reverse the array and that's the answer
     *
     * Intuition
     * eg 1 3 5 4 2
     *        5
     *      3   4
     *    1        2
     *
     * If we see from the right it'll be increasing from the back for a certain moment
     *
     * For 1 2 3
     *
     *   2
     * 1   3
     * Here only 3 is increasing , also 1 element is in the increasing order
     * next 1 3 2
     *   3
     * 1  2
     * Again increasing order
     *
     * Now for 1 3 5 4 2 we need the prefix to be greater here the prefix is 1 3
     * Prefix is 1 3 because 3 is the element which satisfies arr[i] < arr[i+1] from backwards
     *
     * If we take a prefix 1 2 then 1 2 5 4 2 < 1 3 5 4 2 , but we want the next permutation and not the before
     * So we can take 1 5 or 1 4 but taking 1 4 is better because we want the next permutation and 4 is closer to 3
     * This is the intuition behind the second step to find the first greater element to the one found in find step,
     * and we find it through back because we know the sequence from the back will be increasing
     *
     * Step 3 says swap we need to do this to make the prefix greater.
     * Now for the fourth step we reverse It's because
     * We found a greater prefix, and to get the next permutation we will make the next elements as lesser in rank
     *  as possible.
     * So to make this 1 4 5 3 2 -> from 5 3 2 we know it increasing from behind and to make it smaller just reverse it,
     * so it's in increasing order from the front ie 2 3 5
     *
     * Final answer 1 4 2 3 5
     *
     * Edge case What is there is no break point ie array is 5 4 3 2 1
     * In this case we have reached the last permutation and the next permutation is the first permutation so just
     * reverse the array that will be the answer 1 2 3 4 5
     *
     *
     * */

    public static void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = nums.length - 1;
            while (nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1, nums.length - 1);
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
