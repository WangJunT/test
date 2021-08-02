package com.jy.bingfa;

import java.util.concurrent.locks.ReentrantLock;

public class RettLockTest {
    static ReentrantLock reentrantLock1 = new ReentrantLock(true);

    //    static  ReentrantLock reentrantLock2 = new ReentrantLock(true);
    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            System.out.println("线程1kaishi");
            reentrantLock1.lock();
            System.out.println("线程1suo");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock1.unlock();
            System.out.println("线程1busuo");
        }).start();
        Thread.sleep(1000);
        new Thread(() -> {
            System.out.println("线程2kaishi");
            reentrantLock1.lock();
            System.out.println("线程2suo");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            reentrantLock1.unlock();
            System.out.println("线程2busuo");
        }).start();
    }
}
