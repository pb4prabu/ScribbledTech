package com.scribbledtech.praveen.algorithms;
/*
    Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right, which minimizes the sum of all numbers along its path.

    Note: You can only move either down or right at any point in time.

    Example 1:
    Input: grid = [[1,3,1],[1,5,1],[4,2,1]]
    Output: 7
    Explanation: Because the path 1 → 3 → 1 → 1 → 1 minimizes the sum.

    Example 2:
    Input: grid = [[1,2,3],[4,5,6]]
    Output: 12

* */
public class MinimumPathSum {

    public static void main(String[] args) {

        System.out.println(new MinimumPathSum().minimumPath(new int [][] {{1,3,1},{1,5,1},{4,2,1}}));
    }

    public int minimumPath(int[][] grid) {
        int m= grid.length;
        int n =grid[0].length;
        int[] paths = new int[n];
        for(int i=0;i<m;i++)
        {
            int top=Integer.MAX_VALUE;
            int left=Integer.MAX_VALUE;
            for(int j=0;j<n;j++)
            {
                if(i==0 && j==0)
                {
                    paths[j]= grid[i][j];
                }
                else
                {
                    if(i!=0)
                    {
                        top=paths[j];
                    }
                    if(j!=0)
                    {
                        left=paths[j-1];
                    }
                    paths[j]= grid[i][j]+Math.min(top,left);
                }


            }
        }
        return paths[n-1];
    }
}
