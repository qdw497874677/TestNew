package com.qdw.aqs;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

/**
 * @PackageName:com.qdw.aqs
 * @ClassName: Test6
 * @Description:
 * @date: 2020/10/31 0031 17:12
 */
public class Test6 {
    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3,()->{
            System.out.println("预备~~~~~~~~~~~~~~~~");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("开始！！！！！！！！！");
        });
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread(()->{
                for (int j = 0; j < 10; j++) {
                    try {
                        cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"开跑");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"第"+j+"圈完成");
                }
            },i+"");
            thread.start();
        }
        Thread.sleep(30000);
    }
}
