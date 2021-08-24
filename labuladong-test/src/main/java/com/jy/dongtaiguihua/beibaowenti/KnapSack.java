package com.jy.dongtaiguihua.beibaowenti;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 给你一个可装载重量为 W 的背包和 N 个物品，每个物品有重量和价值两个属性。
 * 其中第 i 个物品的重量为 wt[i]，价值为 val[i]，现在让你用这个背包装物品，
 * 最多能装的价值是多少？
 */
public class KnapSack {
    static int max = 0;

    static int knapsack(int w, int n, int[] wt, int[] val) {
        for (int i = 0; i < n; i++) {
            if (wt[i] > w) {
                continue;
            }
            boolean[] flag = new boolean[n];
            flag[i] = true;
            int sumW = wt[i];
            int sumN = val[i];
            knapsackDP(w, n, wt, val, flag, sumW, sumN, 1);
        }
        System.out.println(max);
        return max;
    }

    private static void knapsackDP(int w, int n, int[] wt, int[] val, boolean[] flag, int sumW, int sumN, int length) {
//        if (length >= n || sumW >= w) {
//            aa.add(sumN);
//            return;
//        }
        for (int i = 0; i < n; i++) {
            if (flag[i]) {
                continue;
            }
            if (wt[i] + sumW > w) {
                max = (max > sumN) ? max : sumN;
                continue;
            }
            boolean[] newFlag = Arrays.copyOf(flag, n);
            newFlag[i] = true;
            knapsackDP(w, n, wt, val, newFlag, wt[i] + sumW, val[i] + sumN, length + 1);
        }
    }

    public static void main(String[] args) {
        int n = 3, w = 4;
        int[] wt = {2, 1, 3};
        int[] val = {4, 2, 3};
        knapsack(w, n, wt, val);
    }
}
