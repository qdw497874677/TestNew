package com.qdw.interview;

import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test2
 * @Description:
 * @date 2020/5/16 0016 17:01
 */
public class Test2 {
    public static void main(String[] args) {
        String A = "A";
        String B = "B";
        new Thread(new Demo(A,B),"线程1").start();
        new Thread(new Demo(B,A),"线程2").start();
    }

}
class Demo implements Runnable{
    private String A;
    private String B;
    public Demo(String A,String B){
        this.A = A;
        this.B = B;
    }
    @SneakyThrows
    @Override
    public void run() {
        synchronized (A){
            System.out.println(Thread.currentThread().getName()+"有"+A+" 还需要"+B);
            TimeUnit.SECONDS.sleep(3);
            synchronized (B){
                System.out.println(Thread.currentThread().getName()+"有"+B+" 也有"+A);
            }
        }
    }
}
