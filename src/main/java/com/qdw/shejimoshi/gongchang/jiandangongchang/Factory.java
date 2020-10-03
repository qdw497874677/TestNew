package com.qdw.shejimoshi.gongchang.jiandangongchang;

public class Factory {
    Product create(String name){
        if ("A".equals(name)){
            return new ProductA();
        }else if ("B".equals(name)){
            return new ProductB();
        }else {
            return null;
        }
    }
}
