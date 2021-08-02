package com.jy.sort;

public class XierSort {
    private static void xierSort(int[] arr, int k) {
        while (k > 0) {
            for (int i = k; i < arr.length; i++) {
                if (arr[i] < arr[i - k]) {
                    int tmp = arr[i];
                    arr[i] = arr[i - k];
                    int j = i - k;
                    while (arr[j] > tmp && j > k) {
                        arr[j] = arr[j - k];
                        j = j - k;
                    }
                    if (arr[j] > tmp) {
                        arr[j] = tmp;
                    } else {
                        arr[j + k] = tmp;
                    }
                }
            }
            k = k / 2;
        }
    }

    public static void main(String[] args) {
        int[] num = {3, 6, 9, 2, 5, 8, 7, 1};
        xierSort(num, num.length / 2);
        System.out.println(1);
    }
}
