package com.scribbledtech.praveen.algorithms;


public class MaxProfitStockSellingMultipleTransactions {
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

        System.out.println(new MaxProfitStockSellingMultipleTransactions().maxProfitTopDown(2, new int[]{3, 2, 6, 5, 0, 3}));
        System.out.println(new MaxProfitStockSellingMultipleTransactions().maxProfitBottomUp(2, new int[]{3, 2, 6, 5, 0, 3}));

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
