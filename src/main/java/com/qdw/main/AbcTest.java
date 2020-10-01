package com.qdw.main;

import java.util.Date;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class AbcTest {
    public static void main(String[] args) {

        Data data = new Data();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printA();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printB();
            }
        }).start();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                data.printC();
            }
        }).start();
    }

}

class Data{
    private int flag;
    private Lock lock;
    private Condition conditionA;
    private Condition conditionB;
    private Condition conditionC;
    public Data(){
        flag = 1;
        lock = new ReentrantLock();
        conditionA = lock.newCondition();
        conditionB = lock.newCondition();
        conditionC = lock.newCondition();
    }
    public void printA(){
        lock.lock();
        try {
            while (flag!=1){
                conditionA.await();
            }
            System.out.println("A");
            flag = 2;
            conditionB.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printB(){
        lock.lock();
        try {
            while (flag!=2){
                conditionB.await();
            }
            System.out.println("B");
            flag = 3;
            conditionC.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    public void printC(){
        lock.lock();
        try {
            while (flag!=3){
                conditionC.await();
            }
            System.out.println("C");
            flag = 1;
            conditionA.signal();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
