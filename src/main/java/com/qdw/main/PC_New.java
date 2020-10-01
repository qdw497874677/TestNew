package com.qdw.main;

import java.sql.Time;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class PC_New {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource(new ArrayBlockingQueue<String>(3));
        new Thread(()->{
            try {
                resource.producer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T1").start();
        new Thread(()->{
            try {
                resource.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },"T2").start();

        TimeUnit.SECONDS.sleep(10);
        resource.stop();
        System.out.println("生产消费停止");
    }
}
class Resource{
    //貌似这个volatile在这里作用不大
    private volatile boolean flag = true;
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    private BlockingQueue<String> blockingQueue;
    public Resource(BlockingQueue<String> blockingQueue){
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }
    public void stop(){
        flag = false;
    }
    public void producer() throws InterruptedException {
        String data;
        while (flag){
            TimeUnit.SECONDS.sleep(1);
            data = atomicInteger.incrementAndGet() + "";
            blockingQueue.put(data);
            System.out.println(Thread.currentThread().getName()+" 生产"+data+" 总数："+blockingQueue.size());
        }
        System.out.println(Thread.currentThread().getName()+" 生产停止");
    }

    public void consumer() throws InterruptedException {
        String res;
        while (flag){
            TimeUnit.SECONDS.sleep(1);
            res = blockingQueue.take();
            System.out.println(Thread.currentThread().getName()+" 消费"+res+" 总数："+blockingQueue.size());
        }
        System.out.println(Thread.currentThread().getName()+" 消费停止");
    }
}
