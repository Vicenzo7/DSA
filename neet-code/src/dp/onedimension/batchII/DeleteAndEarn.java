package dp.onedimension.batchII;

import java.util.*;

public class DeleteAndEarn {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 15, 16, 17, 18};
        System.out.println(deleteAndEarn(nums));
    }

    public static int deleteAndEarn(int[] nums) {
//        return bruteForce(0, nums, new int[10000]);
//        return optimisedDp(nums);
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


    /*
        Another approach is to sort the array and eliminate the duplicate
        and since we are eliminating the duplicate keep the track of occurrence
        of each element.

        eg [2 ,3,3,5,6,6]

        -> [2,3,5,7]
        {
            2:1
            3:2
            5:1
            6:2
        }

        Now it become a house robber problem
        if we take 2 we can't take the adjacent, if we take 3 we cant take 2 and 5(the adjacent)
        but we can take the 6
    */

    private static int optimisedDp(int[] nums) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            set.add(num);
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);
        int earn1 = 0;
        int earn2 = 0;

        for (int i = 0; i < list.size(); i++) {
            Integer num = list.get(i);
            int currEarn = num * frequencyMap.get(num);

            // check if num has proper adjacent. eg num = 5 proper adjacent is 4 and not 3
            if (i > 0 && num == list.get(i - 1) + 1) {
                int temp = earn2;
                earn2 = Math.max(currEarn + earn1, earn2);
                earn1 = temp;
            } else {
                int temp = earn2;
                earn2 = currEarn + earn2;
                earn1 = temp;
            }
        }

        return earn2;
    }

    private static int moreOptimisedDp(int[] nums) {
        Map<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        int earn1 = 0;
        int earn2 = 0;
        for (int num : frequencyMap.keySet()) {
            int currEarn = num * frequencyMap.get(num);
            // check if previous adjacent exist
            if (frequencyMap.containsKey(num - 1)) {
                int temp = earn2;
                // currEar + earn1 because previous adjacent exist example for 5 4 exist
                earn2 = Math.max(currEarn + earn1, earn2);
                earn1 = temp;
            } else {
                int temp = earn2;
                earn2 = currEarn + earn2;
                earn1 = temp;
            }
        }

        return earn2;
    }
}
