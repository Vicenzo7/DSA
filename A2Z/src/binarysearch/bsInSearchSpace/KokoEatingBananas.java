package binarysearch.bsInSearchSpace;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {30, 11, 23, 4, 20};
        int h = 6;

//        int[] piles = {30, 11, 23, 4, 20};
//        int h = 5;
        System.out.println(minEatingSpeed(piles, h));
    }

    /*
        Solution : BinarySearch Space Search
        We need to give minimum number bananas that a koko can eat in an hour such that,
        she can eat all the banana.

        Maximum number of banana koko can eat is : maxBanana in piles
        Minimum number of banana koko can eat is : minBanana in piles or zero

        so our search space is from 0 to max bananas.

        What if given numbers of hours is equal to number of piles,
        minimum number of bananas koko can eat in an hour is maxBanana.

        calculate the mid anc check can mid be a possible answer, even though mid is an answer,
        store it and go on the left,because we want minimum number of bananas
        if mid is not an answer go to right;

    */


    public static int minEatingSpeed(int[] piles, int h) {
        int ans = -1;
        int maxBananas = -1;
        // search for range
        for (int pile : piles) {
            maxBananas = Math.max(maxBananas, pile);
        }
        // if hours and number of piles are same, the ans is max bananas is a pile.
        if (h == piles.length) {
            return maxBananas;
        }
        int low = 0, high = maxBananas;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isPossible(piles, mid, h)) { // if mid is an answer store it and check on left because we need minimum
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }

    private static boolean isPossible(int[] piles, int mid, int h) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil((double) pile / mid);
        }
        return hours <= h;
    }
}
