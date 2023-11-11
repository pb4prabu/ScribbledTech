package com.scribbledtech.praveen.algorithms;


public class MaxProfitStockSellingUnLimitedTransactions {

    /*
    *   You are given an array prices where prices[i] is the price of a given stock on the ith day.

        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times)

        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

        Example 1:
        Input: prices = [1,2,3,0,2]
        Output: 4
        Explanation: transactions = [buy, do_nothing, sell, buy, sell]

        Example 2:
        Input: prices = [1]
        Output: 0
    * */




    public static void main(String[] args) {

        System.out.println(new MaxProfitStockSellingUnLimitedTransactions().maxProfit( new int[]{1,2,3,0,2}));

    }

    public int maxProfit( int[] prices) {
        int day=0;
        int profit =0;

        while(day+1<prices.length)
        {
            int start=day;

            while(day+1<prices.length && prices[day]>prices[day+1])
            {
                start =day+1;
                day++;
            }

            day= start+1;
            while(day+1<prices.length && prices[day]<=prices[day+1] )
            {

                day++;
            }
            profit = profit+prices[day]-prices[start];
            day++;
        }
        return profit;

    }

}
