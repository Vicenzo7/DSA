package dp.onedimension.batchII;

import java.util.HashMap;
import java.util.Map;

public class New21Game {
    public static void main(String[] args) {
        int n = 21, k = 17, maxPts = 10;
//        int n = 6, k = 1, maxPts = 10;
//        int n = 0, k = 0, maxPts = 1;
        System.out.println(new21Game(n, k, maxPts));
    }


    public static double new21Game(int n, int k, int maxPts) {
        //return bruteForce(0, n, k, maxPts, new Double[2 * maxPts + 1]);
        return slidingWindowTechnique(n, k, maxPts);
    }



    /*
        eg
        k = 2, maxPts = 3, n = 3

                                0
                  /             |           \
                1           2-> good node     3-> good node
              / |  \
            2   3  4

            2/3 + 3/3 + 3/3 = 8/3

            8/3 / no of branching = (8/3) / maxPts = (8/3)/3 = 8/9

    */

    private static double bruteForce(int score, int n, int k, int maxPts, Double[] cache) {
        if (score >= k) {
            return score <= n ? 1 : 0;
        }

        if (cache[score] != null) {
            return cache[score];
        }

        double probability = 0;

        for (int i = 1; i <= maxPts; i++) {
            // score + i -> here we draw the card
            probability += bruteForce(score + i, n, k, maxPts, cache);
        }

        cache[score] = probability / maxPts; // dividing by maxPts because we are going to branch maxPts times
        return cache[score];
    }


    /*
        To solve Optimally we use sliding window technique

    */

    private static double slidingWindowTechnique(int n, int k, int maxPts) {
        if (k == 0 || k + maxPts <= n)
            return 1.0;

        double windowSum = 0D;
        for (int i = k; i < k + maxPts; i++) {
            windowSum += i <= n ? 1 : 0;
        }

        Map<Integer, Double> cache = new HashMap<>();
        for (int i = k - 1; i >= 0; i--) {
            double ans = windowSum / maxPts;
            cache.put(i, ans);
            // Since we are shifting the window add newly calculate ans to our window and
            // remove the last part from the window
            double remove = 0;
            if (i + maxPts <= n) {
                remove = cache.getOrDefault(i + maxPts, 1D);
            }
            windowSum += ans - remove;
        }

        return cache.get(0);
    }

}
