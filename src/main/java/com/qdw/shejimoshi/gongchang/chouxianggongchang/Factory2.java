package com.qdw.shejimoshi.gongchang.chouxianggongchang;

public class Factory2 implements Factory {

    @Override
    public Product createA() {
        return new ProductA2();
    }

    @Override
    public Product createB() {
        return new ProductB2();
    }
}
