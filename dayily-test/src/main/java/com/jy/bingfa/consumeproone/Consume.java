package com.jy.bingfa.consumeproone;

public class Consume implements Runnable {
    private Publice count;

    public Consume(Publice count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("con" + i);
            count.decrease();
        }
    }
}
