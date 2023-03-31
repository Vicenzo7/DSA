package array.medium;
//https://leetcode.com/problems/two-sum/description/
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
//        int target = 15;

        System.out.println(Arrays.toString(twoSum(nums, target)));
        System.out.println(Arrays.toString(twoSumOptimal(nums, target)));
        System.out.println(twoSumOptimal2(nums, target));
    }

    /*
     * Below function has TC -> O(n^2)
     * We can improve the time complexity by using HashMap*/
    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[]{-1, -1};
    }

    /*
     * Here using hashmap we get
     * TC -> O(n)
     * SC -> O(n) due to using HashMap
     * Approach is reverse Engineering
     * While iterating we will check if target-x exist in the map if it exists that means we have a pair
     * because the logic is like this
     * target = 6
     * our x = 2
     * and if the map has 4 in it
     * than target -x = 6-2 = 4 so (2,4) form a pair, but we need their indices to be returned
     * */
    public static int[] twoSumOptimal(int[] nums, int target) {
        Map<Integer, Integer> elementIndexMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (elementIndexMap.containsKey(target - nums[i])) {
                return new int[]{elementIndexMap.get(target - nums[i]), i};
            }
            elementIndexMap.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }

    /*
    * We can optimise it even further using two pointer
    * First sort the array and take two pointers start at the start on index and end at last index
    * now check if nums[start] + nums[end] == target if equal the return {start,end}
    * if nums[start] +nums[end] < target then increment the start pointer
    * if nums[start] + nums[end] > target the decrement the end pointer
    * TC -> o(n) + o(nlog(n))  o(n) for traversal and o(nlog(n)) for sorting */
    public static boolean twoSumOptimal2(int[] nums, int target) {
        Arrays.sort(nums);
        int start = 0, end = nums.length-1;
        while(start< end) {
            if(nums[start] + nums[end] == target) {
                return true;
            } else if (nums[start] + nums[end] < target) {
                start++;
            } else if (nums[start] + nums[end] > target){
                end--;
            }
        }

        return false;
    }
}
