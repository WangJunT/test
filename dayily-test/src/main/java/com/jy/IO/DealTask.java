package com.jy.IO;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

public class DealTask implements Runnable {
    private SocketChannel socketChannel;

    public DealTask(SocketChannel socketChannel) {
        this.socketChannel = socketChannel;
    }

    @Override
    public void run() {
        ByteBuffer var1 = ByteBuffer.allocateDirect(2000);
        try {
            int num;
            while ((num = socketChannel.read(var1)) > 0) {
                // 读取 Buffer 内容之前先 flip 一下
                var1.flip();
                // 提取 Buffer 中的数据
                byte[] bytes = new byte[num];
                var1.get(bytes);

                String re = new String(bytes, "UTF-8");
                System.out.println("收到请求：" + re);
                socketChannel.write(ByteBuffer.wrap("我已收到你的请求".getBytes()));
            }
//            int a = socketChannel.read(var1);
//            byte[] bytes = new byte[a + 1];
//            var1.flip();
//            var1.get(bytes);
//            String s = new String(bytes);
//            System.out.println(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
