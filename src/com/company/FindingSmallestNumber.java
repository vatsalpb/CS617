package com.company;

public class FindingSmallestNumber
{
    public static void main(String[] args)
    {
        int[] a = {4, 3, 2, 1, 0, 5, 9, 10};
        //int fs = FS(a, 0, a.length - 1);
        System.out.println(FS_1(a));
        System.out.println(9/2);
    }

    //This is the recursive version of find the smallest number.
    static int FS(int[] a, int li, int ri)
    {
        if (li == ri)
        {
            return a[li];
        } else
        {
            //integer division
            int mid = (li + ri) / 2;
            if (a[mid] < a[mid + 1])
            {
                return FS(a, li, mid);
            } else //a[mid] > a[mid+1]
            {
                return FS(a, mid + 1, ri);
            }
        }
    }

    static int FS_1(int[] a)
    {
        int li = 0;
        int ri = a.length - 1;
        while (li < ri)
        {
            int mid = (li + ri) / 2;
            if (a[mid] < a[mid + 1])
            {
                ri = mid;
            } else
            {
                li = mid + 1;
            }
        }
        return a[li];
    }
}
