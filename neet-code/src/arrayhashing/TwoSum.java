package arrayhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        // TC = O(n) SC = O(n)
        Map<Integer, Integer> previousMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (previousMap.containsKey(target - nums[i])) {
                return new int[]{i, previousMap.get(target - nums[i])};
            } else {
                previousMap.put(nums[i], i);
            }
        }

        return new int[]{-1, -1};
    }
}
