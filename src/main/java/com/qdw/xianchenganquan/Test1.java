package com.qdw.xianchenganquan;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @PackageName:com.qdw.xianchenganquan
 * @ClassName: Test1
 * @Description:
 * @date: 2020/9/22 0022 20:00
 */
public class Test1 {

    ThreadLocal<Integer> threadLocal = new ThreadLocal<>();
//    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor();

    public void ins(){
//        threadPoolExecutor.submit();
//        threadLocal.set(2);
//        StringBuilder
    }
    public void des(){
        threadLocal.set(3);
    }
}
