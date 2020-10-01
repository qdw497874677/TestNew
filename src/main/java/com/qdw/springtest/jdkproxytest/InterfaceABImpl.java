package com.qdw.springtest.jdkproxytest;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/19 下午4:59
 */
public class InterfaceABImpl implements InterfaceA,InterfaceB {
    @Override
    public String printA(String a) {
        System.out.println("A:"+a);
        return a;
    }

    @Override
    public String printB(String b) {
        System.out.println("B:"+b);
        return b;
    }
}
