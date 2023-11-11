package com.scribbledtech.praveen.algorithms;

/*Given an array of n positive integers.
Write a program to find the sum of maximum sum subsequence
of the given array such that the integers in the subsequence are sorted in
increasing order. For example, if input is {1, 101, 2, 3, 100, 4, 5}, then
output should be 106 (1 + 2 + 3 + 100), if the input array is {3, 4, 5, 10},
then output should be 22 (3 + 4 + 5 + 10) and if the input array is {10, 5, 4, 3},
then output should be 10*/

public class MaximumSumIncreasingSubsequence {

    static int maxSumIS(int arr[], int n)
    {
        int i, j, max = 0;
        int msis[] = new int[n];

        /* Initialize msis values
           for all indexes */
        for (i = 0; i < n; i++)
        {
            msis[i] = arr[i];
            if (max < msis[i])
            {
                max=msis[i];
            }
        }


        /* Compute maximum sum values
           in bottom up manner */
        for (i = 0; i < n; i++)
        {
            for (j = i+1; j < n; j++)
            {
                if (arr[j] > arr[i] &&
                        msis[j] < msis[i] + arr[j])
                {
                    msis[j] = msis[i] + arr[j];
                    if (max < msis[j])
                    {
                        max=msis[j];
                    }
                }

            }


        }

        return max;
    }

    // Driver code
    public static void main(String args[])
    {
        int arr[] = new int[]{1, 101, 2, 3, 100, 4, 5};
        int n = arr.length;
        System.out.println("Sum of maximum sum "+
                "increasing subsequence is "+
                maxSumIS(arr, n));
    }
}
