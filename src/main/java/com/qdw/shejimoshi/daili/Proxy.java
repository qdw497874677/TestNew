package com.qdw.shejimoshi.daili;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午7:29
 */
public class Proxy implements Subject {
    private String name;
    private RealSubject realSubject;
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String word) {
        realize();
        realSubject.print(word);
    }

    public synchronized void realize(){
        if (realSubject == null){
            realSubject = new RealSubject(name);
        }
    }
}
