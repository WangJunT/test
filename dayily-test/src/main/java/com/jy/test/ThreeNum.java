package com.jy.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//三数之和
public class ThreeNum {
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] > 0) {
                return lists;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int right = nums.length - 1;
            int left = i + 1;
            while (left < right) {
                if (nums[left] == nums[left - 1]) {
                    continue;
                }
                if (right <  nums.length - 1 && nums[right] == nums[right + 1]) {
                    continue;
                }
                if ((nums[i] + nums[left] + nums[right]) == 0) {
                    List<Integer> das = new ArrayList<>();
                    das.add(nums[i]);
                    das.add(nums[left]);
                    das.add(nums[right]);
                    lists.add(das);
                } else if ((nums[i] + nums[left] + nums[right]) > 0) {
                    right--;
                } else {
                    left++;
                }
            }
//            for (int j = i + 1; j < nums.length - 1; j++) {
//                for (int k = j + 1; k < nums.length; k++) {
//                    if ((nums[i] + nums[j] + nums[k]) == 0) {
//                        if (map.containsKey(nums[j]) && map.get(nums[j]) == nums[j] + nums[k]) {
//                            continue;
//                        }
//                        map.put(nums[j], nums[j] + nums[k]);
//                        List<Integer> das = new ArrayList<>();
//                        das.add(nums[i]);
//                        das.add(nums[j]);
//                        das.add(nums[k]);
//                        lists.add(das);
//                    }
//                }
//            }
        }
        return lists;
    }

    public static void main(String[] args) {
        int[] a = {0, 0, 0};
        threeSum(a);
    }

}
