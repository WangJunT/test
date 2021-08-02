package com.jy.leetcode;

public class LeetCode162 {
    public static void main(String[] args) {
//        int[] nums = new int[]{1,2,3,1};
//        findPeakElement(nums);
//        System.out.println(1);
        System.out.println(1/2);
    }
    public static int findPeakElement(int[] nums) {
        int left = nums[0];
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1] && nums[mid] < nums[mid - 1]) {
                return mid;
            }
            if (nums[mid] > nums[mid + 1]) {
                left = mid +1;
            } else {
                right = mid -1;
            }
        }
        return nums.length - 1;
    }
}
