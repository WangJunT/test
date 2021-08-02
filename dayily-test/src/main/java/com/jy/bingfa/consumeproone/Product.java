package com.jy.bingfa.consumeproone;

public class Product implements Runnable {
    private Publice count;

    public Product(Publice count) {
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("pro" + i);
            count.increate();
        }
    }
}
