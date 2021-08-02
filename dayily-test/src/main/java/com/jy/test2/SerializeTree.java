package com.jy.test2;

import java.util.*;

public class SerializeTree {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static Queue<String> treeNodeToTree(TreeNode treeNode) {
        Queue<String> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        while (!stack.isEmpty() || treeNode != null) {
            if (treeNode != null) {
                list.add(treeNode.val + "");
                stack.push(treeNode);
                treeNode = treeNode.left;
            } else {
                list.add("xxxxx");
                TreeNode pop = stack.pop();
                treeNode = pop.right;
            }
        }
        list.add("xxxxx");
        return list;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        TreeNode l2 = new TreeNode(2);
        TreeNode l3 = new TreeNode(3);
        TreeNode l4 = new TreeNode(4);
        TreeNode l5 = new TreeNode(5);
        TreeNode l6 = new TreeNode(6);
        treeNode.left = l2;
        treeNode.right = l3;
        l2.left = l4;
        l3.left = l5;
        l3.right = l6;
        Queue<String> list = treeNodeToTree(treeNode);
        TreeNode aaa = listToTreeNode(list);
        System.out.println(1);
    }

    private static TreeNode listToTreeNode(Queue<String> list) {
        if (!list.isEmpty()) {
            String poll = list.poll();
            if (!poll.equals("xxxxx")) {
                TreeNode aaa = new TreeNode(Integer.valueOf(poll));
                aaa.left = listToTreeNode(list);
                aaa.right = listToTreeNode(list);
                return aaa;
            }
        }
        return null;
    }
}
