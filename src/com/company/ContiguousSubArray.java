package com.company;

public class ContiguousSubArray {
    public static void main(String[] args) {
        // write your code here
        int[] a = {3, 7, 1, 2, 8, 4, 9};
        int i = contiguousSubArray(a);
        System.out.println(i);
        int i1 = contiguousSubArray2(a);
        System.out.println(i1);
    }
    /**
     *
     * @param a an array with numbers
     * @return max continous value.
     * runs in N^2
     */
    static int contiguousSubArray(int[] a) {
        int max = a[0];
        for (int i = 0 ; i < a.length ; i++)
        {
            int sum = 0;
            for (int j = i; j < a.length ; j++)
            {
                sum = sum + a[j];
                if(sum > max)
                {
                    max = sum;
                }
            }
        }
        return  max;
    }

    /**
     *
     * @param a an array with numbers
     * @return max continous value.
     * runs in N^3
     */
    static int contiguousSubArray2(int[] a)
    {
        int max = a[1];
        for (int i = 0 ; i < a.length ; i++)
        {
            for (int j = i; j < a.length ; j++)
            {
                int sum = 0;
                for (int k = i; k <= j ; k++)
                sum = sum + a[k];
                if(sum > max)
                {
                    max = sum;
                }
            }
        }

        return max;
    }
}
