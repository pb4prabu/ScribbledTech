package com.scribbledtech.praveen.algorithms;


public class MaxProfitStockSellingLimitedTransactions {

    /*
    *   You are given an integer array prices where prices[i] is the price of a given stock on the ith day, and an integer k.

        Find the maximum profit you can achieve. You may complete at most k transactions.

        Note: You may not engage in multiple transactions simultaneously (i.e., you must sell the stock before you buy again).

        Example 1:
        Input: k = 2, prices = [2,4,1]
        Output: 2
        Explanation: Buy on day 1 (price = 2) and sell on day 2 (price = 4), profit = 4-2 = 2.

        Example 2:
        Input: k = 2, prices = [3,2,6,5,0,3]
        Output: 7
        Explanation: Buy on day 2 (price = 2) and sell on day 3 (price = 6), profit = 6-2 = 4. Then buy on day 5 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
    * */
    int[] pricesIn;
    int maxTrans;
    int[][][] maxSoFar;

    public int maxProfitTopDown(int k, int[] prices) {
        this.pricesIn = prices;
        this.maxTrans = k;
        maxSoFar = new int[prices.length][k + 1][2];
        return maxProfitStock(0, k, 0);
    }

    public int maxProfitStock(int day, int remainingTrans, int holding) {
        if (day >= pricesIn.length || remainingTrans == 0) {
            return 0;
        }
        if (maxSoFar[day][remainingTrans][holding] == 0) {
            if (holding == 0) {
                maxSoFar[day][remainingTrans][holding] = Math.max(maxProfitStock(day + 1, remainingTrans, holding), maxProfitStock(day + 1, remainingTrans, 1) - pricesIn[day]);
            } else {
                maxSoFar[day][remainingTrans][holding] = Math.max(maxProfitStock(day + 1, remainingTrans, holding), maxProfitStock(day + 1, remainingTrans - 1, 0) + pricesIn[day]);
            }

        }
        return maxSoFar[day][remainingTrans][holding];
    }

    public static void main(String[] args) {

        System.out.println(new MaxProfitStockSellingLimitedTransactions().maxProfitTopDown(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new MaxProfitStockSellingLimitedTransactions().maxProfitBottomUp(2, new int[]{3, 2, 6, 5, 0, 3}));

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
