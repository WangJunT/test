package com.jy.test2;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

    private static List<List<Integer>> lists = new ArrayList<>();

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        lists = new ArrayList<>();
        for (int i = 0; i < candidates.length; i++) {
            for (int j = i; j < candidates.length; j++) {
                if (candidates[i] > candidates[j]) {
                    int tmp = candidates[i];
                    candidates[i] = candidates[j];
                    candidates[j] = tmp;
                }
            }
        }
        jianzhi(candidates, target, new ArrayList<>(), 0);
        return lists;
    }

    private static void jianzhi(int[] candidates, int target, List<Integer> list, int index) {
        if (target == 0) {
            lists.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) {
                return;
            }
            List<Integer> newList = new ArrayList<>();
            newList.addAll(list);
            newList.add(candidates[i]);
            int asd = target - candidates[i];
            jianzhi(candidates, asd, newList, i);
        }
    }

    public static void main(String[] args) {
        int[] a = {2, 3, 6, 7};
        List<List<Integer>> list = combinationSum(a, 7);
        System.out.println(1);
    }
}
