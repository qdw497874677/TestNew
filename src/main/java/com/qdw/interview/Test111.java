package com.qdw.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: Quandw
 * @Description:
 * @Date: 2020/11/6 0006 16:39
 */

class Date{
    int res = 0;
    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();
    public void de(){
        lock.lock();
        try {
            while (res==0){
                condition.await();
            }
            res--;
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"消费了1 当前资源为："+res);

            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void in(){
        lock.lock();
        try {
            while (res==5){
                condition.await();
            }
            res++;
            Thread.sleep(500);
            System.out.println(Thread.currentThread().getName()+"生产了1 当前资源为："+res);

            condition.signalAll();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
public class Test111 {

    public static void main(String[] args) {
        Date date = new Date();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                date.in();
            }
        },"生产者1").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                date.in();
            }
        },"生产者2").start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                date.de();
            }

        },"消费者1").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                date.de();
            }

        },"消费者2").start();
    }
}
