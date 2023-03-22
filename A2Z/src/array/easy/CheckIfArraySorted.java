package array.easy;

public class CheckIfArraySorted {
    public static void main(String[] args) {
//        int[] nums = {1, 4, 7, 1, 3, 19, 3, 99, 45, 67, 87, 2, 0, 87};
        int[] nums = {3,4,5,1,2};
        System.out.println(isSorted(nums));
    }

    private static boolean isSorted(int[] nums) {
        if (nums.length == 1) return true;

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] > nums[i+1] ) {
                return false;
            }
        }

        return true;
    }
}
