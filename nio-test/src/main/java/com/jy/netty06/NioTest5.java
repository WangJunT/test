package com.jy.netty06;

import java.nio.ByteBuffer;

/**
 * Slice Buffer
 */
public class NioTest5 {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(10);
        for (int i=0;i<10;i++) {
            byteBuffer.put((byte) i);
        }
        byteBuffer.position(3);
        byteBuffer.limit(6);
        ByteBuffer slice = byteBuffer.slice();
        for (int i= 0;i<3;i++) {
            slice.put(i, (byte) (i*2 + 3));
        }
        byteBuffer.position(0);
        byteBuffer.limit(byteBuffer.capacity());
        while (byteBuffer.hasRemaining()) {
            System.out.println(byteBuffer.get());
        }
    }
}
