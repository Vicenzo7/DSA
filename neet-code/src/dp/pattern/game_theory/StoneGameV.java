package dp.pattern.game_theory;

import java.util.Arrays;

public class StoneGameV {
    public static void main(String[] args) {

//        int[] stoneValue = {6, 2, 3, 4, 5, 5};
//        int[] stoneValue = {7, 7, 7, 7, 7, 7, 7};
        int[] stoneValue = {4};
        System.out.println(stoneGameV(stoneValue));
    }


    static
    public int stoneGameV(int[] stoneValue) {
        int n = stoneValue.length;
        return dfs(0, n - 1, stoneValue, new Integer[n + 1][n + 1]);
    }

    static
    private int dfs(int start, int end, int[] stoneValue, Integer[][] dp) {

        // only one element
        if (start > end) {
            return 0;
        }

        if (dp[start][end] != null) {
            return dp[start][end];
        }

        int rightSum = Arrays.stream(stoneValue, start, end + 1).sum();

        int leftSum = 0;
        int result = 0;
        for (int i = start; i <= end; i++) {
            leftSum += stoneValue[i];
            rightSum -= stoneValue[i];


            if (leftSum < rightSum) {
                result = Math.max(result, leftSum + dfs(start, i, stoneValue, dp));
            } else if (leftSum > rightSum) {
                result = Math.max(result, rightSum + dfs(i + 1, end, stoneValue, dp));
            } else {
                result = Math.max(result, leftSum + Math.max(dfs(start, i, stoneValue, dp), dfs(i + 1, end, stoneValue, dp)));
            }
        }

        return dp[start][end] = result;

    }
}
