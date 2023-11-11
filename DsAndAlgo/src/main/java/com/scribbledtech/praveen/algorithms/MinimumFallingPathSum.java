package com.scribbledtech.praveen.algorithms;
/*
    Given an n x n array of integers matrix, return the minimum sum of any falling path through matrix.
    A falling path starts at any element in the first row and chooses the element in the next row that is either directly below or diagonally left/right. Specifically, the next element from position (row, col) will be (row + 1, col - 1), (row + 1, col), or (row + 1, col + 1).


    Example 1:
    Input: matrix = [[2,1,3],[6,5,4],[7,8,9]]
    Output: 13
    Explanation: There are two falling paths with a minimum sum as shown. 1,5,7 and 1,4,8

    Example 2:
    Input: matrix = [[-19,57],[-40,-5]]
    Output: -59
    Explanation: The falling path with a minimum sum is shown.

* */
public class MinimumFallingPathSum {

    public static void main(String[] args) {

        System.out.println(new MinimumFallingPathSum().minimumPath(new int [][] {{2,1,3},{6,5,4},{7,8,9}}));
    }

    public int minimumPath(int[][] grid) {
        int m= grid.length;
        int n =grid[0].length;
        int[] paths = new int[n];
        int min= Integer.MAX_VALUE;
        for(int i=0;i<m;i++)
        {

            int topLeft=Integer.MAX_VALUE;
            int topRight ;
            for(int j=0;j<n;j++)
            {
                if(i==0)
                {
                    paths[j]=grid[i][j];
                }
                else
                {
                    if(j!=n-1)
                    {
                        topRight= paths[j+1];
                    }
                    else
                    {
                        topRight =Integer.MAX_VALUE;
                    }
                    int val = grid[i][j]+Math.min(topRight,Math.min(topLeft,paths[j]));
                    topLeft=paths[j];
                    paths[j]= val;
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
