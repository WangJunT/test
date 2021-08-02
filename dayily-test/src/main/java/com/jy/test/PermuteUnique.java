package com.jy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//全排列
public class PermuteUnique {
    private List<List<Integer>> list;

    public List<List<Integer>> permuteUnique(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] < nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        list = new ArrayList();
        boolean[] flags = new boolean[nums.length];
        digui(nums, new ArrayList<Integer>(), flags);
        return list;
    }

    private void digui(int[] nums, List<Integer> listaa, boolean[] flags) {
        if (listaa.size() == nums.length) {
            list.add(listaa);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!flags[i]) {
                List<Integer> newList = new ArrayList(listaa);
                newList.add(nums[i]);
                boolean[] newFlag = Arrays.copyOf(flags, nums.length);
                newFlag[i] = true;
            }
        }
    }
}
