package com.jy.test2;

import java.util.*;

public class PrintTreeNode {
    static class TreeNode {
        int val;
        TreeNode leftTreeNode;
        TreeNode rightTreeNode;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    static Queue<TreeNode> queue = new LinkedList();

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode l1 = new TreeNode(6);
        TreeNode l2 = new TreeNode(10);
        TreeNode l3 = new TreeNode(5);
        TreeNode l4 = new TreeNode(7);
        TreeNode l5 = new TreeNode(9);
        TreeNode l6 = new TreeNode(11);
        root.leftTreeNode = l1;
        root.rightTreeNode = l2;

        l1.leftTreeNode = l3;
        l1.rightTreeNode = l4;

        l2.leftTreeNode = l5;
        l2.rightTreeNode = l6;
        printNode(root);
//        queue.add(root);
//        while (!queue.isEmpty()) {
//            TreeNode poll = queue.poll();
//            System.out.print(poll.val + " ");
//            if (poll.leftTreeNode != null) {
//                queue.add(poll.leftTreeNode);
//            }
//            if (poll.rightTreeNode != null) {
//                queue.add(poll.rightTreeNode);
//            }
//        }
    }

    private static void printNode(TreeNode root) {
        if (root == null) {
            return;
        }
        int current = 1;
        int next = 0;
        Stack<TreeNode>[] aa = new Stack[2];
        aa[next] = new Stack<>();
        aa[current] = new Stack<>();
        aa[current].push(root);
        while (!aa[current].isEmpty()) {
            TreeNode pop = aa[current].pop();
            System.out.print(pop.val+ "，");
            if (current % 2 != 0) {
                if (pop.leftTreeNode != null) {
                    aa[next].push(pop.leftTreeNode);
                }
                if (pop.rightTreeNode != null) {
                    aa[next].push(pop.rightTreeNode);
                }
            } else {
                if (pop.rightTreeNode != null) {
                    aa[next].push(pop.rightTreeNode);
                }
                if (pop.leftTreeNode != null) {
                    aa[next].push(pop.leftTreeNode);
                }
            }
            if (aa[current].isEmpty()) {
                System.out.println(" ");
                current = 1 - current;
                next = 1 - next;
            }
        }

    }
}
