package com.jy.dongtaiguihua.huisusuanfa;

import java.util.ArrayList;
import java.util.List;

//全排列代码
//https://labuladong.gitee.io/algo/1/4/
public class Permute {
    private static List<List<Integer>> numsList = new ArrayList<>();

    public static void permute(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            List<Integer> list = new ArrayList<>();
            boolean[] flag = new boolean[nums.length];
            flag[i] = true;
            list.add(nums[i]);
            digui(list, flag, nums);
        }
    }

    private static void digui(List<Integer> list, boolean[] flag, int[] nums) {
        if (list.size() >= nums.length) {
            List<Integer> tmp = new ArrayList<>(list);
            numsList.add(tmp);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (flag[i] == true) {
                continue;
            }
            flag[i] = true;
            list.add(nums[i]);
            digui(list, flag, nums);
            flag[i] = false;
            list.remove(list.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        permute(nums);
        System.out.println(1);
    }
}
