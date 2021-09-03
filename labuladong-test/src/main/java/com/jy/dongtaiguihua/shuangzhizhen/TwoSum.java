package com.jy.dongtaiguihua.shuangzhizhen;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 双指针技巧：
 * 快慢指针：链表的环，链表的环的位置，删除链表第n个节点
 * 左右指针：二分查找，两数之和（已排序），反转字符
 */
public class TwoSum {
    //未排序
    public int[] twoSum(int[] nums, int target) {
        int[] intaaa = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target-nums[i])) {
                intaaa[0] = map.get(target-nums[i]);
                intaaa[1] = i;
                return intaaa;
            } else {
                map.put(nums[i],i);
            }
        }

        return intaaa;
    }

    public static void main(String[] args) {
        int[] numbers = {1, 3};
        int target = 9;
        int[] intaaa = new int[2];
        Map<Integer, Integer> map = new HashMap();
        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target-numbers[i])) {
                intaaa[0] = map.get(target-numbers[i]);
                intaaa[1] = i;
                return;
            }
        }
    }
}
