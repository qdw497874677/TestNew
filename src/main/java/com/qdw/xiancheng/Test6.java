package com.qdw.xiancheng;

/**
 * @PackageName:com.qdw.xiancheng
 * @ClassName: Test6
 * @Description:
 * @date: 2020/11/4 0004 9:41
 */
public class Test6 {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("结束了");
        });
        thread.start();
    }
}
