package com.jy.bingfa.consumeproblock;

import java.util.concurrent.BlockingQueue;

public class ProductQueue implements Runnable {
    BlockingQueue<Integer> blockingQueue;
    public ProductQueue(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i=0;i <10;i++) {
            try {
                blockingQueue.put(i);
                System.out.println("生产成功" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
