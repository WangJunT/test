package com.jy.dongtaiguihua.shuangzhizhen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int target = 0;
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> lists1 = twoSum(nums, i + 1, target - nums[i]);
            if (lists1 != null && lists1.size() > 0) {
                for (List<Integer> list : lists1) {
                    list.add(nums[i]);
                }
                lists.addAll(lists1);
            }

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        }
        return lists;
    }

    private static List<List<Integer>> twoSum(int[] nums, int start, int target) {
        int end = nums.length - 1;
        List<List<Integer>> list = new ArrayList<>();
        while (start < end) {
            int result = nums[start] + nums[end];
            if (result == target) {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(nums[start]);
                tmp.add(nums[end]);
                list.add(tmp);
                while (start < nums.length - 1 && nums[start] == nums[start + 1]) start++;
                start++;
                end--;
            } else if (result > target) {
                end--;
            } else {
                start++;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        threeSum(new int[]{-2, 0, 0, 2, 2});
    }
}
