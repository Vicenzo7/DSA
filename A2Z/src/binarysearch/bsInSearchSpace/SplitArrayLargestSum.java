package binarysearch.bsInSearchSpace;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        int[] nums = {7, 2, 5, 10, 8};
        int k = 2;
        System.out.println(splitArray(nums, k));
    }
    /*      7,2,5,10,8 given array split into two parts

            7 - 2,5,10,8 = (7,25) = 25
            7,2 - 5,10,8 = (9,23) = 23
            7,2,5 - 10,8 = (14,18) = 18
            7,2,5,10, - 8 = (24,8) = 24*/

    /*
        Same as book allocation
        Find the search space
        low = maxElement, high = sumOfElements

        calculate mid,check if mid is possible ans, if yes store it and move towards left because we need minimum.
        else move right.

        how to check mid is possible answer
        pieceCount = 1
        sumOfElement + element <= mid then sumOfElement += element , else
        sumOfElement = element
        pieceCount++;
        if pieceCount > requiredPiece || element > mid return false;

        return true or pieceCount <= requiredPiece

        TC = O(n * log(n))

    */

    public static int splitArray(int[] nums, int k) {

        int ans = -1;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(num, max);
        }

        int low = max, high = sum;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(nums, k, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] nums, int requiredPiece, int mid) {
        int pieceCount = 1;
        int sumCount = 0;
        for (int num : nums) {
            if (sumCount + num <= mid) {
                sumCount += num;
            } else {
                sumCount = num;
                pieceCount++;
                if (pieceCount > requiredPiece || num > mid) {
                    return false;
                }
            }
        }

        return true;
    }
}
