package array.easy;
//https://leetcode.com/problems/max-consecutive-ones/
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        System.out.println(findMaxConsecutiveOnes(nums));
    }

    public static int findMaxConsecutiveOnes(int[] nums) {
        int max = Integer.MIN_VALUE;
        int count = 0;
        for (int i = 0; i < nums.length ; i++) {
            if (nums[i] == 0) {
                max = Math.max(max,count);
                count = 0;
            } else {
                count++;
            }
        }
        max = Math.max(max,count);
        return max;
    }
}
