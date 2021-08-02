package com.jy.bingfa;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    //多个数组求和，也可以将数组分成 更小分的
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        int[] arr = new int[]{1,23,5,9};
        FutureTask<Integer> futureTask = new FutureTask(()->arr[1]+arr[0]);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.get());
    }

}
