package com.scribbledtech.praveen.algorithms;


public class MaximumSumCircularSubarray {

    /*
    *
    Given a circular integer array nums of length n, return the maximum possible sum of a non-empty subarray of nums.
    A circular array means the end of the array connects to the beginning of the array. Formally, the next element of nums[i] is nums[(i + 1) % n] and the previous element of nums[i] is nums[(i - 1 + n) % n].
    A subarray may only include each element of the fixed buffer nums at most once. Formally, for a subarray nums[i], nums[i + 1], ..., nums[j], there does not exist i <= k1, k2 <= j with k1 % n == k2 % n.

    Example 1:
    Input: nums = [1,-2,3,-2]
    Output: 3
    Explanation: Subarray [3] has maximum sum 3.

    Example 2:
    Input: nums = [5,-3,5]
    Output: 10
    Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10.

    Example 3:
    Input: nums = [-3,-2,-3]
    Output: -2
    Explanation: Subarray [-2] has maximum sum -2.

    * */
    public static void main(String[] args) {

        System.out.println(new MaximumSumCircularSubarray().maxSubarraySumCircular(new int[]{5,-3,-4,5}));

    }

    public int maxSubarraySumCircular(int[] nums) {

        int sum =0;
        for(int i:nums)
        {
            sum=sum+i;
        }

        int maxKardNoWrap = kadane(nums,1);// straight case there is no wrapping of array
        int minKard=kadane(nums,-1); // wrapped array case where the max is Array sum - min kardane
        if(sum==minKard) // all are negative values then return the maxKard it will be pointing to the single negative value that is close to zero
        {
            return maxKardNoWrap;
        }
        int maxKardWrap = sum-minKard;
        return Math.max(maxKardNoWrap,maxKardWrap);
    }

    public int kadane(int[] nums, int sign)
    {
        int maxSub = sign*nums[0];
        int currSum = sign*nums[0];

        for(int i=1;i<nums.length;i++)
        {
            int element = sign*nums[i];
            currSum = Math.max(currSum+element,element);
            maxSub=  Math.max(maxSub,currSum);
        }
        return maxSub*sign; // reversing the sign of result if it is negative
    }

}
