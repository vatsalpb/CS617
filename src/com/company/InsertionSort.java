package com.company;

import java.lang.reflect.Array;

public class InsertionSort {

    public static void main(String[] args) {
        // write your code here
        int[]a= {3,7,1,2,8,4,9};
        insertionSort(a);
        for (int z:a) {
            System.out.println(z);
        }
    }

     static void insertionSort(int[] a)
    {
        for (int i = 1; i < a.length;i++)
        {
            int key = a[i];
            int j = i-1;
            while (j >=0 && a[j] > key)
            {
                a[j+1] = a[j];
                j = j -1;
                a[j+1] = key;
            }
        }
    }
}
