package com.jy.test;


/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。
 * <p>
 *  
 * <p>
 * 示例：
 * <p>
 * 输入：nums = [-1,2,1,-4], target = 1
 * 输出：2
 * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
 * <p>
 * 链接：https://leetcode-cn.com/problems/3sum-closest
 */
public class ClosestTarget {
    public static int threeSumClosest(int[] nums, int target) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int tmp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = tmp;
                }
            }
        }
        int close = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == target) {
                    return sum;
                }
                if (sum < target) {
                    left++;
                }
                if (sum > target) {
                    right--;
                }
                close = Math.abs(close - target) > Math.abs(sum - target) ? sum : close;
            }
        }
        return close;
    }

    public static void main(String[] args) {
        int[] a = {-3,-2,-5,3,-4};
        int target = -1 ;
        threeSumClosest(a,target);
    }
}
