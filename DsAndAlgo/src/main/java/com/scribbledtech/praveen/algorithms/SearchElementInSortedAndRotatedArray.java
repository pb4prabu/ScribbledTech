package com.scribbledtech.praveen.algorithms;

public class SearchElementInSortedAndRotatedArray {
    /*

    */

    public static void main(String[] args) {
        System.out.println(new SearchElementInSortedAndRotatedArray().search(new int[]{5,6,7,8,9,1,2,3,4},10));
    }

    public int search(int[] nums, int element) {

       int start=0;
       int end =nums.length-1;


       while(start<=end)
       {
           int mid = (start +end)/2;
            if(element==nums[mid])
            {
                return mid;
            }

            if(nums[start]<nums[mid] && nums[mid]<nums[end])
            {
                if(element<nums[mid])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }

            }
            else
            {
                if(element>nums[end])
                {
                    end=mid-1;
                }
                else
                {
                    start=mid+1;
                }
            }


       }

       return -1;

    }

}
