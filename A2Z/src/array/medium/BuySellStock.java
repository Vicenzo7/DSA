package array.medium;

public class BuySellStock {
    public static void main(String[] args) {
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitOptimal(prices));
        stockBuySell(prices,prices.length);
    }
/*
    Time complexity: O(n^2)

    Space Complexity: O(1)*/

    public static int maxProfit(int[] prices) {
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[j] > prices[i]) {
                    maxProfit = Math.max(maxProfit, prices[j] - prices[i]);
                }
            }
        }
        return maxProfit;
    }

    /*Brute force
    Traverse the array from 0 to n. Now let us consider that the price[i] element is the smallest.
    Considering this lets find a number which is greater than nums[i]. If we found it lets update the maxProfit
    by maxProfit = Math.max(maxProfit,nums[i] - num[j]);

    Do this for each element,and we'll get the answer.
    TC O(n^2).

    But there is an optimal solution TC O(n)
    Lets take two variable maxProfit = 0 and minNumber = Some large number MAX_VALUE
    We traverse the array and update the minNumber if minNumber > currentElement
    Assuming we found a minNumber we update the maxProfit.
    maxProfit = Math.max(maxProfit, element - minNumber)*/

    public static int maxProfitOptimal(int[] prices) {
        int maxProfit = 0;
        int min = Integer.MAX_VALUE;
        for (int num : prices) {
            min = Math.min(min, num);
            maxProfit = Math.max(maxProfit, num - min);
        }
        return maxProfit;
    }

    //Geeks for geek
    //https://practice.geeksforgeeks.org/problems/stock-buy-and-sell2615/0?company[]=Intuit+&page=1&query=company[]Intuit+page1

    public static void stockBuySell(int[] price, int n) {
        int start = 0, flag = 0;
        for (int i = 0; i < n; i++) {
            while (i < n - 1 && price[i] < price[i + 1]) {
                i++;
            }

            if (i != start && price[i] > price[start]) {
                flag = 1;
                System.out.print("(" + start + " " + i + ")" + " ");
            }
            start = i + 1;
        }
        if (flag == 0) {
            System.out.print("No Profit");
        }
        System.out.println();
    }
}
