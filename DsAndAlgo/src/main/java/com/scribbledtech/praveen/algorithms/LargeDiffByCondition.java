package com.scribbledtech.praveen.algorithms;
/*
* Maximum difference between two elements such that larger element appears after the smaller number
* Input : arr = {2, 3, 10, 6, 4, 8, 1}
    Output : 8
    Explanation : The maximum difference is between 10 and 2.
* */
public class LargeDiffByCondition {

    public static void main(String[] args) {
       System.out.println(findLargeDiff(new int[]{7, 9, 5, 6, 3, 2}));
    }
    private static int findLargeDiff(int arr[])
    {
        int minSoFar=arr[0];
        int maxSoFar=arr[0];
        int maxDiffSoFar =0;

        for(int i=1;i<arr.length;i++)
        {
            if(minSoFar>arr[i])
            {
                 minSoFar=arr[i];
                 maxSoFar=arr[i];
            }
            if(maxSoFar<arr[i])
            {
                maxSoFar=arr[i];
                if(maxDiffSoFar<(maxSoFar-minSoFar))
                {
                    maxDiffSoFar=maxSoFar-minSoFar;
                }

            }

        }
        return maxDiffSoFar;
    }
}
