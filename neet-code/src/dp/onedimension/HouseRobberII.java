package dp.onedimension;

public class HouseRobberII {
    public static void main(String[] args) {
//        int[] nums = {1, 2, 3, 1};
//        int[] nums = {2, 3, 2};
        int[] nums = {1, 2, 3};
        System.out.println(rob(nums));
    }

    // recurrence relation -> maxRob1 = max(arr[0] + rob[2:n-1], rob[1:n-1]
    // recurrence relation -> maxRob2 = max(arr[1] + rob[3:n], rob[2:n]

    // TC = O(n)
    public static int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return nums[0];
        }
        /*
            We have two choice either rob first house and skip the last or,
            skip the first house and rob the last.
        */

        // Rob the first house and skip the last house
        int maxRob1 = simpleHouseRob(nums, 0, n - 2);

        // Skip the first house and rob the last house
        int maxRob2 = simpleHouseRob(nums, 1, n - 1);

        return Math.max(maxRob1, maxRob2);
    }

    public static int simpleHouseRob(int[] nums, int start, int end) {
        int rob1 = 0;// Maximum amount robbed with considering the current house
        int rob2 = 0; // Maximum amount robbed without considering the current house

        for (int i = start; i <= end; i++) {
            int moneyInHouse = nums[i];
            int maxCash = Math.max(moneyInHouse + rob1, rob2);
            rob1 = rob2;
            rob2 = maxCash;
        }

        return rob2;
    }
}
