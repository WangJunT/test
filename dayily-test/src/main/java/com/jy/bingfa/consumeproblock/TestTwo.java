package com.jy.bingfa.consumeproblock;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class TestTwo {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(5);
        Thread pro = new Thread(new ProductQueue(blockingQueue));
        Thread con = new Thread(new ConsumeQueue(blockingQueue));
        pro.start();
        con.start();
    }
}
