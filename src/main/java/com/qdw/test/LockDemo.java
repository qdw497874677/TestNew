package com.qdw.test;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {

    public static void main(String[] args) {
        Data data = new Data();

        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                data.increment();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 50; i++) {
                data.decrement();
            }
        }).start();
    }


}

class Data{

    private int num;
    private Lock lock;
    private Condition condition;
    public Data(){
        this.num = 0;
        this.lock = new ReentrantLock();
        this.condition = lock.newCondition();
    }

    public void increment(){
        lock.lock();

        try {
            while (num == 10){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num++;
            System.out.println("生产操作 "+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void decrement(){
        lock.lock();

        try {
            while (num == 0){
                try {
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            num--;
            System.out.println("消耗操作 "+num);
            condition.signalAll();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
