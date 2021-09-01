package com.jy.dongtaiguihua.erchashu;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
 * <p>
 * 两棵树重复是指它们具有相同的结构以及相同的结点值。
 * https://leetcode-cn.com/problems/find-duplicate-subtrees/
 */
public class FindDuplicateSubtrees {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> list = new LinkedList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traver(root);
        return list;
    }

    private String traver(TreeNode node) {
        if (node == null) {
            return "#";
        }
        String leftString = traver(node.left);
        String rightString = traver(node.right);
        //这里要加逗号，分辨出来，不然有的可能把这里混淆了
        String rootString = leftString + "," + rightString + "," + node.val;
        int orDefault = map.getOrDefault(rootString, 0);
        if (orDefault == 1) {
            list.add(node);
        }
        map.put(rootString, orDefault + 1);
        return rootString;
    }
}
