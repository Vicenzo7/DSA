package slidingwindow;

public class BestTimeToSellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
//        int[] prices = {7,6,4,3,1};
        System.out.println(maxProfit(prices));
    }

//    public static int maxProfit(int[] prices) {
//        int maxProfit = 0;
//
//        for (int i = 0; i < prices.length - 1; i++) {
//            for (int j = i + 1; j < prices.length; j++) {
//                maxProfit = Math.max(prices[j] - prices[i], maxProfit);
//            }
//        }
//
//        return maxProfit;
//    }


    public static int maxProfit(int[] prices) {
        int left = 0, right = 1; // left = buy, right = sell
        int maxProfit = 0;
        while (right < prices.length) {
            // profitable ?
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                maxProfit = Math.max(maxProfit, profit);
            } else {
                left = right;
            }
            right += 1;
        }

        return maxProfit;
    }

    public static int maxProfitOptimised(int[] prices) {
        int maxProfit = 0;
        int minimumPrice = Integer.MAX_VALUE;
        for (int price : prices) {
            minimumPrice = Math.min(price, minimumPrice);
            maxProfit = Math.max(maxProfit, price - minimumPrice);
        }

        return maxProfit;
    }
}
