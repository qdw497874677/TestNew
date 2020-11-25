package com.qdw.xuliehua;

import java.io.*;

/**
 * @PackageName:com.qdw.xuliehua
 * @ClassName: Demo
 * @Description:
 * @date: 2020/10/12 0012 21:09
 */
class Father{
    int val;
    public Father(int a){
        val = a;
    }

    @Override
    public String toString() {
        return super.toString()+" "+val;
    }
}
class Demo2 implements Serializable{
    int val;
    public Demo2(int a){
        val = a;
    }
}
public class Demo extends Father implements Serializable {
    int val;
    Demo2 o;
    public Demo(int a){
        super(a);
        val = a;
    }
    @Override
    public String toString() {
        return super.toString()+" "+val+" "+o.toString()+" "+o.val+" 父类："+super.toString();
    }
    public static void main(String[] args) {
        Demo demo = new Demo(1);
        demo.o = new Demo2(2);
        System.out.println(demo.toString());
        try {
            // 序列化
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ObjectOutputStream oos = new ObjectOutputStream(baos);
            oos.writeObject(demo);

            // 反序列化
            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(bais);
            Demo o = (Demo) ois.readObject();
            System.out.println(o.toString());
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
