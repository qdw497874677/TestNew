package com.qdw.shejimoshi.gongchang.jiandangongchang;

public class Test {
    public static void main(String[] args) {
        Factory factory = new Factory();
        Product productA = factory.create("A");
        Product productB = factory.create("B");
        productA.show();
        productB.show();
    }
}
