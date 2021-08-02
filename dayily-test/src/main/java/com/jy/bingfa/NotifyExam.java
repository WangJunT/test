package com.jy.bingfa;

public class NotifyExam {
    public static void main(String[] args) {
        NotifyExam exam = new NotifyExam();
        Thread t1 = new Thread(() -> {
            synchronized (exam) {
                try {
                    System.out.println("t1线程启动了");
                    exam.wait();
                    System.out.println("t1线程正常唤醒结束啦");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    System.out.println("t1线程被终端");
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (exam) {
                System.out.println("t2线程启动了");
                exam.notify();
                System.out.println("t2线程结束");
            }
        });
//        t2.start();

        Thread t3 = new Thread(() -> {
            synchronized (exam) {
                System.out.println("t2线程启动了");
                t1.interrupt();
                System.out.println("t2线程结束");
            }
        });
        t3.start();
    }
}
