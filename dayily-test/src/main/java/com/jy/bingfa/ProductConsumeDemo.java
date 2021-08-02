package com.jy.bingfa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ProductConsumeDemo {
    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition notEmpty = reentrantLock.newCondition();
    private Condition notFull = reentrantLock.newCondition();
    private static int maxsize = 10;
    private static Object object = new Object();

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        Thread c1 = new Thread(new Consume("消费者1", queue, maxsize));
        Thread p1 = new Thread(new Product("生产者1", queue, maxsize));
        Thread p2 = new Thread(new Product("生产者2", queue, maxsize));
        c1.start();
        p1.start();
        p2.start();
    }

    static class Product implements Runnable {
        private String name;
        private Queue<Integer> list;
        private int maxsize;

        public Product(String name, Queue<Integer> list, int maxsize) {
            this.name = name;
            this.list = list;
            this.maxsize = maxsize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    System.out.println(name + "启动");
                    if (list.size() >= maxsize) {
                        try {
                            System.out.println(name + "等待");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }

                    object.notifyAll();
                    System.out.println(name + "被唤醒");
                    Random random = new Random(10);
                    list.offer(random.nextInt());
                }
            }
        }
    }

    static class Consume implements Runnable {
        private String name;
        private Queue<Integer> list;
        private int minsize;

        public Consume(String name, Queue<Integer> list, int minsize) {
            this.name = name;
            this.list = list;
            this.minsize = minsize;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (object) {
                    System.out.println(name + "启动");
                    if (list.size() <= minsize) {
                        try {
                            System.out.println(name + "等待");
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    object.notifyAll();
                    System.out.println(name + "被唤醒");
                    list.poll();
                }
            }
        }
    }
}
