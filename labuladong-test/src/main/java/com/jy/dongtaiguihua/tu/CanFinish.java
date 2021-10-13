package com.jy.dongtaiguihua.tu;

import java.util.LinkedList;
import java.util.List;

/**
 * 你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
 *
 * 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表示如果要学习课程 ai 则 必须 先学习课程  bi 。
 *
 * 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。
 * 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/course-schedule
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CanFinish {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        canfinish = true;
        visit = new boolean[numCourses];
        isTraverse = new boolean[numCourses];
        List<Integer>[] list = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new LinkedList<>();
        }
        for (int tmp[] : prerequisites) {
            // 修完课程 from 才能修课程 to
            // 在图中添加一条从 from 指向 to 的有向边
            int from = tmp[1];
            int to = tmp[0];
            list[from].add(to);
        }
        for (int i = 0; i < numCourses; i++) {
            // 遍历图中的所有节点
            traverse(i,list);
        }
        return canfinish;
    }
    //记录是否遍历过
    private static boolean[] visit;
    //记录一次 traverse 递归经过的节点
    private static boolean[] isTraverse;
    // 记录图中是否有环
    private static boolean canfinish;

    private static void traverse(int i, List<Integer>[] list) {
        if (isTraverse[i]) {
            canfinish = false;
            return;
        }
        if (visit[i]){
            return;
        }
        isTraverse[i] = true;
        visit[i]  =true;
        for (int tmp : list[i]) {
            traverse(tmp, list);
        }
        isTraverse[i] = false;
    }

    public static void main(String[] args) {
//        int[][] arr = {{1, 0}};

//        int[][] arr = {{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        int[][] arr = {{1, 0}};
        boolean b = canFinish(2, arr);
        System.out.println(1);
    }
}
