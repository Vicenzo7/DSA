package array.easy;

public class LargestAndSmallestInArray {
    public static void main(String[] args) {
        int[] nums = {4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0};
        System.out.println(largest(nums));
        System.out.println(smallest(nums));
    }

    public static int largest(int[] nums) {
        int max = Integer.MIN_VALUE;

        for (int num : nums) {
            max = Math.max(max, num);
        }

        return max;
    }

    public static int smallest(int[] nums) {
        int min = Integer.MAX_VALUE;

        for (int num : nums) {
            min = Math.min(min, num);
        }

        return min;
    }
}
