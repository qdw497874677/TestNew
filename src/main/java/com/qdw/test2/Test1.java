package com.qdw.test2;


//双重检查锁模式的懒汉式单例
public class Test1 {
    private Test1(){}
    private static volatile Test1 TEST1;
    public static Test1 getInstance(){
        if (TEST1 == null){
            synchronized (Test1.class){
                if (TEST1 == null){
                    TEST1 = new Test1();
                }
            }
        }
        return TEST1;
    }

}
