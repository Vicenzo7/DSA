package binarysearch.bsInSearchSpace;

import java.util.Arrays;

public class AggressiveCows {
    public static void main(String[] args) {
        int n = 5, cows = 3;
        int[] stalls = {1, 2, 8, 4, 9};
        System.out.println(solve(n, cows, stalls));
        System.out.println(solveOptimal(n, cows, stalls));
    }

    /*
    After sorting the array, we set a minimum distance, then we keep on increasing until accommodation of all cows is not possible.
    We stop just before that to get our answer, which in this example is 3.

    For checking if the cows can fit or not, we are simply iterating over our n stalls, and for every stall with the said minimum distance,
    we place our cow.
    After we are done, if all cows have been accommodated, we return true, otherwise false.
    Let’s observe the time complexity of our brute force algorithm here,
    we are increasing distance in each step (which in the worst case of two cows gets as high as m = array[n-1]-array[0]),
    and in that step, we are checking if our cows can “fit”, so we are iterating again for each step to check.

    Time complexity: O(n* m)

    Space Complexity: O(1)

    */

    public static int solve(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        // what can be the maximumDistance
        int maximumDistance = stalls[n - 1] - stalls[0];
        int ans = Integer.MIN_VALUE;
        for (int d = 1; d <= maximumDistance; d++) {
            if (isPossible(stalls, cows, d)) {
                ans = Math.max(ans, d);
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] stalls, int cows, int maxDistance) {
        // we have put a cow in first stall and, therefore
        int previousStall = stalls[0];
        cows--;
        for (int i = 1; i < stalls.length; i++) {
            if (stalls[i] - previousStall >= maxDistance) {
                cows--;
                if (cows == 0) {
                    return true;
                }
                previousStall = stalls[i];
            }
        }
        return false;
    }


    /*
        Optimal solution: binarySearch
        In previous approach we are checking linearly if a distance is a possible distance or not.
        Instead of doing linearly we could do it through binary Search

        Tc O(n*log(maxDistance))

    */

    public static int solveOptimal(int n, int cows, int[] stalls) {
        Arrays.sort(stalls);
        int low = 1, high = stalls[n - 1] - stalls[0];
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(stalls, cows, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }
}
