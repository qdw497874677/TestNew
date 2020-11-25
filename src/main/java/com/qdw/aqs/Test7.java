package com.qdw.aqs;

import java.text.DecimalFormat;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: Quandw
 * @Description:
 * @Date: 2020/11/4 0004 10:24
 */
public class Test7 {

    static class Demo{
        int state = 0;
        ReentrantReadWriteLock readWriteLock;
        public Demo(){
            readWriteLock = new ReentrantReadWriteLock();
        }
        public synchronized int read(){
            readWriteLock.readLock().lock();
            try {
                return state;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                readWriteLock.readLock().unlock();
            }
            return 0;
        }
        public synchronized void add(){
            readWriteLock.writeLock().lock();
            try {
                state++;
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                readWriteLock.writeLock().unlock();
            }
        }

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
        for (int i = 0; i < 20; i++) {

            new Thread(()->{
                long start = System.currentTimeMillis();
                System.out.println(Thread.currentThread().getName()+" "+demo.read()+" "+(System.currentTimeMillis()-start)+"ms");
            },"read "+i+" :").start();

        }
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                long start = System.currentTimeMillis();
                demo.add();
                System.out.println(Thread.currentThread().getName()+" "+(System.currentTimeMillis()-start)+"ms");
            },"add "+i+" :").start();
        }

    }
}
