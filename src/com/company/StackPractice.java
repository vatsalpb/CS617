package com.company;

import java.util.Stack;

public class StackPractice
{
    public static void main(String[] args)
    {
        int[] arr = {3, 2, 1, 1, 1};
        int[] arr2 = {4, 3, 2};
        int[] arr3 = {1, 1, 4, 1};

        int i = equalStacks(arr, arr2, arr3);
        System.out.println(i);
        int[] a = {4, 2, 4, 6, 1};
        int[] b = {2, 1, 8, 5};
        int i1 = twoStacks(10, a, b);
        System.out.println(i1);
    }


    /*
     * Complete the twoStacks function below.
     */
    static int twoStacks(int x, int[] a, int[] b)
    {
        /*
         * Write your code here.
         */

        Stack<Integer> stackA = new Stack<>();
        Stack<Integer> stackB = new Stack<>();

        for (int i = a.length - 1; i >= 0; i--)
        {
            stackA.add(a[i]);
        }
        for (int i = b.length - 1; i >= 0; i--)
        {
            stackB.add(b[i]);
        }
        int count = 0;
        int total = 0;

        while (x > total)
        {
            total += stackA.peek();
            if (x < total)
            {
                break;
            }
            stackA.pop();
            count++;

            total += stackB.peek();
            if (x < total)
            {
                break;
            }
            stackB.pop();
            count++;
        }

        return count;
    }

    static int equalStacks(int[] h1, int[] h2, int[] h3)
    {
        /*
         * Write your code here.
         */
        int min = Math.min(h1.length, h2.length);
        min = Math.min(h3.length, min);
        int h1Count = 0;
        int h2Count = 0;
        int h3Count = 0;

        Stack<Integer> h1Stack = new Stack<>();
        Stack<Integer> h2Stack = new Stack<>();
        Stack<Integer> h3Stack = new Stack<>();
        for (int i = h1.length - 1; i >= 0; i--)
        {

            h1Stack.add(h1[i]);
            h1Count += h1[i];
        }

        for (int i = h2.length - 1; i >= 0; i--)
        {
            h2Stack.add(h2[i]);
            h2Count += h2[i];
        }

        for (int i = h3.length - 1; i >= 0; i--)
        {
            h3Stack.add(h3[i]);
            h3Count += h3[i];
        }

        while (h1Count != h2Count || h2Count != h3Count)
        {
            if (h1Count < h2Count)
            {
                h2Count -= h2Stack.peek();
                h2Stack.pop();
            }
            if (h1Count < h3Count)
            {
                h3Count -= h3Stack.peek();
                h3Stack.pop();
            }
            if (h2Count < h1Count)
            {
                h1Count -= h1Stack.peek();
                h1Stack.pop();
            }
            if (h2Count < h3Count)
            {
                h3Count -= h3Stack.peek();
                h3Stack.pop();
            }
            if (h3Count < h1Count)
            {
                h1Count -= h1Stack.peek();
                h1Stack.pop();
            }
            if (h3Count < h2Count)
            {
                h2Count -= h2Stack.peek();
                h2Stack.pop();
            }


        }
        return h1Count;


    }
}
