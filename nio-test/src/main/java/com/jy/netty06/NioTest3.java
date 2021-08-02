package com.jy.netty06;

import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NioTest3 {
    public static void main(String[] args) throws Exception {
        ByteBuffer byteBuffer = ByteBuffer.wrap("Hello Word W".getBytes());

//        byteBuffer.flip();
        FileOutputStream fileOutputStream = new FileOutputStream("NioTest3.txt");
        FileChannel fileChannel = fileOutputStream.getChannel();
        fileChannel.write(byteBuffer);
        fileOutputStream.close();


    }
}
