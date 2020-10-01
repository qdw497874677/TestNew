package com.qdw.main;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PC {
    public static void main(String[] args) {
        Data data = new PC().new Data();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.decrement();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 100; i++) {
                data.increment();
            }
        }).start();

    }
    class Data{
        int sum = 0;
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();
        public void increment(){
            lock.lock();
            try {
                while (sum!=0){
                    condition.await();
                }
                sum++;
                System.out.println("increment:1 sum="+sum);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
        public void decrement(){
            lock.lock();
            try {
                while (sum==0){
                    condition.await();
                }
                sum--;
                System.out.println("decrement:1 sum="+sum);
                condition.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }

    }
}


