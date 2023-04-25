package array.medium;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/subarray-sum-equals-k/description/
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] array = {1, 2, 1, 2};
        int k = 3;
        System.out.println(subarraySum(array, k));
        System.out.println(subarraySumOptimal(array, k));
    }

    /*
     * Brute force
     * Keep finding subArrays and at the same time check if the sum meets the given target
     * If the sum meets the given target ,increment the count.
     *
     * TC = O(n^2)
     * */

    public static int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }

/*    Optimal Approach

    This approach is similar to the problem "Longest Subarray which sum up to k"
    Here also we use reverse engineering technique

    We take a map to store <prefix sum,count>, the count is how many times the prefix sum appear
    and initially store (0,1) in it

    1 -> We traverse the array and accumulate the sum,
    2 -> We check in the map if sum-k exist.If yes increment the count
    3 -> we then put that sum in the map along with the count.


    TC = O(nlog(n)); -> to insert value in the map it takes O(log(n)) and we are putting n elements
    SC = 0(n)*/


    public static int subarraySumOptimal(int[] nums, int k) {
        int count = 0;
        Map<Integer, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0, 1);
        int sum = 0;
        for (int num : nums) {
            sum += num;

            count += prefixSumCountMap.getOrDefault(sum - k, 0);

            prefixSumCountMap.put(sum, prefixSumCountMap.getOrDefault(sum, 0) + 1);
        }
        return count;

    }


}
