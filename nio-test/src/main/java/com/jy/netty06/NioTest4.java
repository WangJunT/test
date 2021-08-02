package com.jy.netty06;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;

public class NioTest4 {
    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
//        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8899));
        Charset charset = Charset.forName("utf-8");
        while (true) {
            SocketChannel channel = serverSocketChannel.accept();
            ByteBuffer byteBuffer = ByteBuffer.allocate(512);
            int num = channel.read(byteBuffer);
            byteBuffer.flip();
            String receivedMessage = String.valueOf(charset.decode(byteBuffer).array());
            byteBuffer.clear();
//            System.out.println(new String(bytes));
            byteBuffer.put(("server receive " + receivedMessage).getBytes());
            byteBuffer.flip();
            channel.write(byteBuffer);
        }
    }
}
