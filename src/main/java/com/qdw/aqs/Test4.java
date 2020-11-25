package com.qdw.aqs;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * @PackageName:com.qdw.aqs
 * @ClassName: Test4
 * @Description:
 * @date: 2020/10/12 0012 23:31
 */
public class Test4 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                if (Thread.interrupted()){
                    System.out.println("被中断,退出循环");
                    return;
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    // sleep会消耗掉中断状态
                    Thread.currentThread().interrupt();

                }
                System.out.println(i);
            }
        });
        thread.start();
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
        System.out.println("结束");
    }
}
