package com.qdw.shejimoshi.gongchang.gongchangfangfa;

public class FactoryB implements Factory {
    @Override
    public Product create() {
        return new ProductB();
    }
}
