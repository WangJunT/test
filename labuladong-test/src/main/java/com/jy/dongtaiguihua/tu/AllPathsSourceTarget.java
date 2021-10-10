package com.jy.dongtaiguihua.tu;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个有 n 个节点的 有向无环图（DAG），请你找出所有从节点 0 到节点 n-1 的路径并输出（不要求按特定顺序）
 *
 * 二维数组的第 i 个数组中的单元都表示有向图中 i 号节点所能到达的下一些节点，空就是没有下一个结点了。
 *
 * 译者注：有向图是有方向的，即规定了 a→b 你就不能从 b→a 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class AllPathsSourceTarget {
    static List<List<Integer>> lists;

    public static List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        lists = new ArrayList<>();
        int row = graph.length;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        traverse(graph, row - 1, list, 0);
        return lists;
    }

    /**
     * @param graph 图
     * @param n     终点
     * @param list  路径
     * @param i     当前路径上的节点
     */
    private static void traverse(int[][] graph, int n, List<Integer> list, int i) {
        if (n == i) {
            lists.add(list);
            return;
        }
        for (int m = 0; m < graph[i].length; m++) {
            List<Integer> mp = new ArrayList<>(list);
            mp.add(graph[i][m]);
            traverse(graph, n, mp, graph[i][m]);
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        allPathsSourceTarget(graph);
        System.out.println(1);
    }
}
