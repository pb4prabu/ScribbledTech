package com.scribbledtech.praveen.algorithms;

public class PaintHouseWithTargetNeighborhood {
    /*
    There is a row of m houses in a small city, each house must be painted with one of the n colors (labeled from 1 to n), some houses that have been painted last summer should not be painted again.

    A neighborhood is a maximal group of continuous houses that are painted with the same color.

    For example: houses = [1,2,2,3,3,2,1,1] contains 5 neighborhoods [{1}, {2,2}, {3,3}, {2}, {1,1}].
    Given an array houses, an m x n matrix cost and an integer target where:

    houses[i]: is the color of the house i, and 0 if the house is not painted yet.
    cost[i][j]: is the cost of paint the house i with the color j + 1.
    Return the minimum cost of painting all the remaining houses in such a way that there are exactly target neighborhoods. If it is not possible, return -1.

    Example 1:
    Input: houses = [0,0,0,0,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
    Output: 9
    Explanation: Paint houses of this way [1,2,2,1,1]
    This array contains target = 3 neighborhoods, [{1}, {2,2}, {1,1}].
    Cost of paint all houses (1 + 1 + 1 + 1 + 5) = 9.

    Example 2:
    Input: houses = [0,2,1,2,0], cost = [[1,10],[10,1],[10,1],[1,10],[5,1]], m = 5, n = 2, target = 3
    Output: 11
    Explanation: Some houses are already painted, Paint the houses of this way [2,2,1,2,2]
    This array contains target = 3 neighborhoods, [{2,2}, {1}, {2,2}].
    Cost of paint the first and last house (10 + 1) = 11.

    Example 3:
    Input: houses = [3,1,2,3], cost = [[1,1,1],[1,1,1],[1,1,1],[1,1,1]], m = 4, n = 3, target = 3
    Output: -1
    Explanation: Houses are already painted with a total of 4 neighborhoods [{3},{1},{2},{3}] different of
    * */
    public static void main(String[] args) {
        System.out.println(new PaintHouseWithTargetNeighborhood().minCost(new int[]{0, 2,1,2,0}, new int[][]{{1,10},{10,1},{10,1},{1,10},{5,1}}, 5, 2, 3));

    }


    private int[] houses;
    private int[][] cost;
    private int m;
    private int n;
    private int target;
    private int[][][] memo;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses = houses;
        this.cost = cost;
        this.m = m;
        this.n = n;
        this.target = target;
        this.memo = new int[m][n + 1][target + 1];
        int minPrice = minCostDp(0, 0, 0);
        return minPrice == Integer.MAX_VALUE ? -1 : minPrice;
    }

    public int minCostDp(int houseIndex, int prevColorIndex, int remaining) {
        if(houseIndex == m) return remaining != target ? -1 : 0;

        if(remaining > target) return -1;

        if(memo[houseIndex][prevColorIndex][remaining] != 0) return memo[houseIndex][prevColorIndex][remaining];

        int min = Integer.MAX_VALUE;
        if(houses[houseIndex] == 0) {
            for(int i = 1; i <= n; ++i) {
                int val = prevColorIndex == i
                        ? minCostDp(houseIndex + 1, i, remaining)
                        : minCostDp(houseIndex + 1, i, remaining + 1);

                if(val >= 0)
                    min = Math.min(min, cost[houseIndex][i - 1] + val);
            }
        } else {
            min = minCostDp(houseIndex + 1, houses[houseIndex], houses[houseIndex] == prevColorIndex ? remaining : remaining + 1);
        }

        return memo[houseIndex][prevColorIndex][remaining] = min == Integer.MAX_VALUE ? -1 : min;
    }



}
