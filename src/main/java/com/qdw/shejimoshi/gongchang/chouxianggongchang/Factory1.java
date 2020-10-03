package com.qdw.shejimoshi.gongchang.chouxianggongchang;

public class Factory1 implements Factory {

    @Override
    public Product createA() {
        return new ProductA1();
    }

    @Override
    public Product createB() {
        return new ProductB1();
    }
}
