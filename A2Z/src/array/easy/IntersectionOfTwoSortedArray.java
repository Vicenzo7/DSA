package array.easy;

import java.util.ArrayList;
import java.util.List;

public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 3, 4, 5, 6};
        int[] nums2 = {3, 5};

//        List<Integer> intersection = intersection(nums1, nums2);
        List<Integer> intersection = intersectionOptimal(nums1, nums2);
        System.out.println(intersection);
    }


    private static List<Integer> intersectionOptimal(int[] num1, int[] num2) {
        // tc O(Math.min(num1.length,num2.length))
        List<Integer> list = new ArrayList<>();
        int i = 0, j = 0;
        while (i < num1.length && j < num2.length) {
            if (num1[i] < num2[j]) {
                i++;
            } else if (num1[i] > num2[j]) {
                j++;
            } else {
                list.add(num1[i]);
                i++;
                j++;
            }
        }
        return list;
    }


    private static List<Integer> intersection(int[] nums1, int[] nums2) {
        List<Integer> ans = new ArrayList<>();
        boolean[] visitedArray = new boolean[nums2.length];
        for (int num : nums1) {
            boolean result = linearSearch(nums2, visitedArray, num);
            if (result) {
                ans.add(num);
            }
        }
        return ans;
    }

    private static boolean linearSearch(int[] nums2, boolean[] visitedArray, int target) {

        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] == target && !visitedArray[i]) {
                visitedArray[i] = true;
                return true;
            } else if (nums2[i] > target) {
                // since the array is sorted there is no point in search beyond if nums[i] > target
                break;
            }
        }
        return false;
    }


}
