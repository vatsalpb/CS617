package com.company;

public class MaxSubArray {
    static Value val = new Value();

    public static void main(String[] args) {
        int[] a = {-3, 4, 5, -2, 9, 7, -8, 10};
        Value value = MS1(a);
//        System.out.println(value.leftIndex);
//        System.out.println(value.rightIndex);
//        System.out.println(value.finalAnswer);

        //int[] a = {-3, 4, 5, -2, 9, 7, -8, 10};
        int i = MS3(a, a.length - 1);
        System.out.println(i);

        Value value1 = MS3_2(a, a.length - 1);
        System.out.println(value1.finalAnswer);

        int j = MS4(a, 1);
        System.out.println(j);
    }


    /**
     * @param a
     * @return This runs in N^2
     */
    static Value MS1(int[] a) {
        val.finalAnswer = a[0];
        for (int i = 0; i < a.length; i++) {
            int localSum = 0;
            for (int j = i; j < a.length; j++) {
                localSum += a[j];
                if (val.finalAnswer < localSum) {
                    val.finalAnswer = localSum;
                    val.leftIndex = i;
                    val.rightIndex = j;
                }
            }
        }
        return val;
    }


    /**
     * @param a
     * @return This runs in N^3
     */
    static Value MS2(int[] a) {
        val.finalAnswer = a[0];
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                int localSum = 0;
                for (int k = i; k <= j; k++) {
                    localSum += a[k];
                }
                if (val.finalAnswer < localSum) {
                    val.finalAnswer = localSum;
                    val.leftIndex = i;
                    val.rightIndex = j;
                }

            }
        }

        return val;
    }

    static int MS3(int[] a, int n) {
        //base case
        if (n == 1) {
            return a[1];
        } else {
            int ssum = MS3(a, n - 1);
            int localSum = 0;
            for (int i = n; i >= 1; i--) {
                localSum += a[i];
                if (ssum < localSum) {
                    ssum = localSum;
                }
            }
            return ssum;
        }
    }

    static Value MS3_2(int[] a, int n) {
        //base case
        if (n == 1) {
            val.finalAnswer = a[1];
            val.leftIndex = 1;
            val.rightIndex = 1;
            return val;
        } else // n > 1
        {
            Value value = MS3_2(a, n - 1);
            int localSum = 0;
            for (int i = n; i >= 1; i--) {
                localSum += a[i];
                if (value.finalAnswer < localSum) {
                    value.finalAnswer = localSum;
                    value.leftIndex = i;
                    value.rightIndex = n;
                }
            }
            return value;
        }
    }

    static int MS4(int[] a, int n) {
        if (n == a.length - 1) {
            return a[n];
        } else {
            int ssum = MS4(a, n + 1);
            int localSum = 0;
            for (int i = n; i < a.length; i++) {
                localSum += a[i];
                if(ssum < localSum)
                {
                    ssum = localSum;
                }
            }
            return ssum;
        }
    }
}


class Value {
    int finalAnswer;
    int leftIndex;
    int rightIndex;
}
