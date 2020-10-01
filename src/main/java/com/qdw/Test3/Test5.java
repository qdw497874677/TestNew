package com.qdw.Test3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test5 {
    public static void main(String[] args) {
//        Data data = new Data();
//        new Thread(()->{
//            data.A();
//        },"T1").start();
//        new Thread(()->{
//            data.A();
//        },"T2").start();

        Data data = new Data();
        new Thread(()->{
            data.X();
        },"T1").start();
        new Thread(()->{
            data.X();
        },"T2").start();
    }
}
class Data{
    public synchronized void A(){
        System.out.println(Thread.currentThread().getName()+" invoked A");
        B();
    }
    public synchronized void B(){
        System.out.println(Thread.currentThread().getName()+" invoked B");
    }

    Lock lock = new ReentrantLock();
    public void X(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" invoked X");
            Y();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void Y(){
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName()+" invoked Y");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

