package com.qdw.test;

public class Test5 {
    private Test5(){}
//    private static volatile Test5 TEST5;
//    public static Test5 getInstance(){
//        if (TEST5 == null){
//            synchronized (Test5.class){
//                if (TEST5 == null){
//                    TEST5 = new Test5();
//                }
//            }
//        }
//        return TEST5;
//    }

//    private static final Test5 TEST5 = new Test5();
//    public static Test5 getInstance(){
//        return TEST5;
//    }

    private static class InnerClass{
        private static Test5 TEST5 = new Test5();
    }
    public static Test5 getInstance(){
        return InnerClass.TEST5;
    }
}
