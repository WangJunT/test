package com.jy.dongtaiguihua.erchashu.binarysearchtree;

/**
 * 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/insert-into-a-binary-search-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class InsertIntoBST {
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
    TreeNode head = null;
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (null == root) {
            TreeNode treeNode = new TreeNode(val);
            return treeNode;
        }
        if (null == head) {
            head = root;
        }
        if (root.val > val) {
            if (root.left!=null) {
                return insertIntoBST(root.left, val);
            } else {
                root.left = new TreeNode(val);
                return head;
            }
        } else {
            if (root.right!=null) {
                return insertIntoBST(root.right, val);
            } else {
                root.right = new TreeNode(val);
                return head;
            }
        }
    }
}
