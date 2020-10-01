package com.qdw.Test3;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test3 {
    public static void main(String[] args) {
//        User z3 = new User("z3");
//        User l4 = new User("l4");
//        AtomicReference<User> atomicUser = new AtomicReference<User>();
//        atomicUser.set(z3);
//        System.out.println(atomicUser.compareAndSet(z3,l4)+" "+atomicUser.toString());
//        System.out.println(atomicUser.compareAndSet(z3,l4)+" "+atomicUser.toString());


        AtomicStampedReference<Integer> atomicStampedReference  = new AtomicStampedReference<>(100,1);
        new Thread(()->{
            //T1先获取版本号，然后没有完成CAS
            int stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"获取版本号："+stamp);
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            boolean b = atomicStampedReference.compareAndSet(100, 200, stamp, stamp + 1);
            System.out.println(Thread.currentThread().getName()+"尝试CAS成功与否："+b+" 当前版本号："+stamp);
        },"T1").start();

        new Thread(()->{
            //T2在T1获取版本号但是没有完成CAS时，也获取了这个值，让后出现ABA
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            int stamp = atomicStampedReference.getStamp();
            Integer temp = 200;
            atomicStampedReference.compareAndSet(100,temp,stamp,stamp+1);
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"执行CAS后，当前版本号："+stamp);
            atomicStampedReference.compareAndSet(temp, 100, stamp, stamp + 1);
            stamp = atomicStampedReference.getStamp();
            System.out.println(Thread.currentThread().getName()+"执行两次CAS，产生一个ABA后，当前版本号："+stamp);
        },"T2").start();
    }
}
@Data
@AllArgsConstructor
class User{
    private String name;
}
