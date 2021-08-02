package com.jy.test2;

public class ChildTreeNode {
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
        TreeNode t3 = new TreeNode(7);
        TreeNode t4 = new TreeNode(9);
        TreeNode t5 = new TreeNode(2);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(7);
        t1.leftNode = t2;
        t1.rightNode = t3;
        t2.leftNode = t4;
        t2.rightNode = t5;
        t5.leftNode = t6;
        t5.rightNode = t7;
        TreeNode t8 = new TreeNode(8);
        TreeNode t9 = new TreeNode(9);
        TreeNode t10 = new TreeNode(2);
        t8.leftNode = t9;
        t8.rightNode = t10;
        boolean flag = isContain(t1, t8);
        System.out.println(flag);
    }

    private static boolean isContain(TreeNode root, TreeNode root2) {
        if (root2 == null) {
            return true;
        }
        if (root == null) {
            return false;
        }
        boolean flag = false;
        if (root.val == root2.val) {
            flag = isContain(root.leftNode, root2.leftNode) && isContain(root.rightNode, root2.rightNode);
        }
        if (!flag) {
            flag = isContain(root.leftNode, root2) || isContain(root.rightNode, root2);
        }
        return flag;
    }

}
