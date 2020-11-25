package com.qdw.xiancheng;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test5
 * @Description:
 * @date: 2020/11/4 0004 9:35
 */
public class Test5 {
    public static void main(String[] args) {
        FutureTask<String> futureTask = new FutureTask<>(new myWork());
        Thread thread = new Thread(futureTask);
        thread.start();
        try {
            System.out.println(futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}



class myWork implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "结束了";
    }
}
