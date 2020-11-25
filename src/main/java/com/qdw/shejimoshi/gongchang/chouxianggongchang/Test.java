package com.qdw.shejimoshi.gongchang.chouxianggongchang;

public class Test {
    public static void main(String[] args) {
        Factory factory1 = new Factory1();
        Factory factory2 = new Factory2();
        Product productA1 = factory1.createA();
        Product productB1 = factory1.createB();
        Product productA2 = factory2.createA();
        Product productB2 = factory2.createB();
        productA1.show();
        productA2.show();
        productB1.show();
        productB2.show();
    }
}
