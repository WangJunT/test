package com.jy.sort;

import java.util.Random;

public class GuiBingSort2 {
    public static void main(String[] args) {
        int arr[] = new int[10000];
        for (int i=0;i<10000;i++) {Random random = new Random();
            arr[i] = random.nextInt(30000);
        }
        int begin = 0, end = arr.length - 1;
        guibing(arr, begin, end);
        System.out.println(1);
    }

    private static void guibing(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }
        int mid = (begin + end) / 2;
        guibing(arr, begin, mid);
        guibing(arr, mid + 1, end);
        hebing(arr, begin, end, mid);
        return;
    }

    private static void hebing(int[] arr, int begin, int end, int mid) {
        int[] a1 = new int[mid - begin + 1];
        int[] a2 = new int[end - mid];
        int index = begin;
        int tmp = begin;
        for (int i = 0; i < a1.length; i++, index++) {
            a1[i] = arr[index];
        }
        for (int i = 0; i < a2.length; i++, index++) {
            a2[i] = arr[index];
        }
        int i, j = 0;
        for (i = 0, j = 0; i < a1.length && j < a2.length; tmp++) {
            if (a1[i] > a2[j]) {
                arr[tmp] = a2[j];
                j++;
            } else {
                arr[tmp] = a1[i];
                i++;
            }
        }
        if (i > a1.length - 1) {
            for (; j < a2.length; j++, tmp++) {
                arr[tmp] = a2[j];
            }
        } else {
            for (; i < a1.length; i++, tmp++) {
                arr[tmp] = a1[i];
            }
        }
    }

}
