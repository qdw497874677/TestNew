package com.qdw.xiancheng;

import java.util.concurrent.*;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test1
 * @Description:
 * @date: 2020/10/14 0014 13:38
 */
public class Test1 {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        FutureTask<String> futureTask = new FutureTask<>(myThread);
        Thread thread = new Thread(futureTask);
        try {
            thread.start();
            String s = futureTask.get();
            System.out.println(s);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(myThread);
        try {
            System.out.println(submit.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
class MyThread implements Callable<String> {

    @Override
    public String call() throws Exception {

        System.out.println(Thread.currentThread().getId()+":工作。。。");
        return "完成";
    }
}
