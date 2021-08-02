package com.jy.sort;

import java.util.Arrays;

public class GuiBingSort {
    public static void main(String[] args) {
        int[] arr = new int[]{9, 8, 7, 5, 1, 2, 3, 4, 6, 10, 20, 21, 22, 19, 17, 18};
        arr = sort(arr);
        System.out.println(1);
    }

    private static int[] sortAgent(int[] arr) {
        long begin = System.currentTimeMillis();
        try {
            return sort(arr);
        } finally {
            System.out.println("执行耗时"+( System.currentTimeMillis() - begin));
        }
    }
    private static int[] sort(int[] arr) {
        if (arr.length < 2) {
            return arr;
        }
        int[] left = Arrays.copyOfRange(arr, 0, arr.length / 2);
        int[] right = Arrays.copyOfRange(arr, arr.length / 2, arr.length);
        return mergeSortArray(sort(left), sort(right));
    }

    private static int[] mergeSortArray(int[] sort, int[] sort1) {
        int[] resultArr = new int[sort.length + sort1.length];
        int i = 0, j = 0, k = 0;
        while (i < sort.length || j < sort1.length) {
            if (i > sort.length - 1) {
                resultArr[k] = sort1[j];
                j++;
                k++;
            } else if (j > sort1.length - 1 || sort[i] <= sort1[j]) {
                resultArr[k] = sort[i];
                i++;
                k++;
            } else {
                resultArr[k] = sort1[j];
                j++;
                k++;
            }
        }
        return resultArr;
    }

}
