package com.jy.IO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

import static java.nio.channels.ServerSocketChannel.open;

//阻塞IO
public class ServerZuSeIo {
    public static void main(String[] args) throws IOException {
        ServerSocketChannel serverSocketChannel = open();
        serverSocketChannel.socket().bind(new InetSocketAddress(8080));
        while (true) {
            SocketChannel socketChannel = serverSocketChannel.accept();
            DealTask dealTask = new DealTask(socketChannel);
            new Thread(dealTask).start();
        }
    }

}
