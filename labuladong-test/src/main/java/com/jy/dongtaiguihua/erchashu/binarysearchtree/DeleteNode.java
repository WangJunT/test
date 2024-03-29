package com.jy.dongtaiguihua.erchashu.binarysearchtree;

/**
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 *
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。
 *
 * 示例:
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class DeleteNode {
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


    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return root;
        }

        if (root.val == key) {

            if (root.left == null) {

                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //3. 有两个子节点（寻找左边最大子节点，或者右边最小子节点）
            TreeNode treeNode = root.right;
            while (treeNode.left != null) {
                treeNode = treeNode.left;
            }
            root.val = treeNode.val;
            // 转而去删除 minNode
            root.right = deleteNode(root.right, treeNode.val);
            return root;
        }
        //向左
        else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        //向右
        else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }
}
