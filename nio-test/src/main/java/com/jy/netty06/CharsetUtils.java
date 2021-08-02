package com.jy.netty06;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CharsetEncoder;

public class CharsetUtils {
    public static void main(String[] args) throws Exception {
        RandomAccessFile inputFile = new RandomAccessFile("NioIn.txt", "r");
        RandomAccessFile outPutFile = new RandomAccessFile("NioOut.txt", "rw");
        FileChannel channel = inputFile.getChannel();
//        ByteBuffer byteBuffer = ByteBuffer.allocate(5);
//        while (0 < channel.read(byteBuffer)) {
//            byteBuffer.flip();
//            byte[] bytes = new byte[byteBuffer.limit()];
//            byteBuffer.get(bytes);
//            System.out.println(new String(bytes));
//            byteBuffer.clear();
//        }
        long length = new File("NioIn.txt").length();
        MappedByteBuffer mappedByteBuffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, length);
        Charset charset =Charset.forName("iso8859-1");
        CharBuffer charBuffer = charset.decode(mappedByteBuffer);
        ByteBuffer byteBuffer = charset.encode(charBuffer);
//        byteBuffer.flip();
        byte[] bytes = new byte[byteBuffer.limit()];
        byteBuffer.get(bytes);
        outPutFile.write(bytes);
    }
}
