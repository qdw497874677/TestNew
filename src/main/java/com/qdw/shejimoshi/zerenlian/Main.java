package com.qdw.shejimoshi.zerenlian;

import java.util.Random;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午5:04
 */
public class Main {
    public static void main(String[] args) {

        Random random = new Random(10);

        Hander hander1 = new HanderImpl1("一");
        Hander hander2 = new HanderImpl2("二");
        hander1.setNext(hander2);

        Trouble trouble;
        for (int i = 0; i < 100; i++) {
            trouble = new Trouble(random.nextInt(3));
            hander1.support(trouble);
        }
    }
}
