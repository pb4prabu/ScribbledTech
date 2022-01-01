package com.scribbledtech.praveen.algorithms;
/*
    A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
    Now consider if some obstacles are added to the grids. How many unique paths would there be?
    An obstacle and space is marked as 1 and 0 respectively in the grid.

    Example 1:
    Input: obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
    Output: 2
    Explanation: There is one obstacle in the middle of the 3x3 grid above.
    There are two ways to reach the bottom-right corner:
    1. Right -> Right -> Down -> Down
    2. Down -> Down -> Right -> Right

    Example 2:
    Input: obstacleGrid = [[0,1],[0,0]]
    Output: 1

* */
public class UniquePathInMatrixWithObstacle {

    public static void main(String[] args) {

        System.out.println(new UniquePathInMatrixWithObstacle().uniquePathsWithObstacles(new int [][] {{0,0,0},{0,1,0},{0,0,0}}));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m= obstacleGrid.length;
        int n =obstacleGrid[0].length;
        int[] paths = new int[n];
        int fill =1;
        for(int i=n-1;i>=0;i--)
        {
            if(obstacleGrid[m-1][i]==1)
            {
                fill=0;
            }

            paths[i]  =fill;
        }
        for(int i=m-2;i>=0;i--)
        {
            for(int j=n-1;j>=0;j--)
            {
                if( obstacleGrid[i][j]==1)
                {
                    paths[j]=0;
                }
                else if(j!=n-1)
                {
                    paths[j]= paths[j]+ paths[j+1];
                }

            }
        }
        return paths[0];
    }
}
