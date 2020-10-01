package com.qdw.shejimoshi.daili;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午7:23
 */
public class RealSubject implements Subject {
    private String name;
    public RealSubject(String name){
        this.name = name;
        heavyJob();
    }

    private void heavyJob(){
        System.out.print("开始初始化");
        for (int i = 0; i < 6; i++) {
            System.out.print(".");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("初始化完成");
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void print(String word) {
        System.out.println(name+"说:"+word);
    }
}
