package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree
{
    public static void main(String[] args)
    {
        int[] arr = {3, 2, 1, 1, 1};
        arr.length;
        List<int[]> ints = Arrays.asList(arr);
        List<Integer> state = new ArrayList<>();
        state.add()
    }


    static class Node
    {
        int data;
        Node left;
        Node right;
    }


    public static void preOrder(Node root)
    {
        Node pre;
        if (root == null)
            return;
        Node curr = root;
        while (curr != null)
        {
            if (curr.left == null)
            {
                System.out.print(curr.data + " ");
                curr = curr.right;
            } else
            {
                pre = curr.left;
                while (pre.right != null && pre.right != curr)
                {
                    pre = pre.right;
                }
                if (pre.right == null)
                {
                    pre.right = curr;
                    System.out.print(curr.data + " ");
                    curr = curr.left;
                } else
                {
                    pre.right = null;
                    curr = curr.right;
                }
            }
        }
    }
}
