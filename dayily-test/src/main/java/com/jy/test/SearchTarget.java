package com.jy.test;

//题目说复杂度必须在 O(log n) 级别。那么就要折半查找
//取中间的值与目标值比较大小
// 如果中间的值小于目标值（判断中间值是不是最大的。即是否是临界点）
// 判断中间值是处于临界值之前还是之后，只需要判断中间值和最右边值的大小，如果大于最右边值，则把最左边的值挪到中间值之后，（因为此时中间值之前是顺序递增的）
public class SearchTarget {
    public static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            if (nums[low] == target) {
                return low;
            }
            if (nums[high] == target) {
                return high;
            }
            int midum = (high + low) / 2;
            if (nums[midum] == target) {
                return midum;
            }
            if (nums[midum] < target) {
                if (nums[midum] > nums[high] && (midum + 1) < nums.length && nums[midum] > nums[midum + 1]) {
                    return -1;
                }
                if (nums[midum] < nums[high] && nums[high] < target) {
                    high = midum - 1;
                } else {
                    low = midum + 1;
                }
            } else {
                if (nums[midum] > nums[high] && target < nums[high]) {
                    low = midum + 1;
                } else {
                    high = midum - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] num = {4, 5, 6, 7, 0, 1, 2};
        System.out.println(search(num, 5));

    }
}
