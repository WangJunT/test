package com.jy.dongtaiguihua.erchashu.binarysearchtree;

import java.util.Stack;

public class ConvertBST {
    public class TreeNode {
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

    private int total = 0;

    public TreeNode convertBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        TreeNode head = root;
        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.push(root);
                root = root.right;
            } else {
                TreeNode tmp = stack.pop();
                total += tmp.val;
                tmp.val = total;
                root = tmp.left;
            }
        }
        return head;
    }
}
