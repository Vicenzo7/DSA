package dp.onedimension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CoinChange {
    public static void main(String[] args) {
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = {10};
        int amount = 10;
//        int[] coins = {411, 412, 413, 414, 415, 416, 417, 418, 419, 420, 421, 422};
//        int amount = 9864;

        System.out.println(coinChange(coins, amount));
        System.out.println(bruteForce(coins, amount));
        Integer[] cache = new Integer[amount + 1];

        System.out.println(memoization(coins, amount, cache));
        System.out.println(memoizationWithMap(coins, amount, new HashMap<>()));
    }


    public static int coinChange(int[] coins, int amount) {
        int[] ans = new int[1];
        ans[0] = Integer.MAX_VALUE;
        dfs(0, coins, amount, 0, ans);
        return ans[0] == Integer.MAX_VALUE ? -1 : ans[0];
    }

    private static void dfs(int index, int[] coins, int amount, int coinCount, int[] ans) {
        if (amount == 0) {
            ans[0] = Math.min(coinCount, ans[0]);
            return;
        }

        if (amount < 0) {
            return;
        }
        for (int i = index; i < coins.length; i++) {
            coinCount++;
            dfs(i, coins, amount - coins[i], coinCount, ans);
            coinCount--;
        }
    }


    public static int bruteForce(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        int cc = -1;
        for (int i : coins) {
            int coin = bruteForce(coins, amount - i);
            if (coin >= 0) cc = cc < 0 ? coin : Math.min(cc, coin);
        }
        return cc < 0 ? -1 : cc + 1;
    }

    static
    private int memoization(int[] coins, int amount, Integer[] cache) {
        if (amount == 0)
            return 0;
        if (amount < 0)
            return -1;
        if (cache[amount] != null) {
            return cache[amount];
        }
        int minCoin = -1;
        for (int coin : coins) {
            int result = memoization(coins, amount - coin, cache);
            if (result >= 0) {
                minCoin = minCoin < 0 ? result : Math.min(minCoin, result);
            }
        }
        cache[amount] = minCoin < 0 ? -1 : minCoin + 1;
        return cache[amount];
    }

    private static int memoizationWithMap(int[] coins, int amount, Map<Integer, Integer>
            cache) {

        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (cache.containsKey(amount)) {
            return cache.get(amount);
        }
        int cc = -1;
        for (int i : coins) {
            int coin = memoizationWithMap(coins, amount - i, cache);
            if (coin >= 0) cc = cc < 0 ? coin : Math.min(cc, coin);
        }
        int v = cc < 0 ? -1 : cc + 1;
        cache.put(amount, v);
        return v;
    }

}
