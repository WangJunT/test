package com.jy.sort;

public class InsertSort {
    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                int tmp = arr[i];
                arr[i] = arr[i - 1];
                int j = i - 1;
                while (tmp < arr[j] && j > 0) {
                    arr[j] = arr[j - 1];
                    j--;
                }
                if (tmp < arr[j]) {
                    arr[j] = tmp;
                } else {
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 6, 8, 7, 9};
        insertSort(arr);
        System.out.println(arr);
    }
}
