package com.qdw.shejimoshi.gongchang.gongchangfangfa;

public class Test {
    public static void main(String[] args) {
        Factory factoryA = new FactoryA();
        Factory factoryB = new FactoryB();
        Product productA = factoryA.create();
        Product productB = factoryB.create();
        productA.show();
        productB.show();
    }
}
