package com.jy.leetcode;


public class Leetcode152 {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-3,-2};
        System.out.println(maxProductTwo(nums));
    }

    //方法1 自己
    public static int maxProduct(int[] nums) {
        int max = nums[0];
        int last = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int tmp = nums[j] * last;
                max = max > tmp ? max : tmp;
                last = tmp;
            }
            last = 1;
        }
        return max;
    }

    //方法2 答案
    public static int maxProductTwo(int[] nums) {
        int lastMax = nums[0];
        int lastMin = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int newlastMax = Math.max(lastMax * nums[i], Math.max(lastMin * nums[i], nums[i]));
            int newlastMin = Math.min(lastMax * nums[i], Math.min(lastMin * nums[i], nums[i]));
            lastMax = newlastMax;
            lastMin = newlastMin;
            max = max > lastMax ? max : lastMax;
        }
        return max;
    }
}
