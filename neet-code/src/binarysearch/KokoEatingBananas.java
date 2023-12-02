package binarysearch;

public class KokoEatingBananas {
    public static void main(String[] args) {
        int[] piles = {3, 6, 7, 11};
        int h = 18;
        System.out.println(minEatingSpeed(piles, h));
    }

    public static int minEatingSpeed(int[] piles, int h) {
        int maxBanana = Integer.MIN_VALUE;
        for (int pile : piles) {
            maxBanana = Math.max(pile, maxBanana);
        }

        // if no of hours == no of piles then koko's bananas-per-hour eating speed = maxBanana
        if (h == piles.length) return maxBanana;

        int start = 1, end = maxBanana;
        int minimumSpeed = Integer.MAX_VALUE;
        while (start <= end) {
            int currentSpeed = start + (end - start) / 2;
            if (isPossible(piles, h, currentSpeed)) {
                minimumSpeed = currentSpeed;
                end = currentSpeed - 1;
            } else {
                start = currentSpeed + 1;
            }

        }

        return minimumSpeed;
    }

    private static boolean isPossible(int[] piles, int h, int speed) {
        int hoursTaken = 0;
        for (int pile : piles) {
            // doing ceil because, if koko cannot finish eating all the banana from that pile,
            // he will need extra hours. Ceil is used to calculate those extra hours
            hoursTaken += (int) Math.ceil((double) pile / speed);
        }

        return hoursTaken <= h;
    }
}
