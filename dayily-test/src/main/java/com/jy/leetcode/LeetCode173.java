package com.jy.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LeetCode173 {
    private int index = -1;
    private List<Integer> list = new ArrayList();

    public LeetCode173(TreeNode root) {
        if (root == null) {
            index = 0;
        } else {
            Stack<TreeNode> stack = new Stack<>();
            while (root != null || !stack.isEmpty()) {
                if (root != null) {
                    stack.push(root);
                    root = root.left;
                } else {
                    root = stack.pop();
                    list.add(root.val);
                    root = root.right;
                }
            }
        }
        System.out.println(1);
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(7);
        TreeNode t2 = new TreeNode(3);
        TreeNode t3 = new TreeNode(15);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(20);
        t1.left = t2;
        t1.right = t3;
        t3.left = t4;
        t3.right = t5;
        new LeetCode173(t1);
        System.out.println(1);
    }
    public int next() {
        return 1;
    }

    public boolean hasNext() {
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
