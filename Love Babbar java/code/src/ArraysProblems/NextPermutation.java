package ArraysProblems;

public class NextPermutation {
    public static void main(String[] args) {
        int[] nums = {3,1,4,2};
        int[] result = nextPermutation(nums);
        for (int i : result) {
            System.out.print(i + " ");
        }
    }

    public static int[] nextPermutation(int[] nums) {
        int n = nums.length;

        //null checks
        if (nums.length == 0 || nums == null)
            return new int[0];

        //finding k 3 1 4 2 ;;;;; if duplicates 3 1 4 4 2
        int k = n - 2;
        for (int i = n - 1; i > 0; i--) {
            //<= if duplicates present
            if (nums[i] <= nums[i - 1]) {
                k--;
            } else {
                break;
            }
        }

        //if k==-1 than reverse
        if (k == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        //else replace k with greater element and reverse
        for (int i = n - 1; i > 0; i--) {
            if (nums[i] > nums[k]) {
                int temp = nums[k];
                nums[k] = nums[i];
                nums[i] = temp;

                // only one swap so break
                break;
            }
        }
        reverse(nums, k + 1, n - 1);
        return nums;

    }

    static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

}
