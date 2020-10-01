package com.qdw.mianxiangduixiang;

/**
 * @PackageName:com.qdw.mianxiangduixiang
 * @ClassName: Test1
 * @Description:
 * @date: 2020/9/19 0019 15:26
 */


//class A{
//    void m(){}
//}
//class B {
//    void m1(){}
//}
//class C {
//    void m2(){}
//}
//class D extends B,C{
//
//}
//
//interface X{
//    void m();
//}
//interface Y{
//    int m();
//}
//interface Z1 extends X,Y{
//}
//
//interface X2{
//    void m(int a);
//}
//interface Y2{
//    int m();
//}
//interface Z2 extends X2,Y2{
//}

class A{
    int a;
    private int b;
    int getB(){
        return b;
    }
}

public class Test1 extends A {
    public static void main(String[] args) {
        Test1 test1 = new Test1();
        test1.notify();
        test1.getB();

    }
}
