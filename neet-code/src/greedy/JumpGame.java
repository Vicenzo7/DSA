package greedy;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2, 3, 1, 1, 4};
//        int[] nums = {3, 2, 1, 0, 4};
        System.out.println(canJump(nums));
        System.out.println(canJumpGoalMethod(nums));
    }


    public static boolean canJumpGoalMethod(int[] nums) {
        int goal = nums.length - 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            // we only shift our goal when we can jump from that index and reach the goal position
            int jump = i + nums[i];
            if (jump >= goal) {
                goal = i;
            }
        }

        return goal == 0;
    }

    public static boolean canJump(int[] nums) {
        int currentReachable = 0;
        for (int currentStanding = 0; currentStanding < nums.length; currentStanding++) {
            if (currentReachable < currentStanding) {
                return false;
            }

            currentReachable = Math.max(currentReachable, currentStanding + nums[currentStanding]);
        }
        return true;
    }
}
