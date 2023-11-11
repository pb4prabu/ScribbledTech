package com.scribbledtech.praveen.algorithms;

import java.util.Arrays;

public class QuickSort {

    static int count=0;
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8};
        quick(0, arr.length-1, arr);

        Arrays.stream(arr).forEach(i->System.out.print(i));
        System.out.println();
        System.out.println(count);

    }

    private static void quick(int start, int end, int arr[]) {
        if (start < end) {
            int pos = partition(start, end, arr);
            if(pos==-1)
            {
                return;
            }
            quick(start, pos - 1, arr);
            quick(pos + 1, end, arr);
        }
    }

    private static int partition(int start, int end, int[] arr) {
        count++;
        int j = start-1;
        boolean flag=true;
        int pivot = arr[end];
        for (int i = start; i < end; i++) {
            if (arr[i] < pivot) {
                j++;
                swap(arr, i, j);
            }
            else
            {
                flag=false;
            }
        }
        if(flag)
        {
            return -1;
        }
        swap(arr, end , j + 1);
        return j + 1;
    }

    private static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
    }
}
