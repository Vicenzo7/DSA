package dp.twodimension;

import java.util.HashMap;
import java.util.Map;

public class BestTimeToBuyAndSellStockWithCoolDown {
    public static void main(String[] args) {
        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(maxProfit(prices));
    }



    /*
        Do I have a stock ?
        Yes -> Two option
            1. Sell the stock.
            2. Skip the day
        No -> Two option
            1. Buy the stock
            2. Skip the day

    */

    public static int maxProfit(int[] prices) {

//        return bruteForce(0, false, prices);
        return memoization(0, false, prices, new HashMap<>());
    }

    private static int bruteForce(int index, boolean haveStock, int[] prices) {

        if (index >= prices.length) {
            return 0;
        }

        int option1;
        int option2;

        if (haveStock) {
            // index + 2 after selling to force the cooldown.
            option1 = prices[index] + bruteForce(index + 2, false, prices); // sell
            option2 = bruteForce(index + 1, true, prices); // skip
        } else {
            option1 = bruteForce(index + 1, true, prices) - prices[index];
            option2 = bruteForce(index + 1, false, prices); // skip
        }

        return Math.max(option1, option2);
    }

    private static int memoization(int index, boolean haveStock, int[] prices, Map<String, Integer> cache) {

        if (index >= prices.length) {
            return 0;
        }

        if (cache.containsKey(String.valueOf(index) + haveStock)) {
            return cache.get(String.valueOf(index) + haveStock);
        }

        int option1;
        int option2;

        if (haveStock) {
            // index + 2 after selling to force the cooldown.
            option1 = prices[index] + memoization(index + 2, false, prices, cache); // sell
            option2 = memoization(index + 1, true, prices, cache); // skip
        } else {
            option1 = memoization(index + 1, true, prices, cache) - prices[index];
            option2 = memoization(index + 1, false, prices, cache); // skip
        }

        cache.put(String.valueOf(index) + haveStock, Math.max(option1, option2));
        return cache.get(String.valueOf(index) + haveStock);
    }
}
