package com.jy.dongtaiguihua.erfen;

public class SearchRangeNew {
    //搜索一个数，如果存在，返回其索引，否则返回 -1。
    public int searchRange1(int[] num, int target) {
        int left = 0;
        int mid;
        int right = num.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (num[mid] == target) {
                return mid;
            } else if (num[mid] > target) {
                right = mid--;
            } else if (num[mid] < target) {
                left = mid++;
            }
        }
        return -1;
    }

    //寻找左侧边界的二分搜索
    public int searchRange2(int[] num, int target) {
        int left = 0;
        int mid = -1;
        int right = num.length - 1;
        while (left <= right) {
            mid = left + (right - left) / 2;
            if (num[mid] == target) {
                right = mid;
            } else if (num[mid] > target) {
                right = mid--;
            } else if (num[mid] < target) {
                left = mid++;
            }
        }
        return num[mid] == target ? mid : -1;
    }
}
