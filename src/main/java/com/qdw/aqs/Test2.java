package com.qdw.aqs;

import com.qdw.test.Test5;

import java.util.concurrent.CountDownLatch;

/**
 * @PackageName:com.qdw.aqs
 * @ClassName: Test2
 * @Description:
 * @date: 2020/9/20 0020 15:53
 */

public class Test2 {
    int test2;
    protected int test;
    public int test1;
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            Thread thread = new Thread(() -> {
                System.out.println("我是"+temp);
                countDownLatch.countDown();
            },i+"");
            thread.start();
        }


        countDownLatch.await();
        System.out.println("都完了");

    }
}
