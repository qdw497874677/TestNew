package com.qdw.aqs;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @PackageName:com.qdw.aqs
 * @ClassName: Test5
 * @Description:
 * @date: 2020/10/31 0031 15:53
 */
public class Test5 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(()->{
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"完成！");
                countDownLatch.countDown();
            },i+"");
            thread.start();
        }
        countDownLatch.await();
        System.out.println("都完成了！！！");
    }
}
