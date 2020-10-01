package com.qdw.interview;

import java.util.Collections;
import java.util.HashMap;

/**
 * @PackageName:com.qdw.interview
 * @ClassName: Test5
 * @Description:
 * @date: 2020/5/27 0027 18:56
 */
public class Test5 {
    private String s = "qdw";
    private InnerClass getInstance(){
        InnerClass innerClass = new InnerClass();

        return innerClass;
    }


    static class InnerClass{

        private String s = "inner";
        private void m(){
            System.out.println("iiiii");
        }
    }

    public static void main(String[] args) {
        Test5 test5 = new Test5();
        InnerClass instance = test5.getInstance();
        System.out.println(instance.s);
        instance.m();

    }
}
