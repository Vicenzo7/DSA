package dp.onedimension.batchII;

import util.CustomPair;

import java.util.Arrays;
import java.util.Stack;

public class MaximumSubarrayMinProduct {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 2};
//        int[] nums = {3, 2, 5};
//        int[] nums = {2, 3, 3, 1, 2};
        System.out.println(maxSumMinProduct(nums));
        System.out.println(maxSumMinProduct2(nums));
    }

    /*
         This problem can be solved in O(n^2) but can also be solved using O(n)
         using monotonic stack

         Approach:
         Consider if each value was the minimum value of the subarray

         Similar to Largest rectangle in Histogram but need to compute prefix sum, so we can
         get sum of any arbitrary sub-array in O(1)

    */

    public static int maxSumMinProduct(int[] nums) {
        //stores start and the minimum
        long minimumProduct = 0;
        Stack<CustomPair<Integer, Long>> stack = new Stack<>();

        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        for (int i = 0; i < nums.length; i++) {
            int start = i;
            long currentValue = nums[i];
            while (!stack.isEmpty() && stack.peek().getValue() > currentValue) {
                CustomPair<Integer, Long> pop = stack.pop();
                long minimum = pop.getValue();
                int startIndex = pop.getKey();
                long subArraySum = prefixSum[i] - prefixSum[startIndex];
                minimumProduct = Math.max(minimum * subArraySum, minimumProduct);
                start = startIndex;
            }
            stack.push(new CustomPair<>(start, currentValue));
        }

        while (!stack.isEmpty()) {
            CustomPair<Integer, Long> pop = stack.pop();
            long minimum = pop.getValue();
            int startIndex = pop.getKey();
            long subArraySum = prefixSum[nums.length] - prefixSum[startIndex];
            minimumProduct = Math.max(minimum * subArraySum, minimumProduct);
        }

        return (int) (minimumProduct % 1000000007);
    }


    public static int maxSumMinProduct2(int[] nums) {
        long[] prefixSum = new long[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        // stores start index where the element is a minValue and element
        Stack<long[]> stack = new Stack();
        long minimumProduct = 0L;
        long mod = (int) 1e9 + 7;
        for (int i = 0; i < nums.length; i++) {
            int start = i;
            int currentValue = nums[i];
            while (!stack.isEmpty() && stack.peek()[1] > currentValue) {
                long[] stackTop = stack.pop();
                int startIndex = (int)stackTop[0];
                long minValue = stackTop[1];
                long subArraySum = prefixSum[i] - prefixSum[startIndex];
                minimumProduct = Math.max(minValue * subArraySum, minimumProduct);
                start = startIndex;
            }
            stack.push(new long[] { start, currentValue });
        }

        while (!stack.isEmpty()) {
            long[] stackTop = stack.pop();
            int startIndex = (int)stackTop[0];
            long minValue = stackTop[1];
            long subArraySum = prefixSum[nums.length] - prefixSum[startIndex];
            minimumProduct = Math.max((long) minValue * subArraySum, minimumProduct);
        }

        return (int) ((minimumProduct + mod) % mod);
    }

    public int maxSumMinProductNeetCode(int[] nums) {
        Stack<long[]> stack = new Stack<>(); // index, value
        long[] pre = new long[nums.length];
        pre[0] = nums[0];
        long res = 0, mod = (int) 1e9 + 7;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int idx = i;
            while (stack.size() != 0 && nums[i] < stack.peek()[1]) {
                long[] t = stack.pop();
                int start = (int) t[0];
                long value = t[1];
                long sum = pre[i - 1] - ((start - 1) < 0 ? 0 : pre[start - 1]);
                res = Math.max(res, (value * sum));
                idx = start;
            }
            stack.push(new long[] { idx, nums[i] });
        }
        while (stack.size() != 0) {
            long[] t = stack.pop();
            int start = (int) t[0];
            long value = t[1];
            long sum = pre[nums.length - 1] - ((start - 1) < 0 ? 0 : pre[start - 1]);
            res = Math.max(res, (value * sum));
        }
        return (int) ((res + mod) % mod);
    }

    public static int solve(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int min = Arrays.stream(nums, i, j + 1).min().orElse(0);
                int sum = min * Arrays.stream(nums, i, j + 1).sum();
                max = Math.max(max, sum);
            }
        }

        return max;
    }
}
