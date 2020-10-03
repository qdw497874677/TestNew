package com.qdw.io.nio;

import java.io.*;
import java.net.Socket;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @PackageName:com.qdw.io.nio
 * @ClassName: FileCopyDemo
 * @Description:
 * @date: 2020/9/8 0008 17:33
 */
interface FileCopyer{
    void copyFile(File source,File target);
}
public class FileCopyDemo {
    // 统一的关闭流方法
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
        FileCopyer noBufferStreamCopy = new FileCopyer() {
            @Override
            public void copyFile(File source, File target) {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    fin = new FileInputStream(source);
                    fout = new FileOutputStream(source);
                    int res;
                    while((res=fin.read())!=-1) {
                        fout.write(res);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }
        };

        FileCopyer bufferedStreamCopy = new FileCopyer() {
            @Override
            public void copyFile(File source, File target) {
                InputStream fin = null;
                OutputStream fout = null;
                try {
                    fin = new BufferedInputStream(new FileInputStream(source));
                    fout = new BufferedOutputStream(new FileOutputStream(target));
                    byte[] buffer = new byte[1024];
                    int res;
                    // 先读到缓冲区
                    while((res=fin.read(buffer))!=-1){
                        // 从缓冲区中取数据写入
                        fout.write(buffer,0,res);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }
        };

        FileCopyer nioBufferCopy = new FileCopyer() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fin = null;
                FileChannel fout = null;
                try {
                    fin = new FileInputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();
                    // 创建一个字节缓存区
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    // 输入到buffer中
                    while(fin.read(buffer)!=-1){
                        // 将position指针放到开始，转换为读模式
                        buffer.flip();
                        while (buffer.hasRemaining()){
                            fout.write(buffer);
                        }
                        // 重置为写模式
                        buffer.clear();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }
        };

        FileCopyer nioTransferCopy = new FileCopyer() {
            @Override
            public void copyFile(File source, File target) {
                FileChannel fin = null;
                FileChannel fout = null;
                try {
                    fin = new FileOutputStream(source).getChannel();
                    fout = new FileOutputStream(target).getChannel();
                    long t = 0L;
                    long size = fin.size();
                    while (t!=size){
                        t += fin.transferTo(0, size, fout);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    close(fin);
                    close(fout);
                }
            }
        };
    }
}
