package com.qdw.aqs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @PackageName:com.qdw.aqs
 * @ClassName: Test1
 * @Description:
 * @date: 2020/9/17 0017 14:34
 */
public class Test1 {

    int flag = 0;
    public synchronized void ins(){

        try {
            while (flag>5){
                wait();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+"执行+:"+(++flag));
        notify();
        System.out.println(Thread.currentThread().getName()+"执行结束");

    }

    public void des(){
        synchronized (this){
            try {
                while (flag==0){
                    wait();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
            flag += 2;
            System.out.println(Thread.currentThread().getName()+"执行-:"+(flag));
            notify();
            System.out.println(Thread.currentThread().getName()+"执行结束");
        }


    }
    public static void main(String[] args) {
//        Thread.currentThread().join();
        new ReentrantLock();
        new LinkedList<>();
        Test1 test1 = new Test1();
        Thread thread1;
        Thread thread2;
        for (int i = 0; i < 5; i++) {
            thread1 = new Thread(() -> {
                test1.ins();
            });
            thread2 = new Thread(() -> {
                test1.des();
            });
            thread1.start();
            thread2.start();
//            thread1.join();
            System.out.println("当前flag："+test1.flag);
        }




        System.out.println("AAA");


    }
}
