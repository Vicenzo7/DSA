package CycleSortProblems;

//https://leetcode.com/problems/missing-number/
class MissingNumber {

    public static void main(String[] args) {
//        int[] nums = {9, 6, 4, 2, 3, 5, 7, 0, 1};
        int[] nums = {3, 0, 1};
        System.out.println(missingNumber(nums));
    }


    public static int missingNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int correct = nums[i];
            if (nums[i] < nums.length && nums[i] != nums[correct]) {
                int temp = nums[correct];
                nums[correct] = nums[i];
                nums[i] = temp;
            } else {
                i++;
            }
        }

        //search for missing number
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] != index)
                return index;
        }

        //case 2
        return nums.length;
    }
}