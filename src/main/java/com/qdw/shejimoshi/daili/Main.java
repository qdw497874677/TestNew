package com.qdw.shejimoshi.daili;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/19 下午1:37
 */
public class Main {
    public static void main(String[] args) {
        Subject subject = new Proxy();
        subject.setName("qdw");
        System.out.println(subject.getName());
        subject.print("hello world");
    }
}
