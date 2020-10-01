package com.qdw.io.bio;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/19 下午8:26
 */
public class ServerTest {
    public static void main(String[] args) throws IOException {
        // 端口号
        int port = 7000;
        // 在端口上创建一个服务器套接字
        ServerSocket serverSocket = new ServerSocket(port);
        // 客户端编号
        int clientNo = 1;
        // 创建线程池
        ExecutorService executorService = Executors.newCachedThreadPool();

        while(true){
            Socket socket = serverSocket.accept();
            executorService.execute(new Thread(new SingleServer(socket,clientNo++)));
        }

    }

    static class SingleServer implements Runnable{
        private Socket socket;
        private int clientNo;
        public SingleServer(Socket socket,int clientNo){
            this.socket = socket;
            this.clientNo = clientNo;
        }
        @Override
        public void run() {
            // 监听来自客户端的连接
            try {
                DataInputStream dis = new DataInputStream(
                        new BufferedInputStream(socket.getInputStream()));

                DataOutputStream dos = new DataOutputStream(
                        new BufferedOutputStream(socket.getOutputStream()));

                do {
                    double length = dis.readDouble();
                    System.out.println("服务器端收到的边长数据为：" + length+" 客户端编号为:"+clientNo);
                    double result = length * length;
                    dos.writeDouble(result);
                    dos.flush();
                } while (dis.readInt() != 0);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
