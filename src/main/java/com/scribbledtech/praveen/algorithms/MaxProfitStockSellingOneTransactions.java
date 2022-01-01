package com.scribbledtech.praveen.algorithms;


public class MaxProfitStockSellingOneTransactions {

    /*
    *
    You are given an array prices where prices[i] is the price of a given stock on the ith day.

    You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

    Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.

    Example 1:
    Input: prices = [7,1,5,3,6,4]
    Output: 5
    Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
    Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

    Example 2:
    Input: prices = [7,6,4,3,1]
    Output: 0
    Explanation: In this case, no transactions are done and the max profit = 0.
    * */


    public int maxProfit(int[] prices) {

        int profit = 0;
        if (prices.length == 1) {
            return 0;
        }
        int sell = prices.length - 1;
        for (int curr = prices.length - 2;curr>=0; curr--) {
            if (prices[curr] > prices[sell]) {
                sell = curr;
            } else {
                profit = Math.max(prices[sell] - prices[curr], profit);
            }
        }
        return profit;
    }


    public static void main(String[] args) {

        System.out.println(new MaxProfitStockSellingOneTransactions().maxProfit(new int[]{7,1,5,3,6,4}));

    }


}
