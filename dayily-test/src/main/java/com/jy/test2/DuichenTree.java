package com.jy.test2;

public class DuichenTree {
    static class TreeNode {
        int val;
        TreeNode leftNode;
        TreeNode rightNode;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(8);
        TreeNode t2 = new TreeNode(8);
        TreeNode t3 = new TreeNode(8);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(3);
        t1.leftNode = t2;
        t1.rightNode = t3;
        t2.leftNode = t4;
        t2.rightNode = t5;
        t3.leftNode = t6;
        t3.rightNode = t7;
        boolean flag = isduichen(t1);
        System.out.println(flag);
    }

    private static boolean isduichen(TreeNode t1) {
        if (t1 == null) {
            return false;
        }
        if (t1.leftNode == null || t1.rightNode == null) {
            return false;
        }
        if (t1.leftNode.val != t1.rightNode.val) {
            return false;
        }
        return digui(t1.leftNode, t1.rightNode);
    }

    private static boolean digui(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null) {
            return true;
        }
        if (r1 == null || r2 == null) {
            return false;
        }
        boolean flag = true;
        if (r1.leftNode == null && r2.rightNode == null) {

        } else if (r1.leftNode == null || r2.rightNode == null) {
            return false;
        } else if (r1.leftNode.val != r2.rightNode.val) {
            return false;
        }
        flag = digui(r1.leftNode, r2.rightNode);
        if (!flag) {
            return false;
        }

        if (r1.rightNode == null && r2.leftNode == null) {

        } else if (r1.rightNode == null || r2.leftNode == null) {
            return false;
        } else if (r1.rightNode.val != r2.leftNode.val) {
            return false;
        }
        return digui(r1.rightNode, r2.leftNode);
    }
}
