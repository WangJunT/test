package com.jy.netty06;

import java.io.FileInputStream;
import java.net.InetSocketAddress;
import java.nio.channels.FileChannel;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

public class ZeroCopyCilent {
    public static void main(String[] args) throws Exception {
        SocketChannel socketChannel = SocketChannel.open();
        new HashMap<>();
        socketChannel.connect(new InetSocketAddress("192.168.0.178", 8899));
        FileInputStream fileInputStream = new FileInputStream("D:\\novel_download\\16\\第4章：加重，揽在腰上的力度.txt");
        FileChannel channel = fileInputStream.getChannel();
        channel.transferTo(0, channel.size(), socketChannel);
        channel.close();
    }
}
