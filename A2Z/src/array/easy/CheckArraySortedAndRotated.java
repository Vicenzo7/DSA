package array.easy;
//https://leetcode.com/problems/check-if-array-is-sorted-and-rotated/description/?orderBy=most_votes&languageTags=java
public class CheckArraySortedAndRotated {

    /*
        Intuition
        if array is sorted and rotated then, there is only 1 break point where (nums[x] > nums[x+1]),
        if array is only sorted then, there is 0 break point.

        Since the array might be rotated we also need to check for last and first element
        Why am I doing %size??
        Consider this case: nums = [2,1,3,4]

        This case will give you result true without %size, but it is not sorted and rotated. So we have to check last and first element also.

        Time Complexity  -> O(n)
        Space Complexity -> O(1)
     */

    public static void main(String[] args) {
//        int[]nums = {3,4,5,1,2,9};
        int[] nums = {3, 4, 5, 1, 2};
        System.out.println(check(nums));
    }


    public static boolean check(int[] nums) {
        int count = 0;
        int size = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % size]) {
                count += 1;
            }
        }

        return count <= 1;
    }
}
