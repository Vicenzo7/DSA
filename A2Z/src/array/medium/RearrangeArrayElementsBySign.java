package array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {3, 1, -2, -5, 2, -4};
        System.out.println(Arrays.toString(rearrangeArray(nums)));
        System.out.println(Arrays.toString(rearrangeArrayOptimal(nums)));
        int[] nums2 = {9, 4, -2, -1, 5, 0, -5, -3, 2};
        System.out.println(Arrays.toString(rearrangeArrayVariation(nums2)));
    }

    public static int[] rearrangeArray(int[] nums) {
        /*
         * TC -> O(n)
         * SC -> O(n)
         * */

        int[] positiveArray = new int[nums.length / 2];
        int[] negativeArray = new int[nums.length / 2];
        int i = 0, j = 0;
        for (int num : nums) {
            if (num >= 0) {
                positiveArray[i++] = num;
            } else {
                negativeArray[j++] = num;
            }
        }
        i = 0;
        j = 0;
        for (int k = 0; k < nums.length; k++) {
            if ((k & 1) == 1) {
                nums[k] = negativeArray[j++];
            } else {
                nums[k] = positiveArray[i++];
            }
        }

        return nums;
    }

    public static int[] rearrangeArrayOptimal(int[] nums) {
        /*
         * TC -> O(n)
         * SC -> O(n)
         * Both TC and SC are same but here segregation is done in one pass
         * */

        int[] result = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;

        for (int num : nums) {
            if (num >= 0) {
                result[positiveIndex] = num;
                positiveIndex += 2;
            } else {
                result[negativeIndex] = num;
                negativeIndex += 2;
            }
        }
        return result;
    }

    /*
     *
     * Assume Here the nums array may be even or odd
     * Meaning there might be equal negative and positive number or there might be not
     * If they aren't equal, the elements which are left after getting arranged should be put at last
     *
     * */

    public static int[] rearrangeArrayVariation(int[] nums) {
        List<Integer> positiveList = new ArrayList<>();
        List<Integer> negativeList = new ArrayList<>();

        int i = 0, j = 0, k = 0;
        for (int num : nums) {
            if (num >= 0) {
                positiveList.add(num);
            } else {
                negativeList.add(num);
            }
        }

        while (i < positiveList.size() && j < negativeList.size()) {
            if ((k & 1) == 0) {
                nums[k++] = positiveList.get(i++);
            } else {
                nums[k++] = negativeList.get(j++);
            }
        }

        while (i < positiveList.size()) {
            nums[k++] = positiveList.get(i++);

        }

        while (j < negativeList.size()) {
            nums[k++] = negativeList.get(j++);
        }

        return nums;
    }
}
