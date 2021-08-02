package com.jy.offertmp;

public class Subject40 {
    public static void main(String[] args) {
        int[] arr = {5, 7, 9, 1, 4, 6, 8, 3, 2};
        int k = 5;
        int[] karr = getKxiaoNum(arr, k);
        System.out.println(1);
    }

    private static int[] getKxiaoNum(int[] arr, int k) {
        if (null == arr || arr.length == 0) {
            return null;
        }
        int index = quickSort(arr, 0, arr.length - 1);
        while (index != k) {
            if (index > k) {
                index = quickSort(arr, 0, index - 1);
            } else {
                index = quickSort(arr, index + 1, arr.length - 1);
            }
        }
        int[] karr = new int[k];
        for (int i = 0; i < k; i++) {
            karr[i] = arr[i];
        }
        return karr;
    }

    private static int quickSort(int[] arr, int begin, int end) {
        int key = arr[begin];
        while (begin < end) {
            while (begin < end && arr[end] > key) {
                end--;
            }
            if (arr[end] < key) {
                arr[begin] = arr[end];
            }
            while (begin < end && arr[begin] < key) {
                begin++;
            }
            if (arr[begin] > key) {
                arr[end] = arr[begin];
            }
        }
        arr[begin] = key;
        return begin;
    }
}
