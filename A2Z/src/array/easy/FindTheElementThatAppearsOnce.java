package array.easy;

import java.util.HashMap;
import java.util.Map;

public class FindTheElementThatAppearsOnce {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 1, 2};
        System.out.println(singleNumber(nums));
        System.out.println(search(nums));
    }

    public static int singleNumber(int[] nums) {
        /*
         * TC -> O(n)
         * SC -> O(n)
         * We can reduce the space complexity if we use the property of XOR(^)
         *
         *  0^0 = 0
         *  0^1 = 1
         *  1^0 = 1
         *  1^1 = 0
         *  Since the array contains only one number which is single and rest all are twice
         *   so here the xor property says if two number are same then its result is zero
         *   so the numbers which are twice in the array their XOR will result to 0 and the only single
         *   number that remains its XOR with ) is the number itself
         * */

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if (frequencyMap.get(num) == 1) {
                return num;
            }
        }
        return 0;
    }

    public static int search(int[] nums) {
        /*
         * TC -> O(n)
         * SC -> O(n)
         * We can reduce the space complexity if we use the property of XOR(^)
         *
         *  0^0 = 0
         *  0^1 = 1
         *  1^0 = 1
         *  1^1 = 0
         *  Since the array contains only one number which is single and rest all are twice
         *   so here the xor property says if two number are same then its result is zero
         *   so the numbers which are twice in the array their XOR will result to 0 and the only single
         *   number that remains its XOR with ) is the number itself
         * */

        int result = 0;
        for (int num : nums) {
            result ^= num;
        }

        return result;
    }
}
