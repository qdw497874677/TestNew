package com.qdw.aqs;

import java.util.Date;

/**
 * @Author: Quandw
 * @Description:
 * @Date: 2020/11/4 0004 10:55
 */
public class Test8 {

    public static void main(String[] args) {

        Date date = new Date();
        new Thread(()->{
            synchronized (date){
                System.out.println("进入");
                try {
                    date.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("退出");
            }
        }).start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(()->{
            synchronized (date){
                System.out.println("进入");
                date.notifyAll();

            }
        }).start();

    }
}
