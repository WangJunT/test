package com.jy.netty06;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.*;


public class NioServer {
    private static Map<String, SocketChannel> map = new HashMap();

    public static void main(String[] args) throws Exception {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(8899));
        Selector selector = Selector.open();
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (true) {
            selector.select();
            Set<SelectionKey> selectionKeys = selector.selectedKeys();
            Iterator<SelectionKey> iterator = selectionKeys.iterator();
            while (iterator.hasNext()) {
                SelectionKey selectionKey = iterator.next();
                if (selectionKey.isAcceptable()) {
                    ServerSocketChannel selectableChannel = (ServerSocketChannel) selectionKey.channel();
                    SocketChannel socketChannel = selectableChannel.accept();
                    socketChannel.configureBlocking(false);
                    map.put(UUID.randomUUID().toString(), socketChannel);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                } else if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer byteBuffer = ByteBuffer.allocate(512);
                    socketChannel.read(byteBuffer);
                    byteBuffer.flip();
                    byte[] bytes = new byte[byteBuffer.limit()];
                    byteBuffer.get(bytes);
                    String sendKey = "";
                    for (Map.Entry<String, SocketChannel> aa : map.entrySet()) {
                        if (aa.getValue().equals(socketChannel)) {
                            System.out.println("收到客户端【" + aa.getKey() + "】:" + new String(bytes));
                            sendKey = aa.getKey();
//                            aa.getValue().write(ByteBuffer.wrap(("[youself:]" + new String(bytes)).getBytes()));
                        }
                    }
                    for (Map.Entry<String, SocketChannel> aa : map.entrySet()) {
                        aa.getValue().write(ByteBuffer.wrap(("[" + sendKey + "]:" + new String(bytes)).getBytes()));
                    }
                } else if (selectionKey.isWritable()) {

                }
                iterator.remove();
            }
        }
    }
}
