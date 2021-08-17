package com.jy.bingfa;

public class ThreadLocalTest {
    private static final ThreadLocal<A> threadLocal = new ThreadLocal() {
        protected A initialValue() {
            return a;
        }
    };
    private static A a = new A();

    public static void main(String[] args) {
        Thread[] threads = new Thread[5];
        for (int i = 0; i < 5; i++) {
            threads[i] = new Thread(new Runnable() {
                @Override
                public void run() {
                    threadLocal.get().setNum(threadLocal.get().getNum() + 5);
                    System.out.println(Thread.currentThread().getName() + " " + threadLocal.get().getNum());
                }
            }, "Thread-" + i);
        }
        for (Thread thread : threads) {
            thread.start();
        }
    }


}

class A {
    private Integer num = 0;

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }
}
