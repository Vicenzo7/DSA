// problem description on Love Babbar Youtube video

package BinarySearch;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {8, 10, 17, 1, 3};
        int result = findIndex(nums);
        System.out.println("Pivot index is :" + result);

    }

    private static int findIndex(int[] nums) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;

        while (start < end) {
            int mid = start + (end - start) / 2;
            //first line
            if (nums[mid] >= nums[0]) {
                start = mid + 1;
            } else//second line
            {
                end = mid;
            }
        }
        return start;// we can return end also
    }
}
