package com.jy.bingfa;

import java.util.concurrent.locks.ReentrantLock;

public class ReentranLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Thread thread1 = new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println("before test1");
                Thread.sleep(10000);
                System.out.println("after test1");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        });
        Thread thread2 = new Thread(()->{
            reentrantLock.lock();
            try {
                System.out.println("before test2");
//                Thread.sleep(10000);
                System.out.println("after test2");
            } catch (Exception e) {
                e.printStackTrace();
            }
            reentrantLock.unlock();
        });
        thread1.start();
        thread2.start();
    }


}
