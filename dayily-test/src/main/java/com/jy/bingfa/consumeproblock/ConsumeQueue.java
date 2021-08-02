package com.jy.bingfa.consumeproblock;

import java.util.concurrent.BlockingQueue;

public class ConsumeQueue implements Runnable {
    private BlockingQueue<Integer> blockingQueue;

    public ConsumeQueue(BlockingQueue<Integer> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            try {
                blockingQueue.take();
                System.out.println("消费成功" + i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
