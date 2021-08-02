package com.jy.bingfa.consumeproone;

public class Publice {
    private int count = 0;

    public synchronized void increate() {
        while (5 == count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count++;
        notify();
        System.out.println("生产者生产成功");
    }

    public synchronized void decrease() {
        while (0 == count) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        count--;
        notify();
        System.out.println("消费者消费成功");
    }
}
