package company.uniCard;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 1};
        System.out.println(rob(nums));
    }

    public static int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;

        // [rob1,rob2,n,n+1,...]
        for (int n : nums) {
            // the below statement means to rob n we need to rob1 too so its rob1 + n, or we
            // just rob2 and take max of these 2
            int temp = Math.max(rob1 + n, rob2);
            rob1 = rob2;
            rob2 = temp;
        }

        return rob2;
    }
}
