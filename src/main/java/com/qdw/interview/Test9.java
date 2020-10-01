package com.qdw.interview;

import java.util.concurrent.Executors;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test9
 * @Description:
 * @date: 2020/7/14 0014 23:02
 */
public class Test9 {
    public static void main(String[] args) {
        Executors.newCachedThreadPool();
        Executors.newFixedThreadPool(3);
    }
}
