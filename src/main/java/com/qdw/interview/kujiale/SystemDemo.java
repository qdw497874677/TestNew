package com.qdw.interview.kujiale;

import java.util.HashMap;
import java.util.Map;

/**
 * @PackageName:com.qdw.kujiale
 * @ClassName: Data
 * @Description:
 * @date: 2020/5/26 0026 10:59
 */
@lombok.Data
public class SystemDemo {

    private Map<Integer,Ticket> mapA;
    private Map<Integer,Ticket> mapB;

    public SystemDemo(){
        mapA = new HashMap<>();
        mapB = new HashMap<>();
    }
    public synchronized Ticket buy(IdCard ic){
        Integer id = ic.getId();
        String name = ic.getName();
        if (mapA.containsKey(id) || mapB.containsKey(id)){
            System.out.println("已经购买过车票");
            return null;
        }else {
            Ticket ticket = new Ticket(id, name);
            mapA.put(id,ticket);
            System.out.println("购买成功 id:"+id+" name:"+name);
            return ticket;
        }
    }


    public boolean check(IdCard ic){
        Ticket t = mapA.get(ic.getId());
        if (t==null){
            System.out.println("没有买票");
            return false;
        }
        Integer id = t.getId();
        String name = t.getName();
        if (mapA.containsKey(id)){
            System.out.println("检票成功");
            mapB.put(id,mapA.get(id));
            mapA.remove(id);
            return true;
        }else {
            if (mapB.containsKey(id)){
                System.out.println("已经检票成功");
                return true;
            }else {
                System.out.println("请先购买车票");
                return false;
            }
        }
    }


    public boolean back(IdCard ic){

        Integer id = ic.getId();
        String name = ic.getName();
        if (mapA.containsKey(id)){
            mapA.remove(id);
            System.out.println("退票成功");
            return true;
        }
        if (mapB.containsKey(id)){
            System.out.println("退票失败：检票后不能退票");
            return false;
        }
        System.out.println("退票失败：没有买票");
        return false;
    }


}
