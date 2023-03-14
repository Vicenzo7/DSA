package basic.math;
//https://leetcode.com/problems/jump-game/description/
public class JumpGame {
    public static void main(String[] args) {
        /*
            Peak Valley Approach
            check from each index how far you can jump and update your reachability according
            if at some point your reachability is < than where you have reached that means you cannot reach at the end of the array;
         */

       int[] nums = {2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        int currentlyReachable = 0;
        for (int currentlyStanding = 0; currentlyStanding < nums.length; currentlyStanding++) {
            if (currentlyReachable < currentlyStanding) {
                return false;
            }
            currentlyReachable = Math.max(currentlyReachable,currentlyStanding + nums[currentlyStanding]);
        }

        return true;
    }
}
