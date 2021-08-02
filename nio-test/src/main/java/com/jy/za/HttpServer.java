package com.jy.za;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;

public class HttpServer { public static void main(String[] args) throws Exception{
    ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
    serverSocketChannel.socket().bind(new InetSocketAddress((8080)));
    serverSocketChannel.configureBlocking(false);

    Selector selector = Selector.open();

    // It must be ACCEPT, or it will throw exception
    serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

    while(true){
        if (selector.select(3000) == 0){
            continue;
        }

        Iterator<SelectionKey> keyIter = selector.selectedKeys().iterator();

        while (keyIter.hasNext()){
            SelectionKey key = keyIter.next();
            Thread thread = new Thread(new HttpHandler(key));
            thread.run();
            System.out.println("===================");
            keyIter.remove();
        }
    }
}
}
