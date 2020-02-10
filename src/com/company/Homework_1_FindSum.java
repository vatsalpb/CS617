package com.company;

public class Homework_1_FindSum
{
    public static void main(String[] args)
    {
        int[] a = {-1, 3, 4, 10, 18};
        boolean sum = findSum(a, 25);
        System.out.println(sum);
        boolean b = recSum(a, 0, (a.length - 1), 25);
        System.out.println(b);
    }

    private static boolean findSum(int[] sumArray, int s)
    {
       int li = 1;
       int ri = sumArray.length-1;
       while(li < ri)
       {
           if(sumArray[li] + sumArray[ri] == s)
           {
               return  true;
           }
           else if(sumArray[li] + sumArray[ri] > s)
           {
               li++;
           }
           else
           {
               ri--;
           }
       }
       return false;
    }

    private static boolean recSum(int[] sumArray, int li, int ri, int s)
    {
        if (li == ri)
        {
            return false;
        } else
        {
            if (sumArray[li] + sumArray[ri] == s)
            {
                return true;
            } else if (sumArray[li] + sumArray[ri] < s)
            {
                return recSum(sumArray, li + 1, ri, s);
            } else
            {
                return recSum(sumArray, li, ri - 1, s);
            }
        }
    }
}
