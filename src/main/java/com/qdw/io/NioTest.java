package com.qdw.io;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.HashMap;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/19 下午8:05
 */
public class NioTest {
    public static void main(String[] args) throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.bind(new InetSocketAddress(8000));
        socketChannel.configureBlocking(false);
        ByteBuffer buffer = ByteBuffer.allocate(1000);
        socketChannel.read(buffer);
    }
}
