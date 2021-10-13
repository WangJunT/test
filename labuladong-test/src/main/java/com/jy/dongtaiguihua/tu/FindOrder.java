package com.jy.dongtaiguihua.tu;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class FindOrder {
    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer>[] list = new LinkedList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            list[i] = new LinkedList<>();
        }
        for (int[] tmp : prerequisites) {
            int to = tmp[0];
            int from = tmp[1];
            list[from].add(to);
        }
        boolean flag = canFinish(list, numCourses, prerequisites);
        if (!flag) {
            return new int[]{};
        }
        visitOrder = new boolean[numCourses];
        integerList = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            orderTraverse(i, list);
        }
        int[] result = new int[numCourses];
        Collections.reverse(integerList);
        for (int i = 0; i < numCourses; i++) {
            result[i] = integerList.get(i);
        }
        return result;
    }

    private static void orderTraverse(int i, List<Integer>[] list) {
        if (visitOrder[i]) {
            return;
        }
        visitOrder[i] = true;
        for (int t : list[i]) {
            orderTraverse(t, list);
        }
        integerList.add(i);
    }

    static boolean canFin = true;
    static List<Integer> integerList = new LinkedList<>();
    static boolean[] visit;
    static boolean[] visitOrder;
    static boolean[] trace;

    private static boolean canFinish(List<Integer>[] list, int numCourses, int[][] prerequisites) {
        visit = new boolean[numCourses];
        trace = new boolean[numCourses];
        for (int i = 0; i < numCourses; i++) {
            traverse(i, list);
        }
        return canFin;
    }

    private static void traverse(int i, List<Integer>[] integers) {
        if (trace[i]) {
            canFin = false;
            return;
        }
        if (visit[i]) {
            return;
        }
        trace[i] = true;
        visit[i] = true;
        for (int i1 : integers[i]) {
            traverse(i1, integers);
        }
        trace[i] = false;
    }


    public static void main(String[] args) {

//        int[][] arr = {{0, 10}, {3, 18},{6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};
        int[][] arr = {{1, 0}};
        int[] aaa = findOrder(2, arr);
        System.out.println(1);
    }
}
