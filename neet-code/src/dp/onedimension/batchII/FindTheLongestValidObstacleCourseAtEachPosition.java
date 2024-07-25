package dp.onedimension.batchII;

import java.util.Arrays;

public class FindTheLongestValidObstacleCourseAtEachPosition {
    public static void main(String[] args) {
        int[] obstacles = {3, 1, 5, 6, 4, 2}; // -> output [1,1,2,3,2,2]
//        int[] obstacles = {1,2,3,2}; // output -> [1,2,3,3]
//        int[] obstacles = {2, 2, 1}; // output -> [1,2,1]
        System.out.println(Arrays.toString(longestObstacleCourseAtEachPosition(obstacles)));
    }



    /*
        We can define a vector dp of length n, where dp[i] represents the smallest ending number of an increasing
        subsequence of obstacles that includes the i-th obstacle. We can also define another vector ans of length n,
        where ans[i] represents the length of the longest increasing subsequence of obstacles that includes the i-th obstacle.

        TC = n(log(n))
        SC = O(n)

    */


    static
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        int[] result = new int[obstacles.length]; // to store length of LIS, including the ith obstacle
        int[] dp = new int[obstacles.length]; // to store the smallest ending number of increasing subsequence,including the ith obstacle


        int length = 0; // length of the longest increasing subsequence seen so far
        for (int i = 0; i < obstacles.length; i++) {
            // get the index where obstacle[i] can be inserted
            int index = binarySearch(0, length - 1, obstacles[i], dp);

            dp[index] = obstacles[i]; // add obstacle[i] in dp at correct position

            if (index == length) { // if we added the current obstacle to the end of the dp array
                // update the length of the longest increasing subsequence seen so far
                length++;
            }

            result[i] = index + 1; // update the length of the longest increasing subsequence that includes the i-th obstacle
        }

        return result;
    }

    // returns the position where num could be inserted
    private static int binarySearch(int start, int end, int num, int[] nums) {

        while (start <= end) {
            int mid = start + (end - start) / 2;

            if (nums[mid] <= num) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return start;
    }
}
