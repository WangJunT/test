package com.jy.netty06;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

public class ZeroCopyServer {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8899));
        while (true) {
            SocketChannel client = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(100);
            while (client.read(byteBuffer) > 0) {
                byteBuffer.flip();
                byte[] bytes = new byte[byteBuffer.limit()];
                byteBuffer.get(bytes);
                System.out.println(new String(bytes));
                byteBuffer.clear();
            }
        }
    }
}
