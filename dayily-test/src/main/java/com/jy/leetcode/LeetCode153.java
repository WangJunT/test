package com.jy.leetcode;

public class LeetCode153 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 5, 6, 7, 8, 9};
        findMin(nums);
        System.out.println(1);
    }

    public static int erfen(int[] nums) {
        return 1;
    }

    public static int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[left] > nums[mid]) {
                if (nums[right] > nums[mid]) {
                    right = mid+1;
                } else {
                    left = mid+1;
                }
            } else {
                left = mid+1;
            }
        }
        return nums[mid];
    }
}
