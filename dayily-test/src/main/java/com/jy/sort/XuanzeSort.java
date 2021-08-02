package com.jy.sort;

public class XuanzeSort {
    private static void xuanSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int maxIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
        }
    }

    private static void xuanSortImprove(int[] arr) {
        for (int i = 0, m = arr.length - 1; i < m; i++, m--) {
            int maxIndex = i;
            int minIndex = m;
            for (int j = i, k = m; j < m && k > i; j++,k--) {
                if (arr[j] > arr[maxIndex]) {
                    maxIndex = j;
                }
                if (arr[k]<arr[minIndex]) {
                    minIndex = k;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[maxIndex];
            arr[maxIndex] = tmp;
            int minTmp = arr[m];
            arr[m] = arr[minIndex];
            arr[minIndex] = minTmp;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 9, 4, 6, 7, 2, 3};
        xuanSort(arr);
        System.out.println(1);
    }
}
