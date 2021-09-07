package com.jy.dongtaiguihua.erchashu.binarysearchtree;

/**
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 */
public class NumTrees {
    public static int numTrees(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int sum = 0;
            for (int j = 1; j <= i; j++) {
                sum += dp[j - 1] * dp[i - j];
            }
            dp[i] = sum;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        int i = numTrees(3);
        System.out.println(1);
    }
}
