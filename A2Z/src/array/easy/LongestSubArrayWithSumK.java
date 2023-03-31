package array.easy;

import java.util.HashMap;
import java.util.Map;

public class LongestSubArrayWithSumK {
    public static void main(String[] args) {
        int[] nums = {5, 6, -5, 5, 3, 5, 3, -2, 0};
        int k = 8;
        System.out.println(lenOfLongSubarr(nums, k));
        System.out.println(lenOfLongSubArray(nums, k));
        System.out.println(lenOfSubArray(nums,k));

    }


    public static int lenOfLongSubarr(int[] nums, int k) {
        /*
         * TC -> O(n^2)
         * */

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j - i + 1);
                }
            }
        }
        return max;
    }

    /*  This method is called a sliding window technique. We can think of a window covering the subarray, and the ends slide towards right all the time.
        Here we have 2 nested loops. The outer loop slides the starting index of the window towards the right. The inner loop slides the ending index of the window towards the right.
        Here is the working. First we fix the starting index and increase the ending index which increases the window size. We do this until we get the sum greater than k, or we go out of bounds.
        If we get a greater sum, we come out of the inner loop. We check whether we have got the sum, if so, now we compare with the max length we found so far, and replace it with the greatest.
        Now, it’s time for us to shift the starting index, therefore we subtract the current starting element from the sum(meaning that we don’t include that number hereafter).
        And we increase the start index which in turn decreases the window size. Now we can go on increasing the ending index as we did earlier.

        Time Complexity: O(2n) ~ O(n), if we observe closely, the window only forwards to the right always. And every element is visited at most 2 times, one by the end variable and by the start variable.

        Space Complexity: O(1), we are not using any extra space.
    */

    // below function is only for positive integers
    public static int lenOfLongSubArray(int[] nums, int target) {
        int start = 0, end = -1, sum = 0, maxLength = 0;

        while (start < nums.length) {
            while ((end + 1 < nums.length) && nums[end + 1] <= target) {
                sum += nums[++end];
            }
            if (sum == target) {
                maxLength = Math.max(maxLength, end - start + 1);
            }

            sum -= nums[start];
            start++;
        }

        return maxLength;
    }

    // below function is for both positive and negative
    public static int lenOfSubArray(int[] nums, int k) {
        /*
        * Here we do reverse engineering
        * If we have a sum say x and we need to find a sub array which sums up to k
        * then in the map we check if we have sum-k because
        * we need to find subArray which sums to k,
        * but we have sum = x, so we do x-k = some y
        * it's same as x-y = k means there exist a k
        * */

        Map<Integer,Integer> prefixSum = new HashMap<>();
        int sum = 0;
        int length = 0;
        int endingIndex = -1;
        prefixSum.put(0,-1);
        for (int i = 0; i < nums.length ; i++) {
            sum += nums[i];
            prefixSum.putIfAbsent(sum,i);

            if(prefixSum.containsKey(sum-k) && length < i-prefixSum.get(sum-k)) {
                length = i - prefixSum.get(sum-k);
                endingIndex=i;
            }
        }

        System.out.println("Largest SubArray with sum = k is ["+(endingIndex-length+1)+","+endingIndex+"]" );
        return length;
    }
}
