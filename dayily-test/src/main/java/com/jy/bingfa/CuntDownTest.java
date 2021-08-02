package com.jy.bingfa;

import java.util.concurrent.CountDownLatch;

public class CuntDownTest {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch(2);
        Thread t1 = new Thread(() -> {
            try {
                System.out.println("t1线程开始休眠");
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t1线程结束休眠");
            countDownLatch.countDown();
        });
        Thread t2 = new Thread(() -> {
            try {
                System.out.println("t2线程开始休眠");
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2线程结束休眠");
            countDownLatch.countDown();
        });
        t1.start();
        t2.start();
        Thread t3 = new Thread(() -> {
            try {
                System.out.println("t3开始");
                countDownLatch.await();
                System.out.println("t3线程结束运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t3.start();
        Thread t4 = new Thread(() -> {
            try {
                System.out.println("t4开始");
                countDownLatch.await();
                System.out.println("t4线程结束运行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t4.start();
    }
}
