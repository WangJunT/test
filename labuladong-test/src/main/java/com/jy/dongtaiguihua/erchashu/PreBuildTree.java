package com.jy.dongtaiguihua.erchashu;

import java.util.Arrays;

/**
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 */
public class PreBuildTree {
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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0||inorder.length==0){
            return null;
        }
        if (preorder.length == 1) {
            TreeNode root = new TreeNode(preorder[0]);
            return root;
        }
        int rootval = preorder[0];
        int preindex = 0;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == rootval) {
                preindex = i;
                break;
            }
        }
        TreeNode root = new TreeNode(rootval);
            root.left = buildTree(Arrays.copyOfRange(preorder, 1, preindex + 1), Arrays.copyOfRange(inorder, 0, preindex));
            root.right = buildTree(Arrays.copyOfRange(preorder, preindex + 1, preorder.length), Arrays.copyOfRange(inorder, preindex + 1, inorder.length));
        return root;
    }

}
