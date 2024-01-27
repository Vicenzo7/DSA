package greedy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DivideArrayInSetOfKConsecutiveNumbers {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 4, 4, 5, 6};
        int k = 4;

        System.out.println(isPossibleDivide(nums, k));
    }

    public static boolean isPossibleDivide(int[] nums, int k) {
        if (nums.length % k != 0) {
            return false;
        }

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        Arrays.sort(nums);
        for (int num : nums) {
            if (frequencyMap.get(num) <= 0) {
                continue;
            }
            for (int i = 1; i < k; i++) {
                int count = frequencyMap.getOrDefault(num + i, 0);
                if (count <= 0) {
                    return false;
                }
                frequencyMap.put(num + i, count - 1);
            }
            frequencyMap.put(num, frequencyMap.get(num) - 1);
        }

        return true;
    }
}
