package com.qdw.shejimoshi.zerenlian;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午3:52
 */
public abstract class Hander {
    String name;
    private Hander next;
    public Hander(String name){
        this.name = name;
    }

    abstract public boolean resolve(Trouble trouble);

    protected Hander setNext(Hander hander){
        next = hander;
        return next;
    }
    public final void support(Trouble trouble){
        if (resolve(trouble)){
            done(trouble);
        }else if (next != null){
            next.support(trouble);
        }else {
            fail(trouble);
        }
    }
    abstract public void done(Trouble trouble);
    abstract public void fail(Trouble trouble);
}
