package dp.onedimension.batchII;

import java.util.Arrays;
import java.util.Comparator;

public class MaximumProfitInJobScheduling {
    public static void main(String[] args) {
//        int[] startTime = {1, 2, 3, 4, 6}, endTime = {3, 5, 10, 6, 9}, profit = {20, 20, 100, 70, 60};
//        int[] startTime = {1, 2, 3, 3}, endTime = {3, 4, 5, 6}, profit = {50, 10, 40, 70};
        int[] startTime = {1, 1, 1}, endTime = {2, 3, 4}, profit = {5, 6, 4};
        System.out.println(jobScheduling(startTime, endTime, profit));
    }

    static
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int[][] jobs = new int[startTime.length][3];
        for (int i = 0; i < startTime.length; i++) {
            jobs[i][0] = startTime[i];
            jobs[i][1] = endTime[i];
            jobs[i][2] = profit[i];
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a[0]));
//        Integer[][] dp = new Integer[jobs.length + 1][jobs.length + 1];
//        return dfs(0, -1, jobs, dp);


        Integer[] dp2 = new Integer[jobs.length + 1];
//        return dfs2(0, jobs, dp2);
        return dfs3(0, jobs, dp2);
    }

    // below code won't work on leetcode give memory limit exceeds, but logic is correct

    static
    public int dfs(int index, int prevIndex, int[][] jobs, Integer[][] dp) {
        if (index >= jobs.length) {
            return 0;
        }

        if (dp[index][prevIndex + 1] != null) {
            return dp[index][prevIndex + 1];
        }


        int include = 0;
        if (prevIndex == -1 || jobs[prevIndex][1] <= jobs[index][0]) {
            include = jobs[index][2] + dfs(index + 1, index, jobs, dp);
        }

        int exclude = dfs(index + 1, prevIndex, jobs, dp);

        return dp[index][prevIndex + 1] = Math.max(include, exclude);
    }

    // below solution will work but can be optimised using binary search

    static
    public int dfs2(int index, int[][] jobs, Integer[] dp) {
        if (index >= jobs.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        int nonOverLappingIndex = index + 1;
        // finding the next index, which will not overlap current index if we are using the currentIndex
        while (nonOverLappingIndex < jobs.length) {
            if (jobs[index][1] <= jobs[nonOverLappingIndex][0]) {
                break;
            }
            nonOverLappingIndex++;
        }

        int include = jobs[index][2] + dfs2(nonOverLappingIndex, jobs, dp);
        int exclude = dfs2(index + 1, jobs, dp);

        return dp[index] = Math.max(include, exclude);
    }

    static
    public int dfs3(int index, int[][] jobs, Integer[] dp) {
        if (index <  0 || index >= jobs.length) {
            return 0;
        }

        if (dp[index] != null) {
            return dp[index];
        }

        // finding the next index, which will not overlap current index if we are using the currentIndex
        int nonOverLappingIndex = binarySearch(jobs, index);
        int include = jobs[index][2] + dfs3(nonOverLappingIndex, jobs, dp);
        int exclude = dfs3(index + 1, jobs, dp);

        return dp[index] = Math.max(include, exclude);
    }

    static
    public int binarySearch(int[][] jobs, int index) {
        int start = index + 1;
        int end = jobs.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (jobs[mid][0] >= jobs[index][1]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start < jobs.length ? start : -1;
    }
}
