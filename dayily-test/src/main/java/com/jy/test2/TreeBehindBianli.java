package com.jy.test2;

public class TreeBehindBianli {
    public static void main(String[] args) {
        int arr[] = {5, 7, 6, 9, 11, 10, 8};
        boolean flag = isBehindTree(arr, 0, arr.length - 1);
        System.out.println(flag);
    }

    private static boolean isBehindTree(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = arr[end];
        int tmp = start;
        for (int i = start; i < end; i++) {
            if (arr[i] < root) {
                tmp = i;
            } else {
                tmp++;
                break;
            }
        }
        for (int i = tmp; i < end; i++) {
            if (arr[i] < root) {
                return false;
            }
        }
        return isBehindTree(arr, start, --tmp) && isBehindTree(arr, tmp, --end);
    }
}
