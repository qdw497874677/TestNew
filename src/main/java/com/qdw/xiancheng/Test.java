package com.qdw.xiancheng;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test
 * @Description:
 * @date: 2020/9/18 0018 18:21
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        Executors.newFixedThreadPool(4);
        Executors.newSingleThreadExecutor();
        Executors.newCachedThreadPool();
        Test test = new Test();
        Thread thread = new Thread(() -> {
            test.m();
        });
        Thread thread2 = new Thread(() -> {
            test.m();
        });
        thread.start();
        thread2.start();
        Thread.sleep(1000);
//        String s = "a";
//        System.out.println(test.s);
    }
    String s = new String("1");
    List<Integer> list = new ArrayList<>();
    public void m()  {
        synchronized (s){
            System.out.println("1");
            try {
                Thread.sleep(100000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("2");
        }

    }

}
