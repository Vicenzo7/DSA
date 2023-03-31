package array.medium;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {3, 3, 2, 1, 1, 1, 2, 2, 3, 3, 3, 3, 3};
        System.out.println(majorityElement(nums));
    }

    /*Time Complexity: O(N*logN) + O(N), where N = size of the given array.
            Reason: We are using a map data structure. Insertion in the map takes logN time. And we are doing it for N elements. So, it results in the first term O(N*logN). The second O(N) is for checking which element occurs more than floor(N/2) times.
    If we use unordered_map instead, the first term will be O(N) for the best and average case and for the worst case, it will be O(N2).

    Space Complexity: O(N) as we are using a map data structure.*/
    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> frequencyCount = new HashMap<>();
        for (int num : nums) {
            frequencyCount.put(num, frequencyCount.getOrDefault(num, 0) + 1);
        }
        for (int num : nums) {
            if (frequencyCount.get(num) > nums.length / 2) {
                return num;
            }
        }
        return 0;
    }
}
