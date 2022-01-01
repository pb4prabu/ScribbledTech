package com.scribbledtech.praveen.algorithms;

import java.sql.Array;
import java.util.Arrays;

public class PaintHouseWithKColour {
    /*
   There are a row of n houses, each house can be painted with one of the k colors. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.

    The cost of painting each house with a certain color is represented by an n x k cost matrix costs.

    For example, costs[0][0] is the cost of painting house 0 with color 0; costs[1][2] is the cost of painting house 1 with color 2, and so on...
    Return the minimum cost to paint all houses.

    Example 1:
    Input: costs = [[1,5,3],[2,9,4]]
    Output: 5
    Explanation:
    Paint house 0 into color 0, paint house 1 into color 2. Minimum cost: 1 + 4 = 5;
    Or paint house 0 into color 2, paint house 1 into color 0. Minimum cost: 3 + 2 = 5.

    Example 2:
    Input: costs = [[1,3],[2,4]]
    Output: 5

    Constraints:
    costs.length == n
    costs[i].length == k
    1 <= n <= 100
    2 <= k <= 20
    1 <= costs[i][j] <= 20

    Follow up: Could you solve it in O(nk) runtime?
    * */
    public static void main(String[] args) {
        System.out.println(new PaintHouseWithKColour().minCostII(new int[][]{{1, 5, 3}, {2, 9, 4}}));
    }

    int m;
    int n;

    public int minCostII(int[][] costs) {
        m = costs.length;
        n = costs[0].length;
        int minCost[][] = new int[2][n];
        int[] paths = minCost[0];
        int[] current = minCost[1];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int topRight;
            int prev = Integer.MAX_VALUE;
            int prevPrev = Integer.MAX_VALUE;
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    current[j] = costs[i][j];
                } else {
                    int val  = Math.min(findMin(0, j - 1, paths), findMin(j + 1, n - 1, paths)) ;

                    if(val == Integer.MAX_VALUE)
                    {
                        val =0;
                    }

                    current[j] = costs[i][j] + val;
                }
                if (i == m - 1) {
                    min = Math.min(min, current[j]);
                }
            }
            int[] temp = paths;
            paths = current;
            current = temp;
        }
        return min;
    }

    int findMin(int start, int end, int[] arr) {
        if (end < 0 || start > n - 1) {
           return  Integer.MAX_VALUE;
        }
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            min = Math.min(min, arr[i]);
        }
        return min;
    }
}
