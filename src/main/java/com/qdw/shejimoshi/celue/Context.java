package com.qdw.shejimoshi.celue;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午6:26
 */
public class Context {
    Strategy strategy;
    Integer[] arr;
    public Context(Strategy strategy,Integer[] arr){
        this.strategy = strategy;
        this.arr = arr;
    }
    public void start(){
        strategy.setData(arr);
        strategy.sort();
        strategy.print();
    }
}
