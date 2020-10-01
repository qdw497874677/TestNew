package com.qdw.io.bio2;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * @PackageName:com.qdw.io.bio2
 * @ClassName: ClientTest
 * @Description:
 * @date: 2020/9/8 0008 14:02
 */
public class ClientTest {
    public static void main(String[] args) {
        int port = 8000;
        String ip = "127.0.0.1";
        Socket socket = null;
        try {
            socket = new Socket(ip,port);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String s = null;
            while ((s=console.readLine())!=null){
                if ("quit".equals(s)){
                    break;
                }
                // 发送给服务器信息
                bufferedWriter.write(s+"\n");
                bufferedWriter.flush();
                // 读取服务器返回的信息
                String msg = bufferedReader.readLine();
                if (msg!=null){
                    System.out.println("服务器："+msg);
                }
            }
        } catch (Exception e){
            System.out.println("连接关闭");
            e.printStackTrace();
        } finally {
            if (socket!=null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
