package com.jy.sort;

public class MaoPaoSort {

    public static void insertSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }

        }
    }

    public static void main(String[] args) {
        int[] arr = {9, 8, 7, 5, 6, 3, 2, 1};
        insertSort(arr);
        System.out.println(1);
    }
}
