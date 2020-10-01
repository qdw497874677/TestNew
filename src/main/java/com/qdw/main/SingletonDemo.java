package com.qdw.main;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class SingletonDemo {
    private static volatile SingletonDemo instance;
    private SingletonDemo(){
        System.out.println("执行构造方法");
    }
    private static SingletonDemo getInstance(){
        if (instance == null){
            synchronized (SingletonDemo.class){
                if (instance == null){
                    instance = new SingletonDemo();
                }
            }
        }
        return instance;
    }
    public static void main(String[] args) throws InterruptedException {
        TimeUnit.SECONDS.sleep(1);
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName()+" "+SingletonDemo.getInstance());
            },String.valueOf(i)).start();
        }

        AtomicInteger atomicInteger;
    }
}
