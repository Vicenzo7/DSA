package greedy;

public class JumpGameII {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(jump(nums));
    }

    public static int jump(int[] nums) {
        int left = 0;
        int right = 0;
        int minimumJump = 0;

        while (right < nums.length - 1) {
            int farthest = 0;
            // finding the farthest in the range
            for (int i = left; i < right + 1; i++) {
                farthest = Math.max(farthest, i + nums[i]);
            }
            // after finding the farthest, reassigning the range and we take a jump
            left = right + 1;
            right = farthest;
            minimumJump++;
        }

        return minimumJump;
    }
}
