package com.scribbledtech.praveen.algorithms;


public class MaxProfitStockSellingUnLimitedTransactionsWithCoolingPeriod {

    /*
    *   You are given an array prices where prices[i] is the price of a given stock on the ith day.

        Find the maximum profit you can achieve. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times) with the following restrictions:

        After you sell your stock, you cannot buy stock on the next day (i.e., cooldown one day).
        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

        Example 1:
        Input: prices = [1,2,3,0,2]
        Output: 3
        Explanation: transactions = [buy, sell, cooldown, buy, sell]

        Example 2:
        Input: prices = [1]
        Output: 0
    * */




    int[] pricesIn;
    int maxTrans;
    int[][] maxSoFar;

    public int maxProfitTopDown( int[] prices) {
        this.pricesIn = prices;
        maxSoFar = new int[prices.length][2];
        return maxProfitStock(0,  0);
    }

    public int maxProfitStock(int day,  int holding) {
        if (day >= pricesIn.length ) {
            return 0;
        }
        if (maxSoFar[day][holding] == 0) {
            if (holding == 0) {
                maxSoFar[day][holding] = Math.max(maxProfitStock(day + 1, holding), maxProfitStock(day + 1, 1) - pricesIn[day]);
            } else {
                maxSoFar[day][holding] = Math.max(maxProfitStock(day + 1, holding), maxProfitStock(day + 2, 0) + pricesIn[day]);
            }

        }
        return maxSoFar[day][holding];
    }

    public static void main(String[] args) {

        System.out.println(new MaxProfitStockSellingUnLimitedTransactionsWithCoolingPeriod().maxProfitTopDown(new int[]{1,2,3,0,2}));
       // System.out.println(new MaxProfitStockSellingLimitedTransactions().maxProfitBottomUp(2, new int[]{3, 2, 6, 5, 0, 3}));

    }

    public int maxProfitBottomUp(int k, int[] prices) {
        int[][][] maxDp = new int[prices.length+1][k + 1][2];
        for (int day = prices.length - 1; day >= 0; day--) {
            for (int remainingTrans = 1; remainingTrans <= k; remainingTrans++) {
                for (int holding = 0; holding < 2; holding++) {
                    if (maxDp[day][remainingTrans][holding] == 0) {
                        if (holding == 0) {
                            maxDp[day][remainingTrans][holding] = Math.max(maxDp[day + 1][remainingTrans][holding], maxDp[day + 1][remainingTrans][1] - prices[day]);
                        } else {
                            maxDp[day][remainingTrans][holding] = Math.max(maxDp[day + 1][remainingTrans][holding], maxDp[day + 1][remainingTrans - 1][0] + prices[day]);
                        }

                    }
                }
            }
        }
        return maxDp[0][k][0];
    }

}
