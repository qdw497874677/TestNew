package com.qdw.test2;
//通过静态内部类实现单例
public class Test3 {
    private Test3(){}
    private static class InnerClass{
        private static Test3 TEST3 = new Test3();
    }
    public static Test3 getInstance(){
        return InnerClass.TEST3;
    }
}
