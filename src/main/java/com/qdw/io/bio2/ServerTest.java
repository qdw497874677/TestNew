package com.qdw.io.bio2;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackageName:com.qdw.io.bio2
 * @ClassName: ClientTest
 * @Description:
 * @date: 2020/9/8 0008 13:45
 */
public class ServerTest {
    public static void main(String[] args) {
        int port = 8000;
        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(port);
            Socket accept = null;
            while (true){
                accept = serverSocket.accept();
                int cPort = accept.getPort();
                System.out.println(cPort+"已连接");
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(accept.getInputStream()));
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(accept.getOutputStream()));
                String s = null;
                // 读客户端发来的信息
                while ((s=bufferedReader.readLine())!=null){
                    System.out.println(cPort+"："+s);
                    // 发送给客户端信息，注意最后要加换行符
                    bufferedWriter.write(s+" 我收到了，你好呀"+"\n");
                    bufferedWriter.flush();
                }
                System.out.println(s+"退出");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket!=null){
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
