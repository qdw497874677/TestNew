package com.qdw.yinyong;

import java.lang.ref.WeakReference;
import java.util.Date;

/**
 * @Author: Quandw
 * @Description:
 * @Date: 2020/11/4 0004 14:43
 */


public class Test2 {


    public static void main(String[] args) {
        Key key = new Key(10);
        WeakReference<Key> weakReference = new WeakReference<>(key);
        WeakR weakR = new WeakR(key);
        System.out.println(weakR.get());
        System.gc();
        System.gc();
        System.runFinalization();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(String.valueOf(weakR.get()));
        System.out.println(weakReference.get());
    }
}
class Key{
    int a = 0;
    public Key(int i){
        a = i;
    }
    @Override
    protected void finalize() throws Throwable {
        System.out.println("1111111");
    }
}
class WeakR extends WeakReference<Key> {

    public WeakR(Key key) {
        super(key);
    }


}
