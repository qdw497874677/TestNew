package com.qdw.test2;
//通过枚举实现单例
public enum Test2 {
    INSTANCE;
    public Test2 getInstance(){
        return INSTANCE;
    }
}
