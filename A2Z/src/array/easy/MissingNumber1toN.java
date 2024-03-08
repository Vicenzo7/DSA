package array.easy;

public class MissingNumber1toN {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));
    }

    public static int missingNumber(int[] nums) {
        // Your code goes her
//        Arrays.sort(nums);
        // Instead of normal sort which takes O(n^2), perform cyclic sort
        // Cycle sort -> TC = O(n)
        int index = 0;
        while (index < nums.length) {
            int correctIndex = nums[index];
            if(nums[index] < nums.length && nums[index] != nums[correctIndex]) {
                int temp = nums[index];
                nums[index] = nums[correctIndex];
                nums[correctIndex]= temp;
            } else {
                index++;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) {
                return i;
            }
        }

        return nums.length;
    }
}
