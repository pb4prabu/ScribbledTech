package com.scribbledtech.praveen.algorithms;

public class PaintHouseWith3Colour {
    /*
    There is a row of n houses, where each house can be painted one of three colors: red, blue, or green. The cost of painting each house with a certain color is different. You have to paint all the houses such that no two adjacent houses have the same color.
    The cost of painting each house with a certain color is represented by an n x 3 cost matrix costs.
    For example, costs[0][0] is the cost of painting house 0 with the color red; costs[1][2] is the cost of painting house 1 with color green, and so on...
    Return the minimum cost to paint all houses.

    Example 1:
    Input: costs = [[17,2,17],[16,16,5],[14,3,19]]
    Output: 10
    Explanation: Paint house 0 into blue, paint house 1 into green, paint house 2 into blue.
    Minimum cost: 2 + 5 + 3 = 10.

    Example 2:
    Input: costs = [[7,6,2]]
    Output: 2
    * */
    public static void main(String[] args) {
       System.out.println(new PaintHouseWith3Colour().minCost(new int [][] {{17,2,17},{16,16,5},{14,3,19}}));
    }
    public int minCost(int[][] grid) {
        int m= grid.length;
        int n =grid[0].length;
        int[] paths = new int[n];
        int min= Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {


            int topRight ;
            int prev =Integer.MAX_VALUE;
            int prevPrev= Integer.MAX_VALUE;
            for(int j=0;j<3;j++)
            {
                if(i==0)
                {
                    paths[j]=grid[i][j];
                }
                else
                {
                   if(j==0)
                   {
                       prev= paths[j];
                       paths[j]=grid[i][j]+Math.min(paths[j+1],paths[j+2]);
                   }
                   else if(j==1)
                    {

                        int val =grid[i][j]+Math.min(paths[j+1],prev);
                        prevPrev=prev;
                        prev= paths[j];
                        paths[j]=val;
                    }
                   else
                   {
                       paths[j]=grid[i][j]+Math.min(prevPrev,prev);
                   }
                }
                if(i==m-1)
                {
                    min = Math.min(min,paths[j]);
                }

            }
        }
        return min;
    }
}
