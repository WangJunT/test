package com.jy.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class Client {
    public static void main(String[] args) throws IOException, InterruptedException {

        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("localhost", 8080));

        // 发送请求
        ByteBuffer buffer = ByteBuffer.wrap("1234567890".getBytes());
        socketChannel.write(buffer);
        ByteBuffer readBuffer = ByteBuffer.allocate(1024);
        int num = socketChannel.read(readBuffer);
        byte[] bytes = new byte[num];
        readBuffer.flip();
        readBuffer.get(bytes);
        System.out.println(new String(bytes));
        socketChannel.close();
//        SocketChannel socketChannel =  SocketChannel.open();
//        socketChannel.connect(new InetSocketAddress("localhost",8080));
//        socketChannel.write(ByteBuffer.wrap("Hello I Am".getBytes()));
    }
}
