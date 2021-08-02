package com.jy.bingfa;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ThreadPoolTest {

    private static int fenge = 1000;

    //多io的多创建几个核心线程
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = generateArr(20000);
        int size = arr.length > fenge ? arr.length / fenge : 1;
        ExecutorService executor = Executors.newFixedThreadPool(5);
        Future<Long>[] futures = new Future[size];
        for (int i = 0; i < size; i++) {
            int finalI = i;
            futures[i] = executor.submit(() ->
                    sum(arr, finalI * fenge, (finalI + 1) * fenge));
        }
        long sum = 0;
        for (int i = 0; i < futures.length; i++) {
            sum += futures[i].get();
        }
        System.out.println(sum);
    }

    public static void main1(String[] args) {
        int[] arr = generateArr(20000);
        System.out.println(sum(arr, 0, arr.length));
    }

    private static int[] generateArr(int n) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static Long sum(int[] arr, int begin, int end) {
        long sum = 0;
        for (int i = begin; i < end && i < arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }
}
