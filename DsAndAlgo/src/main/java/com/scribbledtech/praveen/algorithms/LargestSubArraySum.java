package com.scribbledtech.praveen.algorithms;

public class LargestSubArraySum {
    /*
    Write an efficient program to find the sum of contiguous subarray within a one-dimensional array of numbers that has the largest sum.
    ex: -2,-3,4,-1,-2,1,5,-3
    Ans: 4,-1,-2,1,5
    */

    public static void main(String[] args) {
        System.out.println(new LargestSubArraySum().change(new int[]{-2,-3,4,-1,-2,1,5,-3}));
    }

    public int change(int[] nums) {

        int largestSum=nums[0];
        int currSum=nums[0];
        for(int i=1;i< nums.length;i++)
        {
            currSum= Math.max(nums[i],nums[i]+currSum);
            largestSum = Math.max(currSum,largestSum);
        }
        return largestSum;
    }

}
