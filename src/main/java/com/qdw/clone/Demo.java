package com.qdw.clone;

import java.io.Serializable;

/**
 * @PackageName:com.qdw.clone
 * @ClassName: Demo
 * @Description:
 * @date: 2020/10/12 0012 20:29
 */

class Father implements Cloneable {
    int val = 3;
    public Father(){

    }
    public Father(int a){
        val = a;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString()+" "+val+" ";
    }
}
class Demo2 implements Cloneable{
    int val;
    public Demo2(int a){
        val = a;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return super.toString()+" "+val+" ";
    }
}
public class Demo extends Father implements Cloneable {
    int val;
    Demo2 o;
    public Demo(int a){
        super(a);
        val = a;
    }

    public int getFatherVal(){
        return super.val;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Demo res = (Demo)super.clone();
        res.o = (Demo2) o.clone();
        return res;
    }

    @Override
    public String toString() {
        return super.toString()+" "+val+" "+o.toString()+" fatherVal:"+getFatherVal();
    }

    public static void main(String[] args) {
        Demo demo = new Demo(1);
        demo.o = new Demo2(2);
        Demo clone = null;
        try {
            clone = (Demo)demo.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(demo.toString());
        System.out.println(clone.toString());

    }
}
