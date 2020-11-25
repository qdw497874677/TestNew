package com.qdw.jihe;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @PackageName:com.qdw.jihe
 * @ClassName: Test1
 * @Description:
 * @date: 2020/9/16 0016 16:31
 */
public class Test1 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(6);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
//        Iterator<Integer> iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//            iterator.remove();
//        }
//
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.get(i));
//            list.remove(i--);
//        }
        Iterator<Integer> iterator = list.iterator();

        for (int i = list.size()-1; i >=0 ; i--) {
            System.out.println(list.get(i));
            list.remove(i);
        }

        System.out.println("size:"+list.size());
    }
}
