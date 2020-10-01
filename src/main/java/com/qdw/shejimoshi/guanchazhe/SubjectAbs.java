package com.qdw.shejimoshi.guanchazhe;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午2:42
 */
public abstract class SubjectAbs {
    private List<Observer> observers;
    public SubjectAbs(){
        observers = new ArrayList<Observer>();
    }
    public void attach(Observer observer){
        observers.add(observer);
    }
    public void detach(Observer observer){
        observers.remove(observer);
    }
    protected void notifyObs(){
        Iterator<Observer> iterator = observers.iterator();
        while (iterator.hasNext()){
            iterator.next().update(this);
        }
    }
    abstract public Object getData();
    abstract public void execute();
}
