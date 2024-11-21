package com.scribbledtech.praveen.algorithms;
//Maximum Sum Without Adjacent Elements (With Negative Numbers)
public class MaximumSumSuchThatNoTwoElementsAreAdjacent {

    public static void main(String[] args) {
        System.out.println(new MaximumSumSuchThatNoTwoElementsAreAdjacent().findMax(new int[]{12, 4, -6, -8, 20}));
    }

    public int findMax(int[] arr1) {

        int sum=0;
        int sumIncl = arr1[0];
        int sumExcl = arr1[1];
        for(int i=2;i<arr1.length;i++)
        {
            sum =  Math.max(Math.max(sumIncl+arr1[i],sumExcl),sumIncl);
            sumIncl =sumExcl;
            sumExcl = sum;
        }



        return sum;
    }

}
