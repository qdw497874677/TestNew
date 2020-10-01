package com.qdw.shejimoshi.guanchazhe;



/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午3:11
 */
public class ObserverImpl2 implements Observer {

    @Override
    public void update(SubjectAbs subjectAbs) {
        String data = (String) subjectAbs.getData();
        System.out.println("我是2，我收到了更新:"+data);
    }
}
