package com.scribbledtech.praveen.algorithms;

public class PaintingTheFence {
    /*
    You are painting a fence of n posts with k different colors. You must paint the posts following these rules:
    Every post must be painted exactly one color.
    There cannot be three or more consecutive posts with the same color.
    Given the two integers n and k, return the number of ways you can paint the fence.

    Example 1:
    Input: n = 3, k = 2
    Output: 6
    Explanation: All the possibilities are shown.
    Note that painting all the posts red or all the posts green is invalid because there cannot be three posts in a row with the same color.

    Example 2:
    Input: n = 1, k = 1
    Output: 1

    Example 3:
    Input: n = 7, k = 2
    Output: 42

*/
    public static void main(String[] args) {
       System.out.println(new PaintingTheFence().numWays(3,3));
    }
    int maxPost ;
    int maxColour;
    int maxSame =3;
    public int numWays(int n, int k) {
//        maxPost =n;
//        maxColour=k;
//       return  numWays2(0,0,0);
        if (n == 1) return k;
        if (n == 2) return k * k;


        int prevPrev = k;
        int prev = k * k;
        int totalWays=prev;

        for (int i = 3; i <= n; i++) {
            totalWays =  prevPrev*(k-1) + prev*(k-1); // prevPrev*(k-1) , I uses same colour as i-1 that is the possibility of i-2 uses different colour than i-1  + prev*(k-1) --> if i uses different colour as i-1
            prevPrev= prev;
            prev=totalWays;
        }

        return totalWays;
    }


}
