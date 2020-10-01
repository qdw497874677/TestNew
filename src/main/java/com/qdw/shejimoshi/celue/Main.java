package com.qdw.shejimoshi.celue;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午6:28
 */
public class Main {
    public static void main(String[] args) {
        Strategy strategy1 = new Strategy1();
        Strategy strategy2 = new Strategy2();

        Integer[] arr = new Integer[]{4,2,6,9,7,1};
        for (int i = 0; i < 10; i++) {
            if (i%2==1){
                Context context = new Context(strategy1, arr);
                context.start();
            }else {
                Context context = new Context(strategy2, arr);
                context.start();
            }
        }
    }
}
