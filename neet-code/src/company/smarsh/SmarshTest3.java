package company.smarsh;

import java.util.*;

public class SmarshTest3 {

    public static void main(String[] args) {
        /*
            Check if a pair with given sum exists in Array
            1 2 8 6 4 12
            10
            8 2
            6 4

Set<> [1,2,
        */

        int[] nums = {1, 2, 8, 6, 4, 12};
        int total = 10;
        List<int[]> pairs = findThePairs(nums, total);
        for (int[] pair : pairs) {
            System.out.println(pair[0] + " " + pair[1]);
        }

    }

    private static List<int[]> findThePairsSet(int[] nums, int total) {
        List<int[]> pairs = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(total - num)) {
                pairs.add(new int[]{num, total - num});
            }
            set.add(num);
        }

        return pairs;
    }


    private static List<int[]> findThePairs(int[] nums, int total) {
        Arrays.sort(nums);
        List<int[]> pairs = new ArrayList<>();
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int sum = nums[left] + nums[right];
            if (sum == total) {
                pairs.add(new int[]{nums[left], nums[right]});
                left++;
                right--;
            } else if (sum < total) {
                left++;
            } else {
                right--;
            }
        }
        return pairs;
    }


}
