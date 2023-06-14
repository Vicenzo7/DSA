package binarysearch.bsInSearchSpace;

public class MinimumNumberOfDaysToMakeMBouquets {
    public static void main(String[] args) {
//        int[] bloomDay = {7, 7, 7, 7, 12, 7, 7};
//        int m = 2, k = 3;
        int[] bloomDay = {1000000000, 1000000000};
        int m = 1, k = 1;
        System.out.println(minDays(bloomDay, m, k));
    }

    /*
      This is binary search space  problem.
      Return minimum number of days to make bouquets

      Finding search Space;
      search space is
      low = minimum number of days in bloomDay to
      high = maximum number of days in bloomDay

      calculate mid and check if that is a possible ans,
      if possible ands store it and check move to left as we need minimum number of days
      else move right

      how to check if mid is a possible ans

      keep a flowerCount, bouquetsCount
      iterate the bloomDay and
      if that flower has bloomed ie mid <= day , we can pick that flower
      if not then flowerCount is 0 because we need adjacent flowers to make bouquets

      Simultaneously check if flowerCount Match the required flowers to make bouquets, if yes increase bouquetsCount, and reset the flowerCount to 0

      At the end check if the bouquetsCount >= requiredBouquets
      Check if bouquetsMade >= requiredBouquets


      Edge case:
      bloomDays.length  < m * k  -> return -1
      This means No of flowers required is more than no of flowers we can have
      5 < 3*2

      TC = O(n * log(maxDay))
      Reason n to find the max and min bloom days, where n is length of bloomDays
      log(maxDays) because binarySearch is applied till maxDays.

    */

    public static int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length < m * k) return -1;
        int ans = -1;
        int maxDays = Integer.MIN_VALUE;
        int minDays = Integer.MAX_VALUE;
        for (int day : bloomDay) {
            maxDays = Math.max(day, maxDays);
            minDays = Math.min(day, minDays);
        }
        int low = minDays, high = maxDays;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] bloomDay, int possibleDay, int bouquetsRequired, int flowersInBouquets) {
        // this method is to check can we make sufficient bouquets
        int flowersCollected = 0, bouquetsMade = 0;
        for (int dayOfBloom : bloomDay) {
            if (dayOfBloom <= possibleDay) { // check if the flower has bloomed, so that it can be used in the bouquet
                flowersCollected++;
            } else { // if not bloomed, reset the counter.
                flowersCollected = 0;
            }

            // check if flowers collected are equal to the required flowers per bouquets, the increase the bouquetsMadeCount;
            if (flowersCollected == flowersInBouquets) {
                bouquetsMade++;
                flowersCollected = 0;
            }
        }

        return bouquetsMade >= bouquetsRequired;
    }
}
