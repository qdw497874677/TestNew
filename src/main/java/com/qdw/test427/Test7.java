package com.qdw.test427;

/**
 * @PackageName:com.qdw.test427
 * @ClassName: Test7
 * @Description:
 * @date: 2020/7/2 0002 22:17
 */
public class Test7 {
    public static void main(String[] args) {
        Builder builderA = new BuilderA();
        Builder builderB = new BuilderB();
        Director director = new Director(builderA);
        director.build();
        builderA.print();
    }
}

abstract class  Builder{
    public abstract void doSome(String s);
    public abstract void close();
    public abstract void print();
}

class Director{
    private Builder builder;
    public Director(Builder builder){
        this.builder = builder;
    }

    public void build(){
        builder.doSome("hello");
        builder.close();
    }
}

class BuilderA extends Builder{
    private String s;
    @Override
    public void doSome(String s) {
        this.s = "("+s+")";

    }
    @Override
    public void close() {
        s = s+"!";
    }

    @Override
    public void print() {
        System.out.println(s);
    }
}

class BuilderB extends Builder{
    private String s;
    @Override
    public void doSome(String s) {
        this.s = "<"+s+">";

    }
    @Override
    public void close() {
        s = s+"?";
    }

    @Override
    public void print() {
        System.out.println(s);
    }
}
