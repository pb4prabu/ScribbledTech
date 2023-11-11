package com.scribbledtech.praveen.algorithms;

public class FindMedianOfTwoSoretedArrays {

    public static void main(String[] args) {
        System.out.println(new FindMedianOfTwoSoretedArrays().findMedian(new int[]{2,4,6,8,20},new int[]{10,12,16,18,24}));
    }

    public int findMedian(int[] arr1,int[] arr2) {

        int start1=0,start2=0;
        int end1=arr1.length-1,end2=arr2.length-1;

        while(end1-start1>1)
        {
            int med1 =median(arr1,start1,end1);
            int med2=median(arr2,start2,end2);
            if(med1== med2)
            {
                return med1;
            }
            if(med1>med2)
            {
                end1= (end1+start1+1)/2;
                start2= (end2+start2)/2;
            }
            else
            {
                start1= (end1+start1)/2;
                end2= (end2+start2+1)/2;
            }
        }

        return (Math.max(arr1[start1],arr2[start2]) +Math.min(arr1[end1],arr2[end2]))/2;


    }

    private int median(int arr[], int start,int end)
    {
        int length =end-start+1;
        if(length%2==0)
        {
            return (arr[start+(length/2)-1] + arr[start+(length/2)])/2;
        }
        return arr[start+(length/2)];
    }

}
