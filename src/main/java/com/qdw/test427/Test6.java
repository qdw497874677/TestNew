package com.qdw.test427;

/**
 * @PackageName:com.qdw.test427
 * @ClassName: Test6
 * @Description:
 * @date: 2020/7/2 0002 22:05
 */
class A{
    public Integer doSomeString(){
        return 8401;
    }
}

class B extends A implements C{
    @Override
    public String doSomeInteger() {
        Integer i = super.doSomeString();
        return "\""+String.valueOf(i)+"\"";
    }
}

class B2 implements C{
    private A a;
    public B2(A a){
        this.a = a;
    }
    @Override
    public String doSomeInteger() {
        Integer i = a.doSomeString();
        return "\""+String.valueOf(i)+"\"";
    }
}

interface C{
    String doSomeInteger();
}

public class Test6 {
    public static void main(String[] args) {
//        C c = new B();
        C c = new B2(new A());
        String s = c.doSomeInteger();
        System.out.println(s);

    }
}

