package com.qdw.test2;

//饿汉式单例
public class Test4 {
    private Test4(){
    }
    private static final Test4 TEST4 = new Test4();
    public static Test4 getInstance(){
        return TEST4;
    }
}
