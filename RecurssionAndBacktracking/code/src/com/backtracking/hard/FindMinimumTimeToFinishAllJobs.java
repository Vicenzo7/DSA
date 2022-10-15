package com.backtracking.hard;

import java.util.Arrays;

public class FindMinimumTimeToFinishAllJobs {
    public static void main(String[] args) {
        int[] jobs = {1, 2, 4, 7, 8};
        int k = 2;
        System.out.println(minimumTimeRequired(jobs, k));
    }

    static int result = Integer.MAX_VALUE;

    public static int minimumTimeRequired(int[] jobs, int k) {
        int length = jobs.length;
        Arrays.sort(jobs);
        backtrack(jobs, length - 1, new int[k]);
        return result;
    }

    public static void backtrack(int[] jobs, int current, int[] workers) {
        if (current < 0) {
            result = Math.min(result, Arrays.stream(workers).max().getAsInt());
            return;
        }

        // optimization 1
        if (Arrays.stream(workers).max().getAsInt() >= result)
            return;
        for (int i = 0; i < workers.length; i++) {
            // optimization 2
            if (i > 0 && workers[i] == workers[i - 1])
                continue;
            // make choice
            workers[i] += jobs[current];
            // backtrack
            backtrack(jobs, current - 1, workers);
            // undo the choice
            workers[i] -= jobs[current];
        }
    }
}
