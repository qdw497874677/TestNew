package com.qdw.shejimoshi.guanchazhe;



/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午3:11
 */
public class ObserverImpl1 implements Observer {

    @Override
    public void update(SubjectAbs subjectAbs) {
        String data = (String) subjectAbs.getData();
        System.out.println("我是1，我收到了更新:"+data);
    }
}
