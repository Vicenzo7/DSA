package Medium;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums={2,3,1,1,4};
        System.out.println(canJump(nums));
    }

    private static boolean canJump(int[] nums) {
        int n= nums.length;
        //reachable is the max reach we can go up to
        int reachable=0;
        for (int i = 0; i <n ; i++) {
            if(reachable<i)// checking if our pointer crosses the reachable
            {
                return false;
            }
            reachable=Math.max(reachable,i+nums[i]);
        }
        return true;
    }

}
