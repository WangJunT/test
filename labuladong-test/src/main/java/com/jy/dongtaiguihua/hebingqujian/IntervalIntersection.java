package com.jy.dongtaiguihua.hebingqujian;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class IntervalIntersection {
    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。
     * 请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        int last = -1;
        int[] aa = new int[2];
        for (int i = 0; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (tmp[0] < last) {
                last = tmp[1];
            } else {
                if (last != -1) {
                    int[] cm = Arrays.copyOf(aa, aa.length);
                    list.add(cm);
                }
                aa[0] = tmp[0];
                aa[1] = tmp[1];
                last = tmp[1];
            }
        }
        int[][] result = new int[list.size()][2];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }

    /**
     * 给你一个区间列表，请你删除列表中被其他区间所覆盖的区间。
     * <p>
     * 只有当 c <= a 且 b <= d 时，我们才认为区间 [a,b) 被区间 [c,d) 覆盖。
     * <p>
     * 在完成所有删除操作后，请你返回列表中剩余区间的数目。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-covered-intervals
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @return
     */
    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        // 1. 按区间左端点排序
        Arrays.sort(intervals, (int[] interval1, int[] interval2) -> (interval1[0] - interval2[0]));
//        Arrays.sort(intervals, Comparator.comparingInt((int[] interval) -> interval[0]));
        List<int[]> list = new ArrayList<>();
        int[] aa = intervals[0];
        int count = 0;
        for (int i = 1; i < intervals.length; i++) {
            int[] tmp = intervals[i];
            if (tmp[0] >= aa[0] && tmp[1] <= aa[1]) {
                count++;
            } else {
                aa = tmp;
            }
        }
        return intervals.length - count;
    }

    /**
     * 给定两个由一些 闭区间 组成的列表，firstList 和 secondList ，其中 firstList[i] = [starti, endi] 而 secondList[j] = [startj, endj] 。每个区间列表都是成对 不相交 的，并且 已经排序 。
     * <p>
     * 返回这 两个区间列表的交集 。
     * <p>
     * 形式上，闭区间 [a, b]（其中 a <= b）表示实数 x 的集合，而 a <= x <= b 。
     * <p>
     * 两个闭区间的 交集 是一组实数，要么为空集，要么为闭区间。例如，[1, 3] 和 [2, 4] 的交集为 [2, 3] 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/interval-list-intersections
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }
        int i = 0, j = 0;
        List<int[]> list = new ArrayList<>();
        while (i < firstList.length && j < secondList.length) {
            //没有交集 的情况
            if (firstList[i][0] > secondList[j][1] || firstList[i][1] < secondList[j][9]) {
            } else {
                int[] aa = new int[2];
                aa[0] = Math.max(firstList[i][0], secondList[j][0]);
                aa[1] = Math.min(firstList[i][1], secondList[j][1]);
                list.add(aa);
            }
            //谁小谁往前进
            if (firstList[i][1] > secondList[j][1]) {
                j++;
            } else {
                i++;
            }
        }
        return list.toArray(new int[list.size()][2]);
    }

    public static void main(String[] args) {

    }
}
