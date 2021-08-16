package com.jy.dongtaiguihua;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MinDepth {
    static class TreeNode {
        TreeNode() {

        }

        TreeNode leftNode;
        TreeNode rightNode;
        int val;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(TreeNode leftNode, TreeNode rightNode, int val) {
            this.leftNode = leftNode;
            this.rightNode = rightNode;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        int i = minDepth(treeNode);
    }

    private static int minDepth(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.min(minDepth(treeNode.rightNode)+1, minDepth(treeNode.leftNode)+1);
    }
}
