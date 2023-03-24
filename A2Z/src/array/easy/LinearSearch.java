package array.easy;

public class LinearSearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        int target = 3;

        int ans = linearSearch(nums, target);
        if (ans == -1) {
            System.out.println("Target not present int the array");
        } else {
            System.out.println("Target found at index " + ans);
        }
    }

    private static int linearSearch(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                System.out.println(i);
            }
        }
        return -1;
    }
}
