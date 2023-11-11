package com.scribbledtech.praveen.algorithms;

public class FindTwoDuplicatesXor {
    public static void main(String[] args) {
        findDuplicates(new int[]{5, 2, 4, 1, 2, 3, 1});
    }
    private static void findDuplicates(int arr[])
    {
        int xorAll =0;
        for(int i=0;i<arr.length;i++)
        {
            if(i<arr.length-2)
            {
                xorAll = xorAll^(i+1);
            }
           
            xorAll = xorAll^arr[i];
        }
        //keep only the first set bit as 1 and remaining all 0
        
        int setBit = xorAll & ~(xorAll-1);
        int xorA=0;
        int xorB=0;
        for(int i=0;i<arr.length;i++) {
            if (i < arr.length - 2) {
                if (((i + 1) & setBit) == 0) {

                    xorA = xorA ^ (i + 1);
                } else {
                    xorB = xorB ^ (i + 1);
                }
            }
            if ((arr[i] & setBit) == 0) {

                xorA = xorA ^ arr[i];
            } else {
                xorB = xorB ^ arr[i];
            }
        }
  System.out.print("A : "+xorA+ "  B : "+xorB);

    }
}
