package twopointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        // TC = O(n.log(n)) + O(n^2)
        // TC = O(n^2)
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            // skipping duplicates
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int start = i + 1, end = nums.length - 1;
            while (start < end) {
                int sum = nums[i] + nums[start] + nums[end];
                if (sum == 0) {
                    result.add(List.of(nums[i], nums[start], nums[end]));
                    end--;
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                } else if (sum < 0) {
                    start++;
                } else {
                    end--;
                }

            }
        }

        return result;


    }

//    public static List<List<Integer>> threeSum(int[] nums) {
//        Set<List<Integer>> result = new HashSet<>();
//        for (int i = 0; i < nums.length - 2; i++) {
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if (nums[i] + nums[j] + nums[k] == 0) {
//                        List<Integer> list = new ArrayList<>();
//                        list.add(nums[i]);
//                        list.add(nums[j]);
//                        list.add(nums[k]);
//                        Collections.sort(list);
//                        result.add(list);
//                    }
//                }
//            }
//
//        }
//
//        return new ArrayList<>(result);
//    }
}
