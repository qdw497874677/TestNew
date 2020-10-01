package com.qdw.shejimoshi.zerenlian;

/**
 * @Author: xiaomi
 * @Description: TODO
 * @date: 2020/7/18 下午4:57
 */
public class HanderImpl2 extends Hander {

    public HanderImpl2(String name) {
        super(name);
    }

    public String getName(){
        return this.name;
    }

    @Override
    public boolean resolve(Trouble trouble) {
        return trouble.getNum()==2;
    }

    @Override
    public void done(Trouble trouble) {
        System.out.println("hander"+name+" 解决"+trouble.getNum()+"类问题　成功");
    }

    @Override
    public void fail(Trouble trouble) {
        System.out.println("解决"+trouble.getNum()+"类问题　失败");
    }
}
