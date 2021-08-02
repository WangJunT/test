package com.jy.netty06;

import java.nio.IntBuffer;
import java.util.Random;

public class NioTest1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(10);
        for (int i=0;i<5;i++) {
            intBuffer.put(new Random().nextInt(10));
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()) {
            System.out.println(intBuffer.get());
        }
        intBuffer.flip();
        for (int i=0;i<6;i++) {
            intBuffer.put(new Random().nextInt(10));
        }
    }
}
