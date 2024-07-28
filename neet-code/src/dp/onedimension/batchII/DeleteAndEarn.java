package dp.onedimension.batchII;

import java.util.*;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 15, 16, 17, 18};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
//        return bruteForce(0, nums, new int[10000]);
        return moreOptimisedDp(nums);
    }


    private static int bruteForce(int index, int[] nums, int[] frequencyCount) {
        if (index >= nums.length) {
            return 0;
        }

        int points = nums[index];
        if (frequencyCount[points] > 0) {
            return bruteForce(index + 1, nums, frequencyCount);
        }

        frequencyCount[points - 1] += 1;
        frequencyCount[points + 1] += 1;
        int option1 = points + bruteForce(index + 1, nums, frequencyCount);

        frequencyCount[points - 1] -= 1;
        frequencyCount[points + 1] -= 1;
        int option2 = bruteForce(index + 1, nums, frequencyCount);

        return Math.max(option1, option2);
    }

    private static int moreOptimisedDp(int[] nums) {
        // count frequency of each element and sort them
        Map<Integer, Integer> frequencyMap = new TreeMap<>();

        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int earn1 = 0;
        int earn2 = 0; // previous Earn

        for (int num : frequencyMap.keySet()) {
            // current Element into total count
            int currEarn = num * frequencyMap.get(num);

            // we cannot use both currEarn and previousEarn which is earn2 because num-1
            // exist. example for 3 two exist
            if (frequencyMap.containsKey(num - 1)) {
                int temp = earn2;
                earn2 = Math.max(currEarn + earn1, earn2);
                earn1 = temp;
            } else {
                // we can use currEarn and previousEarn because num -1 does not exist
                int temp = earn2;
                earn2 = currEarn + earn2;
                earn1 = temp;
            }
        }

        return earn2;
    }
}
