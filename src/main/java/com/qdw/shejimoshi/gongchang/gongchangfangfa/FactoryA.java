package com.qdw.shejimoshi.gongchang.gongchangfangfa;

public class FactoryA implements Factory {
    @Override
    public Product create() {
        return new ProductA();
    }
}
