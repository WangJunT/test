package com.jy.dongtaiguihua.erchashu;

public class InvertTree {
    static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public TreeNode invertTree(TreeNode root) {
        if (root == null || (root.leftNode == null && root.rightNode == null)) {
            return root;
        }
        TreeNode leftNode = root.leftNode;
        root.leftNode = invertTree(root.rightNode);
        root.rightNode = invertTree(leftNode);
        return root;
    }

    public static void main(String[] args) {

    }
}
