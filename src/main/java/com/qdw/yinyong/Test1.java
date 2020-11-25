package com.qdw.yinyong;

/**
 * @PackageName:com.qdw.yinyong
 * @ClassName: Test1
 * @Description:
 * @date: 2020/10/18 0018 17:07
 */
class A{
    int a;
    public A(int val){
        a = val;
    }
}
public class Test1 {
    public static void main(String[] args) {
        A a = new A(1);
        A a1 = null;
        m(a1);
        System.out.println(a1==null);
    }
    public static void m(A a){
        a = new A(2);

    }
}
