package com.jy.dongtaiguihua.erchashu.binarysearchtree;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public class MaxSumBST {
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

    // 全局变量，记录 BST 最大节点之和
    static int maxSum = 0;

    /* 主函数 */
    public static int maxSumBST(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    /* 遍历二叉树 */
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        /******* 前序遍历位置 *******/
        // 判断左右子树是不是 BST
        if (!isBST(root.left) || !isBST(root.right)) {
//            goto next;
            traverse(root.left);
            traverse(root.right);
            return;
        }
        // 计算左子树的最大值和右子树的最小值
        int leftMax = findMax(root.left);
        int rightMin = findMin(root.right);
//        if (root.left == null && root.right == null) {
//            maxSum = Math.max(maxSum, root.val);
//            return;
//        }
//        if (root.left == null || root.right == null) {
//            maxSum = Math.max(maxSum, root.val);
//            return;
//        }
        // 判断以 root 节点为根的树是不是 BST
        if (root.val <= leftMax || root.val >= rightMin) {
            traverse(root.left);
            traverse(root.right);
            return;
        }
        // 如果条件都符合，计算当前 BST 的节点之和
        int leftSum = findSum(root.left);
        int rightSum = findSum(root.right);
        int rootSum = leftSum + rightSum + root.val;
        // 计算 BST 节点的最大和
        maxSum = Math.max(maxSum, rootSum);
        /**************************/
        // 递归左右子树
//        next:
        traverse(root.left);
        traverse(root.right);
    }

    //计算以 root 为根的二叉树的最大值
    static int findMax(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        TreeNode tmp = root;
        while (tmp.right != null) {
            tmp = tmp.right;
        }
        return tmp.val;
    }

    //计算以 root 为根的二叉树的最小值
    static int findMin(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        TreeNode tmp = root;
        while (tmp.left != null) {
            tmp = tmp.left;
        }
        return tmp.val;
    }

    //计算以 root 为根的二叉树的节点和
    static int findSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        Queue<TreeNode> queue = new LinkedBlockingQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode tmp = queue.poll();
            sum += tmp.val;
            if (tmp.left != null) {
                queue.offer(tmp.left);
            }
            if (tmp.right != null) {
                queue.offer(tmp.right);
            }
        }
        return sum;
    }

    //判断以 root 为跟的二叉树是否是 BST
    static boolean isBST(TreeNode root) {
        return isBSTExtend(root, null, null);
    }

    private static boolean isBSTExtend(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (root.left != null && root.val <= root.left.val) {
            return false;
        }
        if (root.right != null && root.val >= root.right.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isBSTExtend(root.left, min, root) && isBSTExtend(root.right, root, max);
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(2);
        node1.left = node2;
        node2.left = node3;
        node2.right = node4;
        maxSumBST(node1);
    }
}
