package com.company;

import java.util.Arrays;

public class InversionCount
{
    public static void main(String[] args)
    {
        int[] a = {3, 4, -1, 2, 3, 10, 8};
        int arr[] = {1, 20, 6, 4, 5};
        int i = inversionBruteForce(arr);

        System.out.println(i);

        System.out.println(mergeSortAndCount(arr, 0, arr.length - 1));
    }

    static int inversionBruteForce(int[] a)
    {
        int total = 0;
        for (int i = 0; i < a.length; i++)
        {
            for (int j = i; j < a.length; j++)
            {
                if (a[i] > a[j])
                {
                    total++;
                }
            }
        }
        return total;
    }

    // Function to count the number of inversions
    // during the merge process
    private static int mergeAndCount(int[] arr, int l, int m, int r)
    {

        // Left subarray
        int[] left = Arrays.copyOfRange(arr, l, m + 1);

        // Right subarray
        int[] right = Arrays.copyOfRange(arr, m + 1, r + 1);

        int i = 0, j = 0, k = l, swaps = 0;

        while (i < left.length && j < right.length)
        {
            if (left[i] <= right[j])
                arr[k++] = left[i++];
            else
            {
                arr[k++] = right[j++];
                swaps += (m + 1) - (l + i);
            }
        }

        // Fill from the rest of the left subarray
        while (i < left.length)
            arr[k++] = left[i++];

        // Fill from the rest of the right subarray
        while (j < right.length)
            arr[k++] = right[j++];

        return swaps;
    }

    // Merge sort function
    private static int mergeSortAndCount(int[] arr, int l, int r)
    {

        // Keeps track of the inversion count at a
        // particular node of the recursion tree
        int count = 0;

        if (l < r)
        {
            int m = (l + r) / 2;

            // Total inversion count = left subarray count
            // + right subarray count + merge count

            // Left subarray count
            count += mergeSortAndCount(arr, l, m);

            // Right subarray count
            count += mergeSortAndCount(arr, m + 1, r);

            // Merge count
            count += mergeAndCount(arr, l, m, r);
        }

        return count;
    }

}
