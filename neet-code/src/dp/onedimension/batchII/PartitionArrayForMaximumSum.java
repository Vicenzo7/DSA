package dp.onedimension.batchII;

public class PartitionArrayForMaximumSum {
    public static void main(String[] args) {
        int[] arr = {1, 15, 7, 9, 2, 5, 10};
        int k = 3;
        System.out.println(maxSumAfterPartitioning(arr, k));
    }

    public static int maxSumAfterPartitioning(int[] arr, int k) {
//        return dfs(0, arr, k, new Integer[arr.length]);
        return topDownApproach(arr, k);
    }


    // TC = O(n*k)
    // SC = O(n)

    private static int dfs(int i, int[] arr, int k, Integer[] cache) {
        if (i >= arr.length) {
            return 0;
        }

        if (cache[i] != null) {
            return cache[i];
        }

        int currMax = 0;
        int result = 0;
        // iterating over each window where subarray can be formed with i the element with length
        // at most k
        int minLength = Math.min(arr.length, i + k);
        for (int j = i; j < minLength; j++) {
            currMax = Math.max(currMax, arr[j]);
            int windowSize = j - i + 1;
            int partitionSum = currMax * windowSize + dfs(j + 1, arr, k, new Integer[arr.length]);
            result = Math.max(result, partitionSum);
        }
        return cache[i] = result;
    }


    private static int topDownApproach(int[] arr, int k) {
        // take dp of k length
        int[] dp = new int[k];
        dp[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int currMax = 0;
            int maxAtI = 0;
            for (int j = i; j > i - k; j--) {
                if (j < 0) {
                    break;
                }
                currMax = Math.max(currMax, arr[j]);
                int windowSize = i - j + 1;
                int curSum = currMax * windowSize;
                int subSum = 0;
                if (j > 0) {
                    subSum = dp[(j - 1) % k];
                } else {
                    subSum = dp[k - 1];
                }
                maxAtI = Math.max(maxAtI, subSum + curSum);
            }

            dp[i % k] = maxAtI;
        }

        return dp[(arr.length - 1) % k];
    }
}
