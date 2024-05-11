package dp.pattern.dual_sequence;

import java.util.Map;

public class UncrossedLines {
    public static void main(String[] args) {
        int[] nums1 = {2, 5, 1, 2, 5};
        int[] nums2 = {10, 5, 2, 1, 5, 2};
        System.out.println(maxUncrossedLines(nums1, nums2));
    }

    // this problem is same as Longest common subsequence
    public static int maxUncrossedLines(int[] nums1, int[] nums2) {
        // return bruteForce(0, 0, nums1, nums2);
        // return memoization(0, 0, nums1, nums2, new HashMap<>());
        // return dp(nums1, nums2);
        if (nums1.length > nums2.length) {
            return dpOptimized(nums1, nums2);
        } else {
            return dpOptimized(nums2, nums1);
        }
    }

    // TC = O(2^(m.n)) SC= (m+n)
    public static int bruteForce(int i, int j, int[] nums1, int[] nums2) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        int ans;
        if (nums1[i] == nums2[j]) {
            ans = 1 + bruteForce(i + 1, j + 1, nums1, nums2);
        } else {
            ans = Math.max(bruteForce(i, j + 1, nums1, nums2), bruteForce(i + 1, j, nums1, nums2));
        }

        return ans;
    }

    // TC = O(m.n) SC= (m+n)
    public static int memoization(int i, int j, int[] nums1, int[] nums2, Map<String, Integer> cache) {
        if (i == nums1.length || j == nums2.length) {
            return 0;
        }

        if (cache.containsKey(i + ":" + j)) {
            return cache.get(i + ":" + j);
        }

        int ans;
        if (nums1[i] == nums2[j]) {
            ans = 1 + memoization(i + 1, j + 1, nums1, nums2, cache);
        } else {
            ans = Math.max(memoization(i, j + 1, nums1, nums2, cache), memoization(i + 1, j, nums1, nums2, cache));
        }

        cache.put(i + ":" + j, ans);

        return ans;
    }

    // TC = O((m.n)) SC= (m+n)
    public static int dp(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    dp[i + 1][j + 1] = 1 + dp[i][j];
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }

        return dp[m][n];
    }

    // TC = O(m.n) SC= (m) -> m is the length smallest array
    public static int dpOptimized(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] dp = new int[n + 1];

        for (int i = 0; i < m; i++) {
            int[] currRow = new int[n + 1];
            for (int j = 0; j < n; j++) {
                if (nums1[i] == nums2[j]) {
                    currRow[j + 1] = 1 + dp[j];
                } else {
                    currRow[j + 1] = Math.max(dp[j + 1], currRow[j]);
                }
            }
            dp = currRow;
        }

        return dp[n];
    }
}
