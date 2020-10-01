package com.qdw.main;

import java.text.SimpleDateFormat;

/**
 * @PackageName:com.qdw.main
 * @ClassName: Local
 * @Description:
 * @date: 2020/5/22 0022 14:36
 */
public class Local implements Runnable {
    private static final ThreadLocal<String> localStr = ThreadLocal.withInitial(()->"init");
    public static void main(String[] args) {
        new Thread(new Local(),"线程1").start();
        new Thread(new Local(),"线程2").start();
    }
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+" "+localStr.get());
        localStr.set(Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName()+" "+localStr.get());
    }
}

