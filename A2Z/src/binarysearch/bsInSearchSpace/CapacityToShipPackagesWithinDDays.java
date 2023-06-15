package binarysearch.bsInSearchSpace;

public class CapacityToShipPackagesWithinDDays {
    public static void main(String[] args) {
        int[] weights = {1, 2, 3, 1, 1};
        int days = 4;
        System.out.println(shipWithinDays(weights, days));
    }

    /*
        Binary Search Space
        we need minimum weights so that ship can carry all weights in 5 days,
        So our search space is from max Weight to sum of all weights;

        low = max Weight because, it's the minimum weight it needs to carry
        so low = max Weight and high = sum of all weights
        calculate the mid and check if mid is a minimum weight

        how to check if mid is minimum weight
        iterate the weights array and sum it until its <= mid,
        if its greater increase the dayCount;

        At the end check if dayCount <= maximumDay, then return true or else false;

        TC = O(n * log(sum of Weights))
        Reason n to find the sum of weights , where n is length of nums
        log(sum of Weights) because binarySearch is applied from 0 to  sumOfWeights.

    */

    public static int shipWithinDays(int[] weights, int days) {
        int ans = -1;
        int sumOfWeights = 0;
        int start = Integer.MIN_VALUE;
        for (int weight : weights) {
            sumOfWeights += weight;
            start = Math.max(start,weight);
        }
        int low = start, high = sumOfWeights;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossibleMinimumWeight(weights, mid, days)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossibleMinimumWeight(int[] weights, int maximumWeight, int maximumDays) {
        int weightSum = 0, daysRequired = 1;
        for (int weight : weights) {
            if (weightSum + weight <= maximumWeight) {
                weightSum += weight;
            } else {
                weightSum = weight;
                daysRequired++;
            }
        }

        return daysRequired <= maximumDays;
    }
}
